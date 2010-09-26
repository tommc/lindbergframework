package org.lindbergframework.validation.impl;

import org.lindbergframework.exception.ValidationException;
import org.lindbergframework.validation.IDocumentValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * Implementaçãoo da validação de CNPJ 
 * 
 * @author Victor Lindberg
 * 
 */
@Component("cnpjValidation")
@Scope("prototype")
public class CnpjValidation implements IDocumentValidation<String>{

	
	public void validate(String cnpj) throws ValidationException {
	   if (cnpj != null && ! validateCnpj(cnpj))
		   throw new ValidationException("CNPJ inválido");
	}
	
	
	/**
	 * Efetua a validação do cnpj
	 */
	public static  boolean validateCnpj( String str_cnpj ) {   
		if (str_cnpj == null || str_cnpj.length() != 14)
			return false;
		
        if (! str_cnpj.substring(0,1).equals("")){   
            try{   
                str_cnpj=str_cnpj.replace('.',' ');   
                str_cnpj=str_cnpj.replace('/',' ');   
                str_cnpj=str_cnpj.replace('-',' ');   
                str_cnpj=str_cnpj.replaceAll(" ","");   
                int soma = 0, dig;   
                String cnpj_calc = str_cnpj.substring(0,12);   
                   
                if ( str_cnpj.length() != 14 )   
                    return false;   
                char[] chr_cnpj = str_cnpj.toCharArray();   
                /* Primeira parte */  
                for( int i = 0; i < 4; i++ )   
                    if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )   
                        soma += (chr_cnpj[i] - 48 ) * (6 - (i + 1)) ;   
                for( int i = 0; i < 8; i++ )   
                    if ( chr_cnpj[i+4]-48 >=0 && chr_cnpj[i+4]-48 <=9 )   
                        soma += (chr_cnpj[i+4] - 48 ) * (10 - (i + 1)) ;   
                dig = 11 - (soma % 11);   
                cnpj_calc += ( dig == 10 || dig == 11 ) ?   
                    "0" : Integer.toString(dig);   
                /* Segunda parte */  
                soma = 0;   
                for ( int i = 0; i < 5; i++ )   
                    if ( chr_cnpj[i]-48 >=0 && chr_cnpj[i]-48 <=9 )   
                        soma += (chr_cnpj[i] - 48 ) * (7 - (i + 1)) ;   
                for ( int i = 0; i < 8; i++ )   
                    if ( chr_cnpj[i+5]-48 >=0 && chr_cnpj[i+5]-48 <=9 )   
                        soma += (chr_cnpj[i+5] - 48 ) * (10 - (i + 1)) ;   
                dig = 11 - (soma % 11);   
                cnpj_calc += ( dig == 10 || dig == 11 ) ?   
                    "0" : Integer.toString(dig);   
                return str_cnpj.equals(cnpj_calc);   
            }catch (Exception e){   
                System.err.println("Erro !"+e);   
                return false;   
            }   
        }else return false;   
           
    }   
	
}
