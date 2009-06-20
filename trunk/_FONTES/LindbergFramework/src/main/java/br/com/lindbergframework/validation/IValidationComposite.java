package br.com.lindbergframework.validation;

import java.util.List;

import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.settings.ValidationMode;

/**
 * 
 * @author Victor Lindberg
 *
 */
public interface IValidationComposite {

	public void addValidations(List<ValidationItem> items,IValidation... validacoes);
		
	public void addValidationForSeveralItems(IValidation validacao,ValidationItem... items);
		
	public void addValidationsForItem(ValidationItem item,IValidation... validacoes);
	
	public void executarValidacaoes(ValidationMode mode) throws ValidationException;
	
	public void executarValidacaoes() throws ValidationException;
	
	public void clearValidations();
	
	public void reset();
	
}
