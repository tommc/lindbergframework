package org.lindbergframework.exemplo;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.beans.di.context.UserBeanContext;
import org.lindbergframework.core.configuration.ClassPathXmlCoreConfiguration;
import org.lindbergframework.core.configuration.CoreConfiguration;
import org.lindbergframework.exemplo.beans.Cep;
import org.lindbergframework.exemplo.beans.Endereco;
import org.lindbergframework.exemplo.beans.Pessoa;
import org.lindbergframework.persistence.transaction.annotation.Transax;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 * 
 */
@Bean("linpTest")
public class LinpTest {
    
    public static void main(String[] args) {
        CoreConfiguration coreConfiguration = new ClassPathXmlCoreConfiguration("org/lindbergframework/exemplo/conf/lindberg-config.xml");
        coreConfiguration.initializeContext();
        
        LinpTest linpTest = UserBeanContext.getInstance().getBean("linpTest");
        
        System.out.println("****** INICIANDO COM DAO ACESSANDO REPOSITORIO ******\n");
        IPessoaDAO pessoaDAORepositorio = UserBeanContext.getInstance().getBean("pessoaDAOAcessandoRepositorio");
        linpTest.test(pessoaDAORepositorio);
        System.out.println("****** FINALIZADO COM DAO ACESSANDO REPOSITORIO ******\n");
        
        System.out.println();
        System.out.println();
        System.out.println();
        
        System.out.println("****** INICIANDO COM DAO SEM ACESSAR REPOSITORIO ******\n");
        IPessoaDAO pessoaDAOSemRepositorio = UserBeanContext.getInstance().getBean("pessoaDAOSemAcessarRepositorio");
        linpTest.test(pessoaDAOSemRepositorio);
        System.out.println("****** FINALIZADO COM DAO SEM ACESSAR REPOSITORIO ******\n");
    }

    //Annotation @Transax define que este método todo será executado dentro de um contexto transacional.
    //Ocorrendo alguma exception rollback é feito.
    @Transax
    public void test(IPessoaDAO pessoaDAO) {
        Pessoa p1 = criarPessoa("João", "12365478900", "Bairro do João", "Rua do joão", 123, "12365-498");
        Pessoa p2 = criarPessoa("Maria", "65432198700", "Bairro da Maria", "Rua da Maria", 456, "98765-890");
        Pessoa p3 = criarPessoa("José", "65465465400", "Rua do José", "Rua do José", 789, "78978-789");
        
        
        pessoaDAO.inserirPessoa(p1);
        System.out.println("Cadastrou Pessoa 1");
        
        pessoaDAO.inserirPessoa(p2);
        System.out.println("Cadastrou Pessoa 2");
        
        pessoaDAO.inserirPessoa(p3);
        System.out.println("Cadastrou Pessoa 3");
        
        int qtdPessoasCadastradas = pessoaDAO.getNumeroPessoasCadastradas();
        System.out.println("TOTAL PESSOAS CADASTRADAS: "+qtdPessoasCadastradas);
        
        qtdPessoasCadastradas = pessoaDAO.getNumeroPessoasCadastradasUsandoFunction();
        System.out.println("TOTAL PESSOAS CADASTRADAS USANDO FUNCTION: "+qtdPessoasCadastradas);
        
        System.out.println("\n*** LISTANDO PESSOAS CADASTRADAS***\n");
        
        List<Pessoa> listaPessoas = pessoaDAO.listarPessoas();
        imprimirPessoas(listaPessoas);
        
        System.out.println("\n*** EXCLUINDO PESSOA 2 [MARIA] ***");
        pessoaDAO.excluirPessoa(p2);
        System.out.println("*** PESSOA 2 [Maria] EXCLUÍDA ***");
        System.out.println("\n*** LISTANDO PESSOAS APÓS EXCLUSÃO DA PESSOA 2 [MARIA] ***");
        listaPessoas = pessoaDAO.listarPessoas();
        imprimirPessoas(listaPessoas);
        
        System.out.println("\n*** CONSULTANDO PESSOA COM CPF 65465465400 ***\n");
        Pessoa pessoaBuscada = pessoaDAO.consultarPessoa("65465465400");
        imprimirPessoa(pessoaBuscada);
        
        System.out.println("\n*** CONSULTANDO PESSOA INEXISTENTE COM CPF 12312312311 ***\n");
        pessoaBuscada = pessoaDAO.consultarPessoa("12312312311");
        imprimirPessoa(pessoaBuscada);
        
        System.out.println("\n*** ATUALIZANDO ENDEREÇO DE PESSOA DE CPF 12365478900 ***\n");
        p1.getEndereco().setBairro("bairro novo");
        p1.getEndereco().setNumero(777);
        p1.getEndereco().setRua("rua nova");
        p1.getEndereco().getCep().setNumero("55555-555");
        pessoaDAO.atualizarEnderecoPessoa(p1);
        
        System.out.println("\n*** LISTANDO PESSOAS APÓS A ATUALIZAÇÃO DO ENDEREÇO DA PESSOA DE CPF 12365478900 ***\n");
        listaPessoas = pessoaDAO.listarPessoas();
        imprimirPessoas(listaPessoas);
        
        System.out.println("\n*** EXCLUINDO PESSOA 1 [JOÃO] ***");
        pessoaDAO.excluirPessoa(p1);
        System.out.println("\n*** LISTANDO PESSOAS APÓS EXCLUSÃO DA PESSOA 1 [JOÃO]***\n");
        listaPessoas = pessoaDAO.listarPessoas();
        imprimirPessoas(listaPessoas);
        
        System.out.println("\n*** EXCLUINDO PESSOA 3 [José] ***");
        pessoaDAO.excluirPessoa(p3);
        System.out.println("\n*** LISTANDO PESSOAS APÓS EXCLUSÃO DA PESSOA 3 [JOSÉ]***\n");
        listaPessoas = pessoaDAO.listarPessoas();
        imprimirPessoas(listaPessoas);
        
        System.out.println("\n*** INICIANDO TESTES COM PROCEDURES E FUNCTIONS ***\n");
        System.out.println("*** RECADASTRANDO PESSOAS ***\n");
        pessoaDAO.inserirPessoa(p1);
        System.out.println("Cadastrou Pessoa 1");
        
        pessoaDAO.inserirPessoa(p2);
        System.out.println("Cadastrou Pessoa 2");
        
        pessoaDAO.inserirPessoa(p3);
        System.out.println("Cadastrou Pessoa 3");
        
        System.out.println("\n*** LISTANDO PESSOAS QUE TEM O NOME QUE INICIAM COM A LETRA 'J' USANDO CURSOR DE SAÍDA DE PROCEDURE ***\n");
        listaPessoas = pessoaDAO.listarPessoasPorIniciaisNomeUsandoProcedure("J");
        imprimirPessoas(listaPessoas);
        
        System.out.println("\n LISTANDO PESSOAS QUE TEM O NOME QUE INICIAM COM A LETRA 'M' USANDO CURSOR RETORNADO COMO RESULTADO DE UMA FUNCTION ***\n");
        listaPessoas = pessoaDAO.listarPessoasPorIniciaisNomeUsandoFunction("M");
        imprimirPessoas(listaPessoas);
        
        System.out.println("\n*** EXCLUINDO PESSOAS QUE TEM O NOME QUE INICIAM COM A LETRA 'M' USANDO FUNCTION\n" +
        		"QUE EXCLUI E RETORNA COMO RESULTADO UM CURSOR COM AS PESSOAS QUE FORAM EXCLUIDAS E RETORNA COMO UM\n" +
        		"PARAMETRO OUT (DE SAIDA) OUTRO CURSOR COM AS PESSOAS QUE NÃO FORAM EXCLUIDAS***\n");
        
        Map map = pessoaDAO.excluirPessoasPorIniciaisRetornandoExcluidosENaoExcluidosUsandoFunction("M");
        List<Pessoa> pessoasExcluidas = (List<Pessoa>) map.get("pessoasexcluidas");
        List<Pessoa> pessoasNaoExcluidas = (List<Pessoa>) map.get("pessoasnaoexcluidas");
        
        System.out.println("\n*** (EXCLUIDOS) LISTANDO PESSOAS QUE FORAM EXCLUIDAS RETORNADAS COMO RESULTADO DA FUNCTION VIA CURSOR ***\n");
        imprimirPessoas(pessoasExcluidas);
        
        System.out.println("\n*** (NÃO EXCLUIDOS) LISTANDO PESSOAS QUE NÃO FORAM EXCLUIDAS RETORNADAS COMO PARAMETRO DE SAÍDA DA FUNCTION VIA CURSOR ***\n");
        imprimirPessoas(pessoasNaoExcluidas);
        
        System.out.println("\n*** EXCLUINDO PESSOAS QUE TEM O NOME QUE INICIAM COM 'JOÃ' USANDO PROCEDURE\n" +
            "QUE EXCLUI E RETORNA 2 CURSORES DE SAÍDA SENDO O PRIMEIRO EXCLUIDOS E O SEGUNDO OS NÃO EXCLUIDOS ***\n");
        
        map = pessoaDAO.excluirPessoasPorIniciaisRetornandoExcluidosENaoExcluidosUsandoProcedure("Joã");
        pessoasExcluidas = (List<Pessoa>) map.get("pessoasexcluidas");
        pessoasNaoExcluidas = (List<Pessoa>) map.get("pessoasnaoexcluidas");
        
        System.out.println("\n*** (EXCLUIDOS) LISTANDO PESSOAS QUE FORAM EXCLUIDAS RETORNADAS COMO CURSOR NO PRIMEIRO PARAMETRO DE DAÍDA DA PROCEDURE) ***\n");
        imprimirPessoas(pessoasExcluidas);
        
        System.out.println("\n*** (NÃO EXCLUIDOS) LISTANDO PESSOAS QUE NÃO FORAM EXCLUIDAS RETORNADAS COMO CURSOR NO SEGUNDO PARAMETRO DE SAÍDA DA PROCEDURE ***\n");
        imprimirPessoas(pessoasNaoExcluidas);
        
        System.out.println("\n*** EXCLUINDO PESSOA RESTANDO [JOSÉ] USANDO PROCEDURE ***\n");
        pessoaDAO.excluirPessoaUsandoProcedure(p3.getCpf());
        
        System.out.println("\n*** LISTANDO PESSOAS APÓS A EXCLUSÃO DA PESSOA RESTANTE 3 [JOSÉ] USANDO PROCEDURE ***\n");
        listaPessoas = pessoaDAO.listarPessoas();
        imprimirPessoas(listaPessoas);
    }
    
    public static void imprimirPessoa(Pessoa pessoa){
        if (pessoa == null)
            System.out.println("!!! PESSOA NÃO ENCONTRADA !!!");
        else
            imprimirPessoas(Arrays.asList(pessoa));
    }
    
    public static void imprimirPessoas(List<Pessoa> listaPessoas){
        if (listaPessoas.isEmpty())
            System.out.println("!!! NENHUMA PESSOA CADASTRADA !!!");
        else
           for (Pessoa p : listaPessoas)
              System.out.println(p+"\n");
    }
    
    public static Pessoa criarPessoa(String nome, String cpf, String bairro, String rua, Integer numero, String numCep){
        Pessoa p = new Pessoa();
        p.setNome(nome);
        p.setCpf(cpf);
        
        Endereco end = new Endereco();
        end.setBairro(bairro);
        end.setRua(rua);
        end.setNumero(numero);
        
        Cep cep = new Cep();
        cep.setNumero(numCep);
        
        end.setCep(cep);
        
        p.setEndereco(end);
        
        return p;
    }
    
    
}
