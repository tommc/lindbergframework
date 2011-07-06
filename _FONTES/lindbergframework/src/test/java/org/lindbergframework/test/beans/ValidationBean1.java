package org.lindbergframework.test.beans;

import java.util.Date;
import java.util.List;

import org.lindbergframework.validation.Types;
import org.lindbergframework.validation.annotation.Valid;
import org.lindbergframework.validation.annotation.Validations;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 * 
 */
public class ValidationBean1 {

    @Validations({@Valid(value = Types.REQUIRED_FIELD,msg = "msg1"),
                  @Valid(value = Types.REQUIRED_FIELD_NO_INFORMATION_EMPTY,msg = "msg4", actions = "action1"),
                  @Valid("myValidation1")})
    private String name;
    
    @Validations({@Valid(Types.REQUIRED_FIELD),
                  @Valid(value = Types.DATE_CAN_NOT_BE_PRESENT, msg = "msg2")})
    private Date date;
    
    @Valid(value = Types.MUST_BE_EMPTY_LIST, msg = "msg5", actions = "mustBeEmptyListTest")
    private List<String> list;
    
    /**
     * Construtor padrão.
     */
    public ValidationBean1() {
        //
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
    
    
}
