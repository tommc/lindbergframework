package org.lindbergframework.test.persistence.dao.mysql;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.lindbergframework.persistence.sql.SqlArg;
import org.lindbergframework.persistence.sql.SqlFunction;
import org.lindbergframework.test.persistence.dao.PersistTemplateDaoTest;

/**
 * 
 * @author Victor Lindberg
 *
 */
public class MySqlPersistTemplateDaoTest extends PersistTemplateDaoTest{
	
	public MySqlPersistTemplateDaoTest(){
		//
	}
	
	public String findPersonNickFromProcedure(int id){
		Map out = getPersistTemplate().callProcedure("findPersonNickFromProcedure", new SqlArg("pid",id));
		return (String) out.get("nick");
	}
	
	public List<String> list3NickPersonsFromProcedure(int id1, int id2, int id3){
		Map out = getPersistTemplate().callProcedure("out3NickPersons", new SqlArg("pid1",id1),
				                                                   new SqlArg("pid2",id2),
				                                                   new SqlArg("pid3",id3));
		
		return Arrays.asList((String)out.get("nick1"),
				             (String)out.get("nick2"),
				             (String)out.get("nick3"));
	}
	
	public String findPersonNickFromFunction(int id){
		Map result = getPersistTemplate().callFunction("findPersonNickFunc", new SqlArg("pid",id));
		
		return (String) result.get(SqlFunction.DEFAULT_RESULT_NAME);
	}
	
}
