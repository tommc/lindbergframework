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
import org.lindbergframework.persistence.sql.SqlFunctionForCursor;
import org.lindbergframework.persistence.sql.SqlOutCursorParam;
import org.lindbergframework.persistence.sql.SqlProcedure;

/**
 * 
 * @author Victor Lindberg
 * 
 */
@Bean("pessoaDAOSemAcessarRepositorio")
public class PessoaDAOSemAcessarRepositorio extends LinpDAO implements IPessoaDAO{

    /**
     * Construtor padrão.
     */
    public PessoaDAOSemAcessarRepositorio() {
        //
    }

    @Override
    public void atualizarEnderecoPessoa(Pessoa pessoa) {
        Endereco endereco = pessoa.getEndereco();
        getPersistTemplate().execSqlUpdate("update pessoa set bairro = ?, rua = ?, " +
        		"numero = ?, numeroCep = ? where cpf = ?", endereco.getBairro(),
                                                           endereco.getRua(),
                                                           endereco.getNumero(),
                                                           endereco.getCep().getNumero(),
                                                           pessoa.getCpf());
    }

    @Override
    public Pessoa consultarPessoa(String cpf) {
        return getPersistTemplate().execSqlQueryForObject(Pessoa.class, 
            "select nome, cpf, bairro as endereco.bairro,"+
            "rua as endereco.rua, numero as endereco.numero,"+ 
            "numeroCep as endereco.cep.numero"+
            " from pessoa where cpf = ?", cpf);
    }

    @Override
    public void excluirPessoa(Pessoa pessoa) {
        getPersistTemplate().execSqlUpdate("delete from pessoa where cpf = ?", pessoa.getCpf());
    }

    @Override
    public void excluirPessoaUsandoProcedure(String cpf) {
        Map mapParam = new HashMap();
        mapParam.put("p_cpf", cpf);
        getPersistTemplate().callProcedure(new SqlProcedure("excluirPessoa"), mapParam);
    }

    @Override
    public Map excluirPessoasPorIniciaisRetornandoExcluidosENaoExcluidosUsandoFunction(
        String exemploNome) {
        SqlFunctionForCursor function = new SqlFunctionForCursor("excPessoasRetornaExcluidosFunc", 
                                               "pessoasexcluidas", 
                                               Pessoa.class, 
                                               new SqlOutCursorParam(Pessoa.class));
        
       Map map = getPersistTemplate().callFunction(function, new SqlArg("nomeexemplo", exemploNome));
       return map;
    }

    @Override
    public Map excluirPessoasPorIniciaisRetornandoExcluidosENaoExcluidosUsandoProcedure(
        String exemploNome) {
        SqlProcedure procedure = new SqlProcedure("excPessoasRetornaExcluidosProc");
        procedure.registerSqlOutCursorsParam(new SqlOutCursorParam(Pessoa.class),
                                             new SqlOutCursorParam(Pessoa.class));
        
        Map map = getPersistTemplate().callProcedure(procedure, new SqlArg("nomeexemplo", exemploNome));
        return map;
    }

    @Override
    public void inserirPessoa(Pessoa pessoa) {
        Endereco endereco = pessoa.getEndereco();
        getPersistTemplate().execSqlUpdate("insert into pessoa values(?,?,?,?,?,?)", 
                                           pessoa.getNome(), pessoa.getCpf(),
                                           endereco.getBairro(), endereco.getRua(), 
                                           endereco.getNumero(), endereco.getCep().getNumero());
    }

    @Override
    public List<Pessoa> listarPessoas() {
        return getPersistTemplate().execSqlQuery(Pessoa.class, "select nome, cpf, bairro as endereco.bairro,"+ 
                                                               "rua as endereco.rua, numero as endereco.numero,"+ 
                                                               "numeroCep as endereco.cep.numero"+
                                                               " from pessoa");
    }

    @Override
    public List<Pessoa> listarPessoasPorIniciaisNomeUsandoFunction(
        String exemploNome) {
        SqlFunctionForCursor function = new SqlFunctionForCursor("listarPessoasPorNomeFunc", 
                                                                 SqlFunction.DEFAULT_RESULT_NAME, 
                                                                 Pessoa.class);
        
        Map parametrosOut = getPersistTemplate().callFunction(function, new SqlArg("nomeexemplo", exemploNome));
        return (List<Pessoa>) parametrosOut.get(SqlFunction.DEFAULT_RESULT_NAME);
    }

    @Override
    public List<Pessoa> listarPessoasPorIniciaisNomeUsandoProcedure(
        String exemploNome) {
        SqlProcedure procedure = new SqlProcedure("listarPessoasPorNomeProc", new SqlOutCursorParam(Pessoa.class));
        Map parametrosOut = getPersistTemplate().callProcedure(procedure, new SqlArg("nomeexemplo", exemploNome));
        return (List<Pessoa>) parametrosOut.get("pessoas");
    }

    public int getNumeroPessoasCadastradas() {
        return getPersistTemplate().execSqlQueryForObject(Integer.class, "select count(*) from pessoa");
    }
    
    public int getNumeroPessoasCadastradasUsandoFunction() {
        SqlFunction function = new SqlFunction("qtdPessoas");
        Map<String,BigDecimal> map = getPersistTemplate().callFunction(function);
        return map.get(SqlFunction.DEFAULT_RESULT_NAME).intValue();
    }

}
