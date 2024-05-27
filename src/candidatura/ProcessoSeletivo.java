package candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


public class ProcessoSeletivo {
    public static void main(String[] args) {
        analisarCandidato(1900);
        analisarCandidato(2000);
        analisarCandidato(2200);
        selecaoCandidatos();
        imprimirSelecionados();
        String [] selecao = {"Felipe", "Marcia"};
        for (String selecionado: selecao ) {
            entrandoContato(selecionado);;
        }
    }

    static void entrandoContato (String selecionado) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) 
            tentativasRealizadas++;
            else
            System.out.println("Contato realizado " + selecionado);
        }
        while (continuarTentando && tentativasRealizadas<3);

        if (atendeu)
        System.out.println("Conseguimos contato com " + selecionado + " na " + tentativasRealizadas);
        else 
        System.out.println("Não conseguimos contato com o candidato " + selecionado);
        
    }

    static boolean atender () {
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados() {
        String [] selecao = {"Felipe", "Marcia"};

        System.out.println("Imprimindo lista de candidatos selecionados");

        for (int indice = 0; indice < selecao.length; indice++) {
            System.out.println("O candidato de número " + (indice+1) + " é " + selecao[indice]);
        }

        System.out.println("Forma abreviada de interação for each");
        for (String selecionado: selecao ) {
            System.out.println("O candidato selecionado foi " + selecionado);
        }
    }


    static void selecaoCandidatos() {
        String [] candidatos = {"Felipe", "Marcia", "Julia", "Paulo"};

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000;

        while (candidatosSelecionados < 2 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + "solicitou esse salário: " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }


    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000;
        if (salarioBase > salarioPretendido) {
            System.out.println("Ligar para candidato");
        }
        else if (salarioBase == salarioPretendido) {
            System.out.println("Ligar para candidato com contra proposta");
        }
        else {
            System.out.println("Esperar pelos outros candidatos");
        }
    }
}