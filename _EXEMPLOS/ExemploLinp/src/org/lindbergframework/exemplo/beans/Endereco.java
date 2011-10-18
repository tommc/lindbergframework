package org.lindbergframework.exemplo.beans;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public class Endereco {

    private String bairro;
    
    private String rua;
    
    private Integer numero;
    
    private Cep cep;
    
    /**
     * Construtor padrão.
     */
    public Endereco() {
        //
    }
    
    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Cep getCep() {
        return cep;
    }

    public void setCep(Cep cep) {
        this.cep = cep;
    }

    
}
