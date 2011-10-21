package org.lindbergframework.exemplo;

import java.util.List;
import java.util.Map;

import org.lindbergframework.exemplo.beans.Pessoa;

/**
 * 
 * @author Victor Lindberg
 * 
 */
public interface IPessoaDAO {

    public abstract List<Pessoa> listarPessoas();

    public abstract void inserirPessoa(Pessoa pessoa);

    public abstract void excluirPessoa(Pessoa pessoa);

    public abstract Pessoa consultarPessoa(String cpf);

    public abstract void atualizarEnderecoPessoa(Pessoa pessoa);

    public abstract List<Pessoa> listarPessoasPorIniciaisNomeUsandoProcedure(
        String exemploNome);

    public abstract void excluirPessoaUsandoProcedure(String cpf);

    public abstract List<Pessoa> listarPessoasPorIniciaisNomeUsandoFunction(
        String exemploNome);

    public abstract Map excluirPessoasPorIniciaisRetornandoExcluidosENaoExcluidosUsandoFunction(
        String exemploNome);

    public abstract Map excluirPessoasPorIniciaisRetornandoExcluidosENaoExcluidosUsandoProcedure(
        String exemploNome);

}