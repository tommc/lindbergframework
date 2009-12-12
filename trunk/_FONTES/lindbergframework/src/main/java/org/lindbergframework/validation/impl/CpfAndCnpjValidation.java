package org.lindbergframework.validation.impl;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IDocumentValidation;
import org.lindbergframework.validation.IValidation;
import org.lindbergframework.validation.factory.ValidationFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Implementaçãoo da validação de cpf e cnpj de acordo com o valor passado para ser validado <br><br>
 * 
 * Esta validação verifica se o comprimento corresponde a um cpf ou um cnpj e faz a validação correspondente 
 * 
 * @author Victor Lindberg
 *
 */
@Component("cpfAndCnpjValidation")
@Scope("prototype")
public class CpfAndCnpjValidation implements IDocumentValidation<String>{
	
	public void validate(String numDoc) throws ValidationException {
		if (numDoc != null){
			IValidation<String> validacao;
			if (numDoc.length() == 11)
				validacao = ValidationFactory.createCpfValidation();
			else
				if (numDoc.length() == 14)
				   validacao = ValidationFactory.createCnpjValidation();
				else
					throw new ValidationException("CPF ou CNPJ inv�lido");
			
			validacao.validate(numDoc);
				
		}
	}
	

}
