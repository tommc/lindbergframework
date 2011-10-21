package org.lindbergframework.exemplo;

import java.util.List;

import org.lindbergframework.beans.di.annotation.Bean;
import org.lindbergframework.beans.di.annotation.Inject;
import org.lindbergframework.exemplo.beans.Pessoa;
import org.lindbergframework.persistence.transaction.annotation.Transax;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 * 
 */
@Bean("pessoaTransaction")
public class PessoaTransaction {
    
    @Inject("pessoaDAOAcessandoRepositorio")
    private IPessoaDAO pessoaDAO;
    
    public void test(){
        Pessoa p = LinpTest.criarPessoa("Pedro", "88888888888", "Bairro do Pedro", "Rua do Pedro", 333, "33333-333");
        pessoaDAO.inserirPessoa(p);
        System.out.println("Cadastrou Pessoa [PEDRO] fora de transação");
        try{
           testTransaction();
        }catch(RuntimeException ex){
            ex.printStackTrace();
        }
        System.out.println("\n*** LISTANDO PESSOAS CADASTRADAS APÓS O ROLLBACK DA TRANSAÇÃO ***\n");
        List<Pessoa> listaPessoas = pessoaDAO.listarPessoas();
        LinpTest.imprimirPessoas(listaPessoas);
        
        System.out.println("\n*** EXCLUINDO PESSOA [PEDRO] ***\n");
        pessoaDAO.excluirPessoa(p);
    }

     //Annotation @Transax define que este método todo será executado dentro de um contexto transacional.
    //Isso fará com que quando a exception for lançada o rollback seja feito.
    //Essa annotation possui escopo de método e de classe.
    @Transax
    public void testTransaction() {
        System.out.println("\n*** INICIANDO CONTEXTO TRANSACIONAL ***\n");
        
        Pessoa p1 = LinpTest.criarPessoa("João", "12365478900", "Bairro do João", "Rua do joão", 123, "12365-498");
        Pessoa p2 = LinpTest.criarPessoa("Maria", "65432198700", "Bairro da Maria", "Rua da Maria", 456, "98765-890");
        Pessoa p3 = LinpTest.criarPessoa("José", "65465465400", "Rua do José", "Rua do José", 789, "78978-789");
        
        pessoaDAO.inserirPessoa(p1);
        System.out.println("Cadastrou Pessoa [JOÃO] dentro de uma transaçao");
        
        pessoaDAO.inserirPessoa(p2);
        System.out.println("Cadastrou Pessoa [MARIA] dentro de uma transaçao");
        
        pessoaDAO.inserirPessoa(p3);
        System.out.println("Cadastrou Pessoa [JOSÉ] dentro de uma transaçao");
        
        System.out.println("\n*** LISTANDO PESSOAS CADASTRADAS***\n");
        
        List<Pessoa> listaPessoas = pessoaDAO.listarPessoas();
        LinpTest.imprimirPessoas(listaPessoas);
        
        System.out.println("\n*** LANÇANDO EXCEPTION PARA QUE A TRANSAÇÃO SOFRA ROLLBACK ***\n");
        throw new RuntimeException();//fará com que a transação sofra rollback
    }
}
