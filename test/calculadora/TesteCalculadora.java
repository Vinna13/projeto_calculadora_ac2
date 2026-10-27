package calculadora;

/**
 * <p><strong>Testes da Calculadora</strong></p>
 *
 * <p>Classe de teste unitário da classe {@link Calculadora}. Cada teste exibe
 * a entrada utilizada, o resultado esperado e o resultado obtido.</p>
 *
 * @author Vinícius Lima
 * @version 2.0
 */
public class TesteCalculadora {

    /** Quantidade de testes aprovados. */
    static int aprovados = 0;

    /** Quantidade de testes reprovados. */
    static int reprovados = 0;

    /** Calculadora que será testada. */
    static Calculadora calc = new Calculadora();

    /**
     * Executa todos os testes e exibe o resumo final.
     *
     * @param args argumentos de linha de comando (não utilizados)
     */
    public static void main(String[] args) {
        System.out.println("===== TESTES DA CALCULADORA (refatorada) =====");

        testarSoma();
        testarSubtracao();
        testarMultiplicacao();
        testarDivisao();
        testarDivisaoPorZero();
        testarOperacaoInvalida();

        System.out.println("==============================================");
        System.out.println("Aprovados: " + aprovados + " | Reprovados: " + reprovados);
        System.out.println(reprovados == 0 ? "RESULTADO: TODOS OS TESTES PASSARAM" : "RESULTADO: HA TESTES FALHANDO");
    }

    /** Testa a soma (+). */
    static void testarSoma() {
        System.out.println("\n--- SOMA ---");
        verificar(2, 3, "+", 5);
        verificar(-4, 4, "+", 0);
    }

    /** Testa a subtração (-). */
    static void testarSubtracao() {
        System.out.println("--- SUBTRACAO ---");
        verificar(10, 4, "-", 6);
        verificar(3, 8, "-", -5);
    }

    /** Testa a multiplicação (*). */
    static void testarMultiplicacao() {
        System.out.println("--- MULTIPLICACAO ---");
        verificar(3, 5, "*", 15);
        verificar(9, 0, "*", 0);
    }

    /** Testa a divisão (/) com divisor válido. */
    static void testarDivisao() {
        System.out.println("--- DIVISAO ---");
        verificar(8, 2, "/", 4);
        verificar(7, 2, "/", 3);
    }

    /** Testa a divisão por zero, que deve lançar exceção. */
    static void testarDivisaoPorZero() {
        System.out.println("--- DIVISAO POR ZERO ---");
        verificarExcecao(8, 0, "/", "Divisão por zero não é permitida.");
    }

    /** Testa operadores inválidos, que devem lançar exceção. */
    static void testarOperacaoInvalida() {
        System.out.println("--- OPERACAO INVALIDA ---");
        verificarExcecao(5, 5, "x", "Operador inválido: x");
        verificarExcecao(5, 5, "%", "Operador inválido: %");
    }

    /**
     * Compara o resultado de {@code calcular} com o valor esperado.
     *
     * @param a        primeiro operando
     * @param b        segundo operando
     * @param operador operador da operação
     * @param esperado resultado esperado
     */
    static void verificar(int a, int b, String operador, int esperado) {
        System.out.println("Entrada : " + a + " " + operador + " " + b);
        int obtido = calc.calcular(a, b, operador);
        System.out.println("Esperado: " + esperado);
        System.out.println("Obtido  : " + obtido);
        registrar(obtido == esperado);
    }

    /**
     * Verifica se {@code calcular} lança {@link IllegalArgumentException} com a mensagem esperada.
     *
     * @param a                primeiro operando
     * @param b                segundo operando
     * @param operador         operador da operação
     * @param mensagemEsperada mensagem esperada da exceção
     */
    static void verificarExcecao(int a, int b, String operador, String mensagemEsperada) {
        System.out.println("Entrada : " + a + " " + operador + " " + b);
        System.out.println("Esperado: exceção \"" + mensagemEsperada + "\"");
        try {
            int obtido = calc.calcular(a, b, operador);
            System.out.println("Obtido  : " + obtido + " (nenhuma exceção lançada)");
            registrar(false);
        } catch (IllegalArgumentException e) {
            System.out.println("Obtido  : exceção \"" + e.getMessage() + "\"");
            registrar(mensagemEsperada.equals(e.getMessage()));
        }
    }

    /**
     * Registra e exibe o status de um teste.
     *
     * @param passou {@code true} se o teste foi aprovado
     */
    static void registrar(boolean passou) {
        System.out.println("Status  : " + (passou ? "PASSOU" : "FALHOU") + "\n");
        if (passou) {
            aprovados++;
        } else {
            reprovados++;
        }
    }
}
