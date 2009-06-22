package br.com.lindbergframework.validation.impl;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.ICastValidation;

/**
 * 
 * @author Victor Lindberg
 *
 */
@Component("doubleValidacao")
public class StringToDoubleCastValidation implements ICastValidation<String>{
	
	public void validate(String valor) throws ValidationException {
	   try{
		  if (valor != null) 
	         Double.valueOf(valor.toString());	   
	   }catch(Exception ex){
		   throw new ValidationException("Número inválido");
	   }
	}

}
