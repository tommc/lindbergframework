package org.lindbergframework.exemplo;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.exemplo.beans.Endereco;
import org.lindbergframework.exemplo.beans.Pessoa;
import org.lindbergframework.persistence.dao.LinpDAO;
import org.lindbergframework.persistence.sql.SqlArg;
import org.lindbergframework.persistence.sql.SqlFunction;

/**
 * 
 * @author Victor Lindberg
 * 
 */
@Bean("pessoaDAOAcessandoRepositorio")
public class PessoaDAOAcessandoRepositorio extends LinpDAO implements IPessoaDAO{

    /**
     * Construtor padrão.
     */
    public PessoaDAOAcessandoRepositorio() {
        //
    }
    
    public List<Pessoa> listarPessoas(){
        return getPersistTemplate().execQuery(Pessoa.class, "listarPessoas");
    }
    
    public void inserirPessoa(Pessoa pessoa){
        Endereco endereco = pessoa.getEndereco();
        getPersistTemplate().execUpdate("inserirPessoa", pessoa.getNome(), pessoa.getCpf(),
                                                         endereco.getBairro(), endereco.getRua(), 
                                                         endereco.getNumero(), endereco.getCep().getNumero());
    }
    
    public void excluirPessoa(Pessoa pessoa){
        getPersistTemplate().execUpdate("excluirPessoa", pessoa.getCpf());
    }
    
    public Pessoa consultarPessoa(String cpf){
        return getPersistTemplate().execQueryForObject(Pessoa.class, "consultarPessoa", cpf);
    }
    
    public void atualizarEnderecoPessoa(Pessoa pessoa){
        Endereco endereco = pessoa.getEndereco();
        getPersistTemplate().execUpdate("atualizarEnderecoPessoa", endereco.getBairro(),
                                                                   endereco.getRua(),
                                                                   endereco.getNumero(),
                                                                   endereco.getCep().getNumero(),
                                                                   pessoa.getCpf());
    }
    
    public List<Pessoa> listarPessoasPorIniciaisNomeUsandoProcedure(String exemploNome){
        Map parametrosOut = getPersistTemplate().callProcedure("listarPessoasPorIniciaisNomeUsandoProcedure", new SqlArg("NOMEEXEMPLO", exemploNome));
        return (List<Pessoa>) parametrosOut.get("PESSOAS");
    }
    
    public void excluirPessoaUsandoProcedure(String cpf){
        Map mapParam = new HashMap();
        mapParam.put("P_CPF", cpf);
        getPersistTemplate().callProcedure("excluirPessoaUsandoProcedure", mapParam);
    }
    
    public List<Pessoa> listarPessoasPorIniciaisNomeUsandoFunction(String exemploNome){
        Map parametrosOut = getPersistTemplate().callFunction("listarPessoasPorIniciaisNomeUsandoFunction", new SqlArg("NOMEEXEMPLO", exemploNome));
        return (List<Pessoa>) parametrosOut.get(SqlFunction.DEFAULT_RESULT_NAME);
    }
    
    public Map excluirPessoasPorIniciaisRetornandoExcluidosENaoExcluidosUsandoFunction(String exemploNome){
        return getPersistTemplate().callFunction("excPessoasPorIniciaisRetornandoExcluidosENaoExcluidosUsandoFunction", new SqlArg("NOMEEXEMPLO", exemploNome));
    }
    
    public Map excluirPessoasPorIniciaisRetornandoExcluidosENaoExcluidosUsandoProcedure(String exemploNome){
        return getPersistTemplate().callProcedure("excPessoasPorIniciaisRetornandoExcluidosENaoExcluidosUsandoProcedure", new SqlArg("NOMEEXEMPLO", exemploNome));
    }
    
    public int getNumeroPessoasCadastradas(){
        return getPersistTemplate().execQueryForObject(Integer.class, "qtdPessoas");
    }
    
    public int getNumeroPessoasCadastradasUsandoFunction(){
        Map m = getPersistTemplate().callFunction("qtdPessoasUsandoFunction");
        BigDecimal retorno = (BigDecimal) m.get(SqlFunction.DEFAULT_RESULT_NAME);
        return retorno.intValue();
    }
}
