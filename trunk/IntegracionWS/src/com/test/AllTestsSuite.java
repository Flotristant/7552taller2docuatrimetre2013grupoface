package com.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTestsSuite {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTestsSuite.class.getName());
		//$JUnit-BEGIN$
		suite.addTestSuite(CarteleraJoinTest.class);
//		suite.addTestSuite(TestIntegracionActividad.class);
		suite.addTestSuite(UsuarioTestIntegration.class);
		suite.addTestSuite(MuroJoinTest.class);
		suite.addTestSuite(ActividadTest.class);
		suite.addTestSuite(UsuarioJoinTest.class);
		suite.addTestSuite(ForoTest.class);
		suite.addTestSuite(TestIntegracionChat.class);
		suite.addTestSuite(TestIntegracionComunicacion.class);
		suite.addTestSuite(JoinTests.class);
//		suite.addTestSuite(ArchivoTest.class);
		suite.addTestSuite(RecursoTest.class);
		suite.addTestSuite(AmbitoJoinTest.class);
		//$JUnit-END$
		return suite;
	}

}
