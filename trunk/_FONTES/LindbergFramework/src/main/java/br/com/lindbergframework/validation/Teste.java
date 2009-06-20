package br.com.lindbergframework.validation;

import java.util.Arrays;
import java.util.List;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.factory.ValidationFactory;
import br.com.lindbergframework.validation.settings.MsgType;
import br.com.lindbergframework.validation.settings.ValidationMode;


public class Teste {
	
	public static void main(String[] args) {
		String cpf = "   ";
		
		IValidationComposite validationComposite = ValidationFactory.createValidationComposite();
		validationComposite.addValidationsForItem(new ValidationItem(cpf,MsgType.USING_CUSTOM_SUFFIX,"nome","Informe um cpf válido"),
				                              ValidationFactory.createCampoRequeridoNaoPermitindoInfoVaziaValidacao(),
				                              ValidationFactory.createCpfValidacao());
        
		
		
		try{
		validationComposite.executarValidacaoes(ValidationMode.LANCAR_NO_FINAL);
		}
		catch(ValidationException ex){
			System.out.println(ex.getMessage());
		}
		
		System.out.println("Fim");
		
	}

}
