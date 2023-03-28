package br.com.linctech.app;

import java.util.List;

import br.com.linctech.dominio.Funcoes;
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
    public static void main(String[] args) {

    }

    @Override
    public boolean cadastrarDados(List<Pessoa> listPessoas) {
        return false;
    }

    @Override
    public double calcularPesoMedio(List<Pessoa> listPessoas) {
        return 0;
    }

    @Override
    public String obterSexoPessoaMaisAlta(List<Pessoa> listPessoas) {
        return null;
    }

    @Override
    public String obterAlturaHomemMaisPesado(List<Pessoa> listPessoas) {
        return null;
    }

    @Override
    public String obterAlturaMulherMaisPesada(List<Pessoa> listPessoas) {
        return null;
    }

    @Override
    public boolean listarDados(List<Pessoa> listPessoas) {
        return false;
    }
}