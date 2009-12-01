package br.com.lindbergframework.validation.impl;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IDocumentValidation;

/**
 * Implementa a validação de CPF
 * 
 * @author Victor Lindberg
 *
 */
@Component("cpfValidation")
public class CpfValidation implements IDocumentValidation<String>{
	
    
	public void validate(String cpf) throws ValidationException {
	       if (cpf != null && ! validarCPF(cpf))
	    	   throw new ValidationException("CPF inválido");
	}
	
	/**
	 * Efetua a verificação de o número passado como argumento corresponde a um cpf valido
	 */
	private static String calcDigVerif(String num) {   
        Integer primDig, segDig;   
        int soma = 0, peso = 10;   
        for (int i = 0; i < num.length(); i++)   
                soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;   
  
        if (soma % 11 == 0 | soma % 11 == 1)   
            primDig = new Integer(0);   
        else  
            primDig = new Integer(11 - (soma % 11));   
  
        soma = 0;   
        peso = 11;   
        for (int i = 0; i < num.length(); i++)   
                soma += Integer.parseInt(num.substring(i, i + 1)) * peso--;   
           
        soma += primDig.intValue() * 2;   
        if (soma % 11 == 0 | soma % 11 == 1)   
            segDig = new Integer(0);   
        else  
            segDig = new Integer(11 - (soma % 11));   
  
        return primDig.toString() + segDig.toString();   
    }   
  
    public boolean validarCPF(String cpf) {   
        if (cpf.length() != 11)   
            return false;   
  
        String numDig = cpf.substring(0, 9);   
        return calcDigVerif(numDig).equals(cpf.substring(9, 11));   
    }
    
}
