package org.lindbergframework.exemplo;

import java.util.Arrays;
import java.util.List;

import org.lindbergframework.core.configuration.ClassPathXmlCoreConfiguration;
import org.lindbergframework.core.configuration.CoreConfiguration;
import org.lindbergframework.exemplo.beans.Cep;
import org.lindbergframework.exemplo.beans.Endereco;
import org.lindbergframework.exemplo.beans.Pessoa;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 * 
 */
public class LinpTest {

    public static void main(String[] args) {
        CoreConfiguration coreConfiguration = new ClassPathXmlCoreConfiguration("org/lindbergframework/exemplo/conf/lindberg-config.xml");
        coreConfiguration.initializeContext();
        
        PessoaDAO pessoaDAO = new PessoaDAO();
        
        Pessoa p1 = criarPessoa("João", "12365478900", "Bairro do João", "Rua do joão", 123, "12365-498");
        Pessoa p2 = criarPessoa("Maria", "65432198700", "Bairro da Maria", "Rua da Maria", 456, "98765-890");
        Pessoa p3 = criarPessoa("José", "65465465400", "Rua do José", "Rua do José", 789, "78978-789");
        
        pessoaDAO.inserirPessoa(p1);
        System.out.println("Cadastrou Pessoa 1");
        
        pessoaDAO.inserirPessoa(p2);
        System.out.println("Cadastrou Pessoa 2");
        
        pessoaDAO.inserirPessoa(p3);
        System.out.println("Cadastrou Pessoa 3");
        
        System.out.println("\n*** LISTANDO PESSOAS CADASTRADAS***\n");
        
        List<Pessoa> listaPessoas = pessoaDAO.listarPessoas();
        imprimirPessoas(listaPessoas);
        
        System.out.println("\n*** EXCLUINDO PESSOA 2 [Maria] ***");
        pessoaDAO.excluirPessoa(p2);
        System.out.println("*** PESSOA 2 [Maria] EXCLUÍDA ***");
        System.out.println("\n*** LISTANDO PESSOAS APÓS EXCLUSÃO DA PESSOA 2 [Maria] ***");
        listaPessoas = pessoaDAO.listarPessoas();
        imprimirPessoas(listaPessoas);
        
        System.out.println("\n*** CONSULTANDO PESSOA COM CPF 65465465400 ***\n");
        Pessoa pessoaBuscada = pessoaDAO.consultarPessoa("65465465400");
        imprimirPessoa(pessoaBuscada);
        
        System.out.println("\n*** CONSULTANDO PESSOA INEXISTENTE COM CPF 12312312311 ***\n");
        pessoaBuscada = pessoaDAO.consultarPessoa("12312312311");
        if (pessoaBuscada == null)
            System.out.println("!!! PESSOA NÃO ENCONTRADA !!!");
        
        System.out.println("\n*** ATUALIZANDO ENDEREÇO DE PESSOA DE CPF 12365478900 ***\n");
        p1.getEndereco().setBairro("bairro novo");
        p1.getEndereco().setNumero(777);
        p1.getEndereco().setRua("rua nova");
        p1.getEndereco().getCep().setNumero("55555-555");
        pessoaDAO.atualizarPessoa(p1);
        
        System.out.println("\n*** LISTANDO PESSOAS APÓS A ATUALIZAÇÃO DO ENDEREÇO DA PESSOA DE CPF 12365478900 ***\n");
        listaPessoas = pessoaDAO.listarPessoas();
        imprimirPessoas(listaPessoas);
        
        System.out.println("\n*** EXCLUINDO PESSOA 1 [João] ***");
        pessoaDAO.excluirPessoa(p1);
        System.out.println("\n*** LISTANDO PESSOAS APÓS EXCLUSÃO DA PESSOA 1 [João]***\n");
        listaPessoas = pessoaDAO.listarPessoas();
        imprimirPessoas(listaPessoas);
        
        System.out.println("\n*** EXCLUINDO PESSOA 3 [José] ***");
        pessoaDAO.excluirPessoa(p3);
        System.out.println("\n*** LISTANDO PESSOAS APÓS EXCLUSÃO DA PESSOA 3 [José]***\n");
        listaPessoas = pessoaDAO.listarPessoas();
        if (listaPessoas.isEmpty())
            System.out.println("!!! NENHUMA PESSOA CADASTRADA !!!");
        imprimirPessoas(listaPessoas);
    }
    
    public static void imprimirPessoa(Pessoa pessoa){
        imprimirPessoas(Arrays.asList(pessoa));
    }
    
    public static void imprimirPessoas(List<Pessoa> listaPessoas){
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
