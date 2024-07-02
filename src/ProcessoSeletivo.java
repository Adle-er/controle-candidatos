import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    // Este é o início da definição da classe 'ProcessoSeletivo'.

    public static void main(String[] args) throws Exception {
        // Este é o método principal que o Java executa. É o ponto de entrada do
        // programa.
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO" };
        // Aqui, definimos um array de strings chamado 'candidatos' com nomes de
        // candidatos.

        for (String candidato : candidatos) {
            // Este é um loop 'for-each' que percorre cada elemento do array 'candidatos'.
            entrandoEmContato(candidato);
            // Chama o método 'entrandoEmContato' para cada candidato.
        }
    }

    static void entrandoEmContato(String candidato) {
        // Este método tenta entrar em contato com um candidato.
        int tentativasRealizadas = 1;
        // Inicializa a variável 'tentativasRealizadas' para contar quantas tentativas
        // foram feitas.
        boolean continuarTentando = true;
        // Define uma variável booleana 'continuarTentando' como verdadeira.
        boolean atendeu = false;
        // Define uma variável booleana 'atendeu' como falsa.

        do {
            // Inicia um loop 'do-while' que vai tentar entrar em contato até três vezes.
            atendeu = atender();
            // Chama o método 'atender' e atribui seu retorno à variável 'atendeu'.
            continuarTentando = !atendeu;
            // Define 'continuarTentando' como o oposto de 'atendeu'.

            if (continuarTentando)
                // Se ainda precisamos continuar tentando...
                tentativasRealizadas++;
            // Incrementa o número de tentativas realizadas.
            else
                System.out.println("Contato realizado com sucesso!");
            // Se o contato foi bem-sucedido, imprime uma mensagem de sucesso.
        } while (continuarTentando && tentativasRealizadas < 3);
        // Continua tentando enquanto 'continuarTentando' for verdadeiro e menos de 3
        // tentativas foram feitas.

        if (atendeu)
            // Se o candidato atendeu...
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa.");
        // Imprime uma mensagem informando o sucesso.
        else
            System.out
                    .println("Não conseguimos contato com " + candidato + ", número máximo de tentativas realizadas.");
        // Se o candidato não atendeu, imprime uma mensagem de falha.
    }

    static boolean atender() {
        // Este método simula a tentativa de entrar em contato com o candidato.
        return new Random().nextInt(3) == 1;
        // Retorna verdadeiro se um número aleatório entre 0 e 2 for igual a 1,
        // simulando a resposta do candidato.
    }

    static void imprimirSelecionados() {
        // Este método imprime os candidatos e seus índices.
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO" };
        // Define novamente o array de candidatos.
        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento");
        // Imprime uma mensagem explicativa.

        for (int indice = 0; indice < candidatos.length; indice++) {
            // Loop que percorre o array de candidatos usando índices.
            System.out.println("O candidato de nº " + (indice + 1) + " é " + candidatos[indice]);
            // Imprime o índice (iniciado em 1) e o nome do candidato correspondente.
        }
    }

    static void selecaoCandidatos() {
        // Este método seleciona candidatos com base em seus salários pretendidos.
        String[] candidatos = { "FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA",
                "DANIELA", "JORGE" };
        // Define um array maior de candidatos.
        int candidatosSelecionados = 0;
        // Inicializa o contador de candidatos selecionados.
        int candidatosAtual = 0;
        // Inicializa o índice do candidato atual.
        double salarioBase = 2000.0;
        // Define o salário base.

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            // Loop que continua até selecionar 5 candidatos ou percorrer todos os
            // candidatos.
            String candidato = candidatos[candidatosAtual];
            // Obtém o candidato atual.
            double salarioPretendido = valorPretendido();
            // Obtém um valor de salário pretendido aleatório.

            System.out.println("O candidato " + candidato + " Solicitou este valor de salário " + salarioPretendido);
            // Imprime o candidato e o salário pretendido.

            if (salarioBase >= salarioPretendido) {
                // Se o salário base for maior ou igual ao salário pretendido...
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga!");
                // Imprime que o candidato foi selecionado.
                candidatosSelecionados++;
                // Incrementa o contador de candidatos selecionados.
            }
            candidatosAtual++;
            // Passa para o próximo candidato.
        }
    }

    static double valorPretendido() {
        // Este método retorna um valor de salário pretendido aleatório entre 1800 e
        // 2200.
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        // Este método analisa o salário pretendido de um candidato.
        double salarioBase = 2000.0;
        // Define o salário base.

        if (salarioBase > salarioPretendido) {
            // Se o salário base for maior que o salário pretendido...
            System.out.println("Ligar para o candidato!");
            // Imprime que deve ligar para o candidato.
        } else if (salarioBase == salarioPretendido) {
            // Se o salário base for igual ao salário pretendido...
            System.out.println("Ligar para o candidato com contra proposta.");
            // Imprime que deve ligar para o candidato com uma contra proposta.
        } else {
            // Se o salário base for menor que o salário pretendido...
            System.out.println("Aguardando o resultado dos demais candidatos.");
            // Imprime que está aguardando o resultado dos outros candidatos.
        }
    }
}
