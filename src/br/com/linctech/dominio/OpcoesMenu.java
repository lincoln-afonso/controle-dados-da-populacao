package br.com.linctech.dominio;

public class OpcoesMenu {
    private static void exibirOpcoes() {
       System.out.println("\nMENU");
       System.out.println("1 - CADASTRAR DADOS");
       System.out.println("2 - PESO MÉDIO");
       System.out.println("3 - ALTURA MÉDIA");
       System.out.println("4 - SEXO DA PESSOA MAIS ALTA");
       System.out.println("5 - ALTURA DO HOMEM MAIS PESADO");
       System.out.println("6 - ALTURA DA MULHER MAIS PESADA");
       System.out.println("7 - LISTAR TODOS OS DADOS CADASTRADOS");
       System.out.println("8 - ENCERRAR\n");
    }

    public static void perguntarOpcaoDesejada() {
        OpcoesMenu.exibirOpcoes();
        System.out.print("Informe o número correspondente a opção desejada: ");
    }
}