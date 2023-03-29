package br.com.linctech.dominio;

import java.io.Serializable;

public class Pessoa implements Serializable, Comparable<Pessoa> {
    private static final long serialVersionUID = 1L;
    private double peso;
    private double altura;
    private Sexo sexo;

    public Pessoa() {};

    public Pessoa(String peso, String altura, String sexo) throws Exception {
        this.setAltura(altura);
        this.setPeso(peso);
        this.setSexo(sexo);
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(String peso) throws Exception {
        double valorPeso;

        valorPeso = Double.parseDouble(peso);
        if (valorPeso <= 0)
            throw new Exception("O peso informado é inválido!");
        this.peso = valorPeso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(String altura) throws Exception {
        double valorAltura;

        valorAltura = Double.parseDouble(altura);
        if (valorAltura <= 0)
            throw new Exception("A altura informada é inválida!");
        this.altura = valorAltura;
    }

    public String getSexo() {
        return sexo.toString();
    }

    public void setSexo(String sexo) throws Exception {

        if (!sexo.equalsIgnoreCase("masculino") && !sexo.equalsIgnoreCase("feminino"))
            throw new Exception("Sexo inválido!");
        this.sexo = Sexo.valueOf(sexo.toUpperCase());
    }

    @Override
    public String toString() {
        return "Pessoa [altura=" + this.getAltura() + ", peso=" + this.getPeso() + ", sexo=" + this.getSexo() + "]\n";
    }

    @Override
    public int compareTo(Pessoa pessoa) {
        if (this.getAltura() > pessoa.getAltura())
            return -1;
       
        else if (this.getAltura() < pessoa.getAltura())
            return 1;

        return 0;
    }

   
}