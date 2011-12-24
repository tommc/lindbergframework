package org.lindbergframework.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.lindbergframework.test.beans.di.test.DiTest;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 *  
 */
public class MainTestSuite {

	/**
	 * Default Constructor.
	 */
	public MainTestSuite() {
		//
	}

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for org.lindbergframework");
		//$JUnit-BEGIN$
		//Dependency Injection
		suite.addTestSuite(DiTest.class);
		//$JUnit-END$
		return suite;
	}
}
