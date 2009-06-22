package br.com.lindbergframework.validation;

import br.com.lindbergframework.exception.LindbergException;
import br.com.lindbergframework.validation.factory.ValidationFactory;
import br.com.lindbergframework.validation.settings.MsgType;
import br.com.lindbergframework.validation.settings.ValidationMode;


public class Teste {
	 
	public static void main(String[] args) {
		String cpf = "   ";
		String nome = null;
		
		String cnpj = "1";
		String cnpj2 = "   ";
		String cnpj3 = null;
		
		IValidationComposite validationComposite = ValidationFactory.createValidationComposite();
		
		validationComposite.addValidationsForItem(new ValidationItem(cpf,MsgType.USING_CUSTOM_SUFFIX,"cpf","Informe um cpf válido"),
				                              ValidationFactory.createCampoRequeridoNaoPermitindoInfoVaziaValidacao(),
				                              ValidationFactory.createCpfValidacao());
        
		
		validationComposite.addValidationsForItem(new ValidationItem(nome,MsgType.USING_CUSTOM_SUFFIX,"Nome nao pode ser nulo"), 
				                           ValidationFactory.createNotNullValidacao());
		
		validationComposite.addValidations(new ValidationItem[]{
				                                new ValidationItem(cnpj,0,1),
				                                new ValidationItem(cnpj2,MsgType.CUSTOM_ONLY,"CNPJ NÃO ESTÁ OK","CNPJ É REQUERUDO"),
				                                new ValidationItem(cnpj3,MsgType.USING_CUSTOM_SUFFIX,
				                                 		                 new String[] {"****CNPJ NÃO ESTÁ OK","****CNPJ É REQUERUDO"},0,1)}, 
				                      ValidationFactory.createCnpjValidacao(),
				                      ValidationFactory.createCampoRequeridoNaoPermitindoInfoVaziaValidacao());
		     
		validationComposite.addValidationForSeveralItems(ValidationFactory.createHasBeNullValidacao(), new ValidationItem(""));
		validationComposite.addValidationsForItem(new ValidationItem("  ",MsgType.USING_CUSTOM_PREFIX,"?? msg ??"), 
				                      ValidationFactory.createHasBeNullValidacao(),
				                      ValidationFactory.createStringToDoubleCastValidacao());
		  
		try{ 
		   validationComposite.executarValidacaoes(ValidationMode.LANCAR_NO_FINAL);
		   System.out.println("OK");
		}
		catch(LindbergException ex){
			for (String msg : ex.getMessages())
				System.out.println(msg);
		}
		
		
	}

}
