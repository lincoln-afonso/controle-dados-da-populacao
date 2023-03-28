package br.com.linctech.dominio;

import java.util.List;

public interface Funcoes {

    public abstract boolean cadastrarDados(List<Pessoa> listPessoas);

    public abstract double calcularPesoMedio(List<Pessoa> listPessoas);

    public abstract String obterSexoPessoaMaisAlta(List<Pessoa> listPessoas);

    public abstract String obterAlturaHomemMaisPesado(List<Pessoa> listPessoas);

    public abstract String obterAlturaMulherMaisPesada(List<Pessoa> listPessoas);

    public abstract boolean listarDados(List<Pessoa> listPessoas);
}