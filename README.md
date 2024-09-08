# Scientific-Calculator
Esta calculadora científica utiliza el algoritmo shunting yard, creado por el famoso científico de la computación Edsger Dijkstra. El objetivo principal de este algoritmo es convertir una expresión matemática en notación infija (la forma habitual en la que escribimos las expresiones matemáticas, como "3 + 3 x 4 - 10") a una notación posfija o notación polaca inversa (por ejemplo, "3 3 4 * + 10 -"). Esta conversión facilita la evaluación de la expresión para una computadora.


Metodos, estructuras de datos y constructor utilizados para evaluar las expresiones:

``` java

    private static HashMap<String, Integer> precedence = new HashMap<>();
    private static List<String> posfixExpresion;
    private static double ans = 0;

    public Evaluator(String expression) {
        
        // Precedencia de los operadores aritméticos.
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("x", 2);
        precedence.put("÷", 2);
        precedence.put("^", 3);
        precedence.put("√", 3);
        
        final List<String> TOKENS = tokenizer(expression);
        infixToPostfix(TOKENS);
    }

private boolean isCharANumber(char token) {
        return Character.isDigit(token);
    }

    private boolean isStringANumber(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return precedence.containsKey(token);
    }
```
## Como se evalua la expresion

### Primero la exprecion es leida y tokenizada mediante un algoritmo personalizado denominado "MathBufferTokenizer" que permite identificar cualquier numero real de la siguiente manera:

- Se itera sobre cada carácter de la expresión usando un ciclo for:
  - Si el carácter actual es un número (incluyendo decimales), se utiliza un StringBuilder como buffer temporal para capturar el número completo:
      - Mientras los caracteres consecutivos sean dígitos o un punto decimal (.), se agregan al buffer.
      -  Una vez que se termina de capturar el número completo, este se agrega a la lista de tokens.
      - El índice del ciclo (i) se retrocede un paso para evitar saltar un carácter importante.
  - Si el carácter actual no es un número, se asume que es un operador, un paréntesis u otro símbolo, por lo que se agrega directamente a la lista de tokens.

 ``` java
    private List<String> tokenizer(String expression) {
        expression = expression.replaceAll("\\s+", "");// Elimina los espacios.
        expression = expression.replaceAll("Ans", String.valueOf(ans));

        List<String> tokens = new ArrayList<>();
        int length = expression.length();

        for (int i = 0; i < length; i++) { // Se lee caracter a caracter.
            char currentChar = expression.charAt(i);

            if (isCharANumber(currentChar)) {
                StringBuilder numberBuffer = new StringBuilder(); // Buffer para números reales.

                // Agregar todos los digitos y posibles puntos decimales.
                while (i < length && (isCharANumber(expression.charAt(i))
                        || expression.charAt(i) == '.')) {

                    numberBuffer.append(expression.charAt(i));
                    i++;
                }
                tokens.add(numberBuffer.toString());
                i--; // Retrocede para no saltar el sigiente caracter.

            } else {
                // Si no es un número se agrega directamente.
                tokens.add(String.valueOf(currentChar));
            }
        }
        return tokens;
    }
 ```

### Luego se convierte la expresion de infija a posfija:

El método `infixToPostfix` toma una lista de **tokens** que representan números, operadores y paréntesis en una expresión matemática infija y la convierte en una lista de tokens en notación posfija.

### Estructuras utilizadas:

- **Lista `output`**: almacena la expresión final en notación posfija.
- **Pila `operators`**: gestiona los operadores y paréntesis mientras se procesa la expresión.

### Funcionamiento paso a paso:

1. **Recorrido de los tokens**:
   Se itera sobre cada token de la lista de entrada.

2. **Si el token es un número**:
   - Se añade directamente a la lista de salida `output`.

3. **Si el token es un operador**:
   - Mientras el operador actual tenga **menor o igual precedencia** que el operador en la cima de la pila, se sacan operadores de la pila y se añaden a la salida.
   - El operador actual se añade a la pila tras sacar todos los de mayor o igual precedencia.

4. **Si el token es un paréntesis de apertura `(`**:
   - Se añade directamente a la pila de operadores.

5. **Si el token es un paréntesis de cierre `)`**:
   - Se sacan todos los operadores de la pila hasta encontrar un paréntesis de apertura `(`, el cual se descarta.

6. **Después de procesar todos los tokens**:
   - Si quedan operadores en la pila, se añaden todos a la salida.

``` java
// Algoritmo "Shunting yard"
    private void infixToPostfix(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        for (String token : tokens) {
            if (isStringANumber(token)) // Si es un número se agrega a la salida.
            {
                output.add(token);

            } else if (isOperator(token)) { // Si es un operador aridmetico entonces:

                /*
                 * Mientras que el token sea un operador con menor o igual precedencia que
                 * el operador en el tope de la pila se sacaran operadores de la pila
                 * hasta que el operador con el que se compare tenga menor precedencia.
                 */
                while (!operators.isEmpty() && precedence.containsKey(operators.peek())
                        && precedence.get(token) <= precedence.get(operators.peek())) {
                    output.add(operators.pop());
                }
                operators.push(token);// Añadir el operador luego de la comparación.

                /*
                 * Si la pila de operadores esta vacia se añade el operador directamente.
                 * Si la pila no esta vacia y el operador recibido tiene mayor precedencia que
                 * el del tope de la pila este se añade.
                 */
                if (operators.isEmpty()) {
                    operators.push(token);

                } else if (precedence.get(token) > precedence.get(operators.peek())) {
                    operators.push(token);
                }

                /* 
                 * Si es un paréntesis de apertura se añade directamente a la pila.
                 * Si es un paréntesis de cierre se vacia la pila hasta encontrar un
                 * parentecis de apertura.
                 */
            } else if (token.equals("(")) {

                operators.push(token);
            } else if (token.equals(")")) {

                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                operators.pop();// Se borra el paréntesis de apertura de la pila.
            }
        }// fin for each.

        /*
         * Si no quedan datos para leer y la pila de operadores no esta vacia entornces,
         * los operadores en ella se vacian en la lista de salida.
         */
        while (!operators.isEmpty()) {
            output.add(operators.pop());
        }

        // Expresión posfija.
        posfixExpresion = output;
    }
```

### Finalmente se evalua la expresión posfija de la siguiente manera:

El método `evaluatorExpression` utiliza una pila para evaluar expresiones matemáticas representadas en notación posfija. Este enfoque simplifica la evaluación, ya que en RPN los operadores siempre vienen después de los operandos.

### Estructuras utilizadas:

- **Pila `output`**: se utiliza para almacenar los operandos y los resultados intermedios de las operaciones.

### Funcionamiento paso a paso:

1. **Recorrido de la expresión posfija**:
   Se itera sobre cada **token** de la expresión posfija, que puede ser un número o un operador.

2. **Si el token es un número**:
   - Se convierte el número de tipo `String` a `Double` y se apila en la pila `output`.

3. **Si el token es un operador binario**:
   - Se extraen los dos últimos números de la pila (`a` y `b`), que corresponden a los operandos.
   - Se realiza la operación correspondiente según el operador actual:
     - **Suma (`+`)**: se suma `a + b` y se apila el resultado.
     - **Resta (`-`)**: se calcula `a - b` y se apila el resultado.
     - **Multiplicación (`x`)**: se calcula `a * b` y se apila el resultado.
     - **División (`÷`)**: se calcula `a / b` y se apila el resultado.
     - **Exponenciación (`^`)**: se calcula `a` elevado a la potencia `b` y se apila el resultado.

4. **Si el token es la raíz cuadrada (`√`)**:
   - Se extrae un número de la pila y se calcula su raíz cuadrada, apilando el resultado.

5. **Final del proceso**:
   - Al final de la iteración, el último valor en la pila `output` es el resultado de la expresión, que se guarda en la variable `ans` y se devuelve como resultado final.

``` java
public double evaluatorExpression() {
        Stack<Double> output = new Stack<>();

        for (String token : posfixExpresion) {
            if (isStringANumber(token)) {
                output.push(Double.parseDouble(token));

            } else if (isOperator(token) && !token.equals("√") ) {

                double b = output.pop();
                double a = output.pop();
                double result = 0;

                switch (token) {
                    case "+":
                        output.push(a + b);
                        break;
                    case "-":
                        output.push(a - b);
                        break;
                    case "x":
                        output.push(a * b);
                        break;
                    case "÷":
                        output.push(a / b);
                        break;
                    case "^":
                        output.push(Math.pow(a, b));
                        break;
                    default:
                        throw new AssertionError();
                }
            } else if (token.equals("√")) {
                output.push(Math.sqrt(output.pop()));
            }
        }// fin for each.

        ans = output.pop();
        return ans;
    }
```
