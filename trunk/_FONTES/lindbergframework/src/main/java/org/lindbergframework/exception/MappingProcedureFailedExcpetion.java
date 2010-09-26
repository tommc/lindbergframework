package org.lindbergframework.exception;

import java.util.List;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class MappingProcedureFailedExcpetion extends PersistenceException{
	
	public MappingProcedureFailedExcpetion() {
		//
	}

	public MappingProcedureFailedExcpetion(String msg) {
		super(msg);
	}

	public MappingProcedureFailedExcpetion(String msg, Throwable cause) {
		super(msg, cause);
	}

	public MappingProcedureFailedExcpetion(Throwable cause) {
		super(cause);
	}

	public MappingProcedureFailedExcpetion(List<String> msgs) {
		super(msgs);
	}

	public MappingProcedureFailedExcpetion(List<String> msgs, Throwable cause) {
		super(msgs, cause);
	}


}
