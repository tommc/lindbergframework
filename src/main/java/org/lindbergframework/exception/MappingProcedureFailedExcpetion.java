package org.lindbergframework.exception;

import java.util.List;

/**
 * Mapping procedure error.
 * 
 * @author Victor Lindberg
 *
 */
public class MappingProcedureFailedExcpetion extends PersistenceException{
	
	private static final long serialVersionUID = 1L;

    public MappingProcedureFailedExcpetion() {
		//
	}

    public MappingProcedureFailedExcpetion(List<String> msgs, Throwable cause) {
        super(msgs, cause);
    }

    public MappingProcedureFailedExcpetion(List<String> msgs) {
        super(msgs);
    }

    public MappingProcedureFailedExcpetion(String msg, String... causeMessages) {
        super(msg, causeMessages);
    }

    public MappingProcedureFailedExcpetion(String msg, Throwable cause,
        String... causeMessages) {
        super(msg, cause, causeMessages);
    }

    public MappingProcedureFailedExcpetion(Throwable cause,
        String... causeMessages) {
        super(cause, causeMessages);
    }

	


}
