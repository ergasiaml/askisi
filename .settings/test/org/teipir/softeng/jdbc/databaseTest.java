package org.teipir.softeng.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

public class databaseTest {

	@Test
	public void testDbConnector() {
		try
		{
		database tester = new database();		
		assertNotNull(tester.dbConnector());

		}catch (Exception e)
		{

			
		}
	}



}
