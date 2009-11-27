package br.com.lindbergframework.validation;

import br.com.lindbergframework.exception.ValidationClassCastException;
import br.com.lindbergframework.exception.ValidationException;
import br.com.lindbergframework.validation.settings.ValidationMode;

/**
 * 
 * @author Victor Lindberg
 *
 */
@SuppressWarnings("unchecked")
public interface IExecutorValidation {

	public void addValidations(ValidationItem[] items,IValidation... validacoes);
		
	public void addValidationForSeveralItems(IValidation validacao,ValidationItem... items);
		
	public void addValidationsForItem(ValidationItem item,IValidation... validacoes);
	
	public void addValidationsValidating(ValidationMode mode,ValidationItem[] items,IValidation... validacoes);
	
	public void addValidationForSeveralItemsValidating(ValidationMode mode,IValidation validacao,ValidationItem... items);
	
	public void addValidationsForItemValidating(ValidationMode mode, ValidationItem item,IValidation... validacoes);
	
	public void addValidationsValidating(ValidationItem[] items,IValidation... validacoes);
	
	public void addValidationForSeveralItemsValidating(IValidation validacao,ValidationItem... items);
	
	public void addValidationsForItemValidating(ValidationItem item,IValidation... validacoes);
	
	public void executarValidacaoes(ValidationMode mode) 
	                     throws ValidationException, ValidationClassCastException;
	
	public void executarValidacaoes() 
	                      throws ValidationException, ValidationClassCastException;
	
	public void executarValidacaoes(String separatorMessages) throws ValidationException,ValidationClassCastException;
	
	public void clearValidations();
	
	public void reset();
	
}
