package org.teipir.softeng.jdbc;

import static org.junit.Assert.*;



import org.junit.Test;

public class adminTest {


	
	@Test
	public void testconn() {
		admin tester = new admin();	
		
		assertNotNull(tester.conn);
	
	}
	

	
	

}
