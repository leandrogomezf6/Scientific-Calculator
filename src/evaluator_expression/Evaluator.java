package evaluator_expression;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 *
 * @author Leandro Gómez.
 * @version 2.0.0
 */
public class Evaluator {

    private static HashMap<String, Integer> precedence;
    private static List<String> posfixExpresion;
    private static double ans = 0;

    public Evaluator(String expression) {

    // Precedencia de los operadores aritméticos.
        precedence = new HashMap<>();
        precedence.put("+", 1);
        precedence.put("-", 1);
        precedence.put("x", 2);
        precedence.put("÷", 2);
        precedence.put("^", 3);
        precedence.put("√", 3);
        precedence.put("sin", 4);
        precedence.put("cos", 4);
        precedence.put("tan", 4);
        precedence.put("csc", 4);
        precedence.put("sec", 4);
        precedence.put("cot", 4);
        precedence.put("arcsin", 4);
        precedence.put("arccos", 4);
        precedence.put("arctan", 4);

        infixToPostfix(tokenizer(expression));
    }
    
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

    private boolean isCharANumber(char token) {
        return Character.isDigit(token);
    }

    private boolean isStringANumber(String token) {
        try {
            Double.valueOf(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isOperator(String token) {
        return precedence.containsKey(token);
    }

    private boolean isTrigonometricFunction(String function) {
        return switch (function) {
            case "sin" -> true;
            case "cos" -> true;
            case "tan" -> true;
            case "csc" -> true;
            case "sec" -> true;
            case "cot" -> true;
            case "arcsin" -> true;
            case "arccos" -> true;
            case "arctan" -> true;
            default -> false;
        };
    }
}
