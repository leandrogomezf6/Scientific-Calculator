package evaluatorExpression;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author Leandro Gómez.
 * @version 1.0.0
 */
public class Evaluator {

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
}
