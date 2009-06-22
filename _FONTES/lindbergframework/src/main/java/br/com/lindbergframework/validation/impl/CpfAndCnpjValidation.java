package br.com.lindbergframework.validation.impl;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.IDocumentValidation;
import br.com.lindbergframework.validation.IValidation;
import br.com.lindbergframework.validation.factory.ValidationFactory;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Component("cpfAndCnpjValidation")
public class CpfAndCnpjValidation implements IDocumentValidation<String>{
	
	public void validate(String numDoc) throws ValidationException {
		if (numDoc != null){
			IValidation<String> validacao;
			if (numDoc.length() == 11)
				validacao = ValidationFactory.createCpfValidacao();
			else
				if (numDoc.length() == 14)
				   validacao = ValidationFactory.createCnpjValidacao();
				else
					throw new ValidationException("CPF ou CNPJ inválido");
			
			validacao.validate(numDoc);
				
		}
	}
	
	

}
