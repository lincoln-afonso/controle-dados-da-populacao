package br.com.linctech.dominio;

import java.util.List;

public interface Funcoes {

    public abstract boolean cadastrarDados(List<Pessoa> listPessoas);

    public double calcularAlturaMedia(List<Pessoa> listPessoas) throws Exception;

    public abstract double calcularPesoMedio(List<Pessoa> listPessoas) throws Exception;

    public abstract String obterSexoPessoaMaisAlta(List<Pessoa> listPessoas) throws Exception;

    public abstract double obterAlturaHomemMaisPesado(List<Pessoa> listPessoas) throws Exception;

    public abstract double obterAlturaMulherMaisPesada(List<Pessoa> listPessoas) throws Exception;

    public abstract void listarDados(List<Pessoa> listPessoas) throws Exception;
}