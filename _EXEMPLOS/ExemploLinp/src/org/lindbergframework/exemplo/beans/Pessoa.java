package org.lindbergframework.exemplo.beans;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public class Pessoa {
    
    private String nome;
    
    private String cpf;
    
    private Endereco endereco;
    
    /**
     * Construtor padrão.
     */
    public Pessoa() {
        //
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s\nCpf:%s\nEndereço:\n   Bairro:%s\n   " +
        		"Rua:%s\n   Número:%d\n   Cep:%s", nome, cpf, endereco.getBairro(),
        		                                   endereco.getRua(), endereco.getNumero(),
        		                                   endereco.getCep().getNumero());
    }
}
