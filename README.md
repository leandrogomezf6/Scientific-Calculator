# Scientific-Calculator
Esta calculadora científica utiliza el algoritmo Shunting Yard, creado por el famoso científico de la computación Edsger Dijkstra. El objetivo principal de este algoritmo es convertir una expresión matemática en notación infija (la forma habitual en la que escribimos las expresiones matemáticas, como "3 + 3 x 4 - 10") a una notación posfija o notación polaca inversa (por ejemplo, "3 3 4 * + 10 -"). Esta conversión facilita la evaluación de la expresión para una computadora.

![imgScientificCalculator-2.0](https://github.com/leandrogomezf6/Scientific-Calculator/blob/main/imgScientificCalculator-2.0.png)

Haciendo uso de un algoritmo personalizado denominado "Sorting Buffer" para formatear y tokenizar la expresion de entrada facilitando su conversion a notacion posfija.

## Como se evalua la expresion

Primero la exprecion es leida y tokenizada mediante el algoritmo "Sorting Buffer" que permite identificar cualquier numero real y funcion trigonometrica de la siguiente manera:

### Descripción del Algoritmo

El algoritmo sigue una serie de reglas para procesar cada expresión de manera correcta y eficiente.

### 1. **Entrada**:
   - Una cadena de texto que representa una expresión matemática.
   - Ejemplo de expresión: `"3 + 5 x sin(30)"`

### 2. **Reglas de Procesamiento**:

#### 2.1 **Tokenización de la expresión**
   1. Iniciar un bucle que recorre cada carácter de la expresión:
      - Para cada carácter, seguir las siguientes reglas:

#### 2.2 **Reglas para números**:
   1. Si el carácter actual es un número o un punto decimal:
      - Iniciar un buffer vacío para almacenar el número completo.
      - Mientras se lean dígitos o puntos decimales consecutivos:
         - Agregar el carácter al buffer.
         - Avanzar al siguiente carácter.
      - Cuando finalice el número, agregar el contenido del buffer como un token a la lista `tokens`.
      - Retroceder un carácter para no saltar otros elementos de la expresión.

#### 2.3 **Reglas para funciones trigonométricas**:
   1. Si el carácter actual es una letra y esta es diferente del singno 'x':
      - Extraer una subcadena de 3 caracteres.
      - Si la subcadena corresponde a una función trigonométrica (como "sin", "cos", "tan"):
         - Agregarla como un token a la lista `tokens`.
         - Avanzar 2 posiciones adicionales para saltar la función ya procesada.

#### 2.4 **Reglas para operadores y otros caracteres**:
   1. Si el carácter actual es un operador, paréntesis u otro símbolo:
      - Agregarlo directamente a la lista `tokens` como un token individual.

### 3. **Salida**:
   - Una lista de tokens que representan los componentes de la expresión matemática.
   - Ejemplo de salida: `["3", "+", "5", "x", "sin", "(", "30", ")"]`

``` java
// Algoritmo de tokenización "Sorting Buffer"
    private List<String> tokenizer(String expression) {
        
        // Formatea la expresion corectamente.
        expression = expression.replaceAll("\\s+", "");
        expression = expression.replaceAll("Ans", String.valueOf(ans));
        expression = expression.toLowerCase();

        List<String> tokens = new ArrayList<>();
        int length = expression.length();

        for (int i = 0; i < length; i++) { // Se lee caracter a caracter.
            char currentChar = expression.charAt(i);

            if (isCharANumber(currentChar)) {
                StringBuilder buffer = new StringBuilder(); // Buffer para números reales.

                // Agregar todos los digitos y posibles puntos decimales.
                while (i < length && (isCharANumber(expression.charAt(i))
                        || expression.charAt(i) == '.')) {

                    buffer.append(expression.charAt(i));
                    i++;
                }

                tokens.add(buffer.toString());
                i--; // Retrocede para no saltar el sigiente caracter.

            } else if (Character.isLetter(currentChar) && currentChar != 'x') {
                /*
                 * Si el caracter leido es una letra y esta es diferente del singo "x" entonces,
                 * extraer una subcadena en el rango (i a i+3) y comparar.
                 */
                String function = expression.substring(i, i + 3);
                if (isTrigonometricFunction(function)) {
                    tokens.add(function);
                    i += 2;// Actualiza el caracter actual.
                }

            } else {// Si no es un número, operador o parentesis se agrega directamente.
                tokens.add(String.valueOf(currentChar));
            }
        }
        return tokens;
    }
``` 


### Luego se convierte la expresion de infija a posfija usando el algoritmo Shunting Yard

El método `infixToPostfix` toma una lista de **tokens** que representan números, operadores, paréntesis y funciones trigonometricas en una expresión matemática infija y la convierte en una lista de tokens en notación posfija.

https://es.wikipedia.org/wiki/Algoritmo_shunting_yard

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
    // Algoritmo Shunting Yard.
    private void infixToPostfix(List<String> tokens) {
        List<String> output = new ArrayList<>();
        Stack<String> operators = new Stack<>();

        for (String token : tokens) {
            if (isStringANumber(token)) {// Si es un número se agrega a la salida.
                output.add(token);
            } 
            else if (isOperator(token)) { // Si es un operador aridmetico entonces:
                /*
                 * Mientras que el token sea un operador con menor o igual precedencia que
                 * el operador en el tope de la pila se sacaran operadores de la pila
                 * hasta que el operador con el que se compare tenga menor precedencia.
                 */
                while (!operators.isEmpty() && precedence.containsKey(operators.peek())
                        && precedence.get(token) <= precedence.get(operators.peek())) 
                {
                    output.add(operators.pop());
                }
                operators.push(token);// Añadir el operador luego de la comparación.

                /*
                 * Si la pila de operadores esta vacia entonces, se añade el operador directamente.
                 * Si la pila no esta vacia y el operador recibido tiene mayor precedencia que
                 * el operador del tope de la pila entonces, se añade.
                 */
                if (operators.isEmpty()) {
                    operators.push(token);

                } else if (precedence.get(token) > precedence.get(operators.peek())) {
                    operators.push(token);
                }

                /* 
                 * Si es un paréntesis de apertura entonces, se añade directamente a la pila.
                 * Si es un paréntesis de cierre entonces, se vacia la pila hasta encontrar un
                 * parentecis de apertura.
                 */
            } else if (token.equals("(")) {

                operators.push(token);
            } else if (token.equals(")")) {

                while (!operators.isEmpty() && !operators.peek().equals("(")) {
                    output.add(operators.pop());
                }
                operators.pop();// Se borra el paréntesis de apertura luego de comparar.
            }
        }// fin foreach.

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
   - Se apila en la pila `output`.

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

5. **Si el token es una funcion trigonometrica**:
   - Se extrae un número de la pila que corresponde a una funcion trigonometrica.
   - Se realiza la operación correspondiente según la funcion actual:
     - **Seno (`sin(n)`)**
     - **Coseno (`cos(n)`)**
     - **Tangente (`tan(n)`)**
     - **Cosecante (`csc(n)`)**
     - **Secante (`sec(n)`)**
     - **Cotangente (`cot(n)`)**

6. **Final del proceso**:
   - Al final de la iteración, el último valor en la pila `output` es el resultado de la expresión, que se guarda en la variable `ans` y se devuelve como resultado final.

``` java
    public double evaluateExpression() {
        Stack<Double> output = new Stack<>();

        for (String token : posfixExpresion) {
            if (isStringANumber(token)) {
                output.push(Double.valueOf(token));
            } 
            else if (isOperator(token) && !token.equals("√") 
                    && !isTrigonometricFunction(token)) {

                double b = output.pop();
                double a = output.pop();

                switch (token) {
                    case "+" -> output.push(a + b);
                    case "-" -> output.push(a - b);
                    case "x" -> output.push(a * b);
                    case "÷" -> output.push(a / b);
                    case "^" -> output.push(Math.pow(a, b));
                    default -> throw new AssertionError();
                }
            } 
            else if (token.equals("√")) {
                output.push(Math.sqrt(output.pop()));
            } 
            else if (isTrigonometricFunction(token)) {

                // Convierte el angulo a radianes.
                double radians = Math.toRadians(output.pop());

                switch (token) {
                    case "sin" -> output.push(Math.sin(radians));
                    case "cos" -> output.push(Math.cos(radians));
                    case "tan" -> output.push(Math.tan(radians));
                    // Reciprocas.
                    case "csc" -> output.push(1 / Math.sin(radians));
                    case "sec" -> output.push(1 / Math.cos(radians));
                    case "cot" -> output.push(1 / Math.tan(radians));
                    // Inversas.
                    case "arcsin" -> output.push(Math.asin(radians));
                    case "arccos" -> output.push(Math.acos(radians));
                    case "arctan" -> output.push(Math.atan(radians));
                    default -> throw new AssertionError();
                }
            }
        }// fin foreach.

        ans = output.pop();
        return ans;
    }
```
