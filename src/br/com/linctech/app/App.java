package br.com.linctech.app;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import br.com.linctech.dominio.Funcoes;
import br.com.linctech.dominio.OpcoesMenu;
import br.com.linctech.dominio.Pessoa;

/*
 * Foram levantados os seguintes dados de uma população: sexo, altura (em centímetros) e peso.
 * Construa um programa que permita ler os dados de, no máximo, 1000 pessoas. O programa
 * deverá fornecer as seguintes consultas:
 *   • Peso médio
 *   • Altura média
 *   • Sexo da pessoa mais alta
 *   • Altura do homem mais pesado
 *   • Altura da mulher mais pesada
 * As operações devem ser disponibilizadas ao usuário do programa através de um menu de opções.
 */
public class App implements Funcoes {
    private Scanner leia;

    public App() {
        this.leia = new Scanner(System.in);
    }

    public Scanner getLeia() {
        return leia;
    }

    @Override
    public boolean cadastrarDados(List<Pessoa> listPessoas) {
        String altura;
        String peso;
        String sexo;
        boolean eValido;
        Pessoa pessoa = new Pessoa();

        do {
            eValido = false;
            try {
                System.out.print("Altura: ");
                altura = this.getLeia().nextLine();
                pessoa.setAltura(altura);

                eValido = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            try {
                System.out.print("Peso: ");
                peso = this.getLeia().nextLine();
                pessoa.setPeso(peso);

                eValido = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);

        do {
            eValido = false;
            try {
                System.out.print("Sexo: ");
                sexo = this.getLeia().nextLine();
                pessoa.setSexo(sexo);

                eValido = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (eValido == false);
        return listPessoas.add(pessoa);
    }

    @Override
    public double calcularPesoMedio(List<Pessoa> listPessoas) throws Exception {
        Pessoa pessoa;
        double somaPeso = 0;

        if (listPessoas.size() == 0)
            throw new Exception("Não há pessoas cadastradas!");

        Iterator<Pessoa> p = listPessoas.iterator();
        while (p.hasNext()) {
            pessoa = p.next();
            somaPeso += pessoa.getPeso();
        }
        return somaPeso / listPessoas.size();
    }

    @Override
    public double calcularAlturaMedia(List<Pessoa> listPessoas) throws Exception {
        Pessoa pessoa;
        double somaAltura = 0;

        if (listPessoas.size() == 0)
            throw new Exception("Não há pessoas cadastradas!");

        Iterator<Pessoa> p = listPessoas.iterator();
        while (p.hasNext()) {
            pessoa = p.next();
            somaAltura += pessoa.getAltura();
        }
        return somaAltura / listPessoas.size();
    }

    @Override
    public String obterSexoPessoaMaisAlta(List<Pessoa> listPessoas) throws Exception {
        Pessoa pessoa;
        String sexo = null;
        double maisAlta = -1;

        if (listPessoas.size() == 0)
            throw new Exception("Não há pessoas cadastradas!");

        Iterator<Pessoa> p = listPessoas.iterator();
        while (p.hasNext()) {
            pessoa = p.next();
            if (pessoa.getAltura() > maisAlta) {
                maisAlta = pessoa.getAltura();
                sexo = pessoa.getSexo();
            }
        }
        return sexo;
    }

    @Override
    public double obterAlturaHomemMaisPesado(List<Pessoa> listPessoas) throws Exception {
        Pessoa pessoa;
        double altura = -1;
        double homemMaisPesado = -1;

        if (listPessoas.size() == 0)
            throw new Exception("Não há pessoas cadastradas!");

        Iterator<Pessoa> p = listPessoas.iterator();
        while (p.hasNext()) {
            pessoa = p.next();
            if (pessoa.getSexo().equals("MASCULINO") && pessoa.getPeso() > homemMaisPesado) {
                homemMaisPesado = pessoa.getPeso();
                altura = pessoa.getAltura();
            }
        }
        return altura;
    }

    @Override
    public double obterAlturaMulherMaisPesada(List<Pessoa> listPessoas) throws Exception {
        Pessoa pessoa;
        double altura = -1;
        double mulherMaisPesada = -1;

        if (listPessoas.size() == 0)
            throw new Exception("Não há pessoas cadastradas!");

        Iterator<Pessoa> p = listPessoas.iterator();
        while (p.hasNext()) {
            pessoa = p.next();
            if (pessoa.getSexo().equals("FEMININO") && pessoa.getPeso() > mulherMaisPesada) {
                mulherMaisPesada = pessoa.getPeso();
                altura = pessoa.getAltura();
            }
        }
        return altura;
    }

    @Override
    public void listarDados(List<Pessoa> listPessoas) throws Exception {
        Pessoa pessoa;

        if (listPessoas.size() == 0)
            throw new Exception("Não há pessoas cadastradas!");

        Collections.sort(listPessoas);
        Iterator<Pessoa> p = listPessoas.iterator();
        System.out.println("Altura \tPeso \t\tSexo");
        while (p.hasNext()) {
            pessoa = p.next();
            System.out.print(String.format("%.2f m", pessoa.getAltura()) + "\t");
            System.out.print(String.format("%.2f kg", pessoa.getPeso()) + "\t");
            System.out.println(pessoa.getSexo());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String opcao = "";
        List<Pessoa> listPessoas = new ArrayList<>();
        App app = new App();
        do {
            OpcoesMenu.perguntarOpcaoDesejada();
            opcao = app.getLeia().nextLine();

            switch (opcao) {
            case "1":
                if (app.cadastrarDados(listPessoas))
                    System.out.println("Cadastro realizado!\n");
                break;

            case "2":
                try {
                    app.calcularPesoMedio(listPessoas);
                    double peso = app.calcularPesoMedio(listPessoas);
                    System.out.println("Peso médio: " + peso + " kg\n");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "3":
                try {
                    app.calcularAlturaMedia(listPessoas);
                    double altura = app.calcularAlturaMedia(listPessoas);
                    System.out.println("Altura média: " + altura+ " kg\n");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "4":
                try {
                    String sexo = app.obterSexoPessoaMaisAlta(listPessoas);
                    System.out.println("Sexo da pessoa mais alta: " + sexo + "\n");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "5":
                try {
                    double altura = app.obterAlturaHomemMaisPesado(listPessoas);
                    System.out.println("Altura do homem mais pesado: " + altura + " m\n");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "6":
                try {
                    double altura = app.obterAlturaMulherMaisPesada(listPessoas);
                    System.out.println("Altura da mulher mais pesada: " + altura + " m\n");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;

            case "7":
                try {
                    app.listarDados(listPessoas);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                break;
            
            case "8":
                System.out.println("Programa encerrado!\n");
                break;

            default:
                System.out.println("Opção inválida!\n");
                break;
        }

        } while (!opcao.equals("8"));
    }
}