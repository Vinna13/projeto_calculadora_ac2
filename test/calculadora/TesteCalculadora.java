package calculadora;

public class TesteCalculadora {

    static int aprovados = 0;
    static int reprovados = 0;

    public static void main(String[] args) {
        Calculadora calc = new Calculadora();

        System.out.println("===== TESTES DA CALCULADORA (versao original) =====");

        // Testes rápidos
        testar(calc, 2, 3, "+", 5);    // esperado: 5
        testar(calc, 10, 4, "-", 6);   // esperado: 6
        testar(calc, 3, 5, "*", 15);   // esperado: 15
        testar(calc, 8, 2, "/", 4);    // esperado: 4
        testar(calc, 8, 0, "/", 0);    // divisao por zero
        testar(calc, 5, 5, "x", 0);    // operação inválida

        System.out.println("\nAprovados: " + aprovados + " | Reprovados: " + reprovados);
    }

    // Executa a calculadora e mostra entrada, esperado e obtido
    static void testar(Calculadora calc, int a, int b, String op, int esperado) {
        System.out.println("\nEntrada : a=" + a + ", b=" + b + ", op=\"" + op + "\"");
        int obtido = calc.calc(a, b, op);
        System.out.println("Esperado: " + esperado);
        System.out.println("Obtido  : " + obtido);
        if (obtido == esperado) {
            System.out.println("Status  : PASSOU");
            aprovados++;
        } else {
            System.out.println("Status  : FALHOU");
            reprovados++;
        }
    }
}
