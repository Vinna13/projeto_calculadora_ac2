package calculadora;

public class Calculadora {

    // Soma dois numeros
    public int somar(int a, int b) {
        return a + b;
    }

    // Subtrai b de a
    public int subtrair(int a, int b) {
        return a - b;
    }

    // Multiplica dois numeros
    public int multiplicar(int a, int b) {
        return a * b;
    }

    // Divide a por b, impedindo divisao por zero
    public int dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("Divisão por zero não é permitida.");
        }
        return a / b;
    }

    // Escolhe a operacao conforme o operador informado
    public int calcular(int a, int b, String operador) {
        return switch (operador) {
            case "+" -> somar(a, b);
            case "-" -> subtrair(a, b);
            case "*" -> multiplicar(a, b);
            case "/" -> dividir(a, b);
            default -> throw new IllegalArgumentException("Operador inválido: " + operador);
        };
    }
}
