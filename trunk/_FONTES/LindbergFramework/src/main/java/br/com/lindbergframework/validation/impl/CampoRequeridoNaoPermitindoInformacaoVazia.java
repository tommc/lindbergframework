package br.com.lindbergframework.validation.impl;

import org.springframework.stereotype.Component;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.ICampoRequeridoValidacao;

/**
 * 
 * @author Victor Linndberg
 *
 */
@Component("campoRequeridoNaoPermitindoInformacaoVazia")
public class CampoRequeridoNaoPermitindoInformacaoVazia implements ICampoRequeridoValidacao {
	
	public void validate(Object valor) throws ValidationException {
		if (valor == null || valor.toString().trim().length() == 0)
	    	   throw new ValidationException("Campo requerido");
	}

}
