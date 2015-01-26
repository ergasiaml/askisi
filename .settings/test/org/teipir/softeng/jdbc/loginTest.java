package org.teipir.softeng.jdbc;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

public class loginTest {



	@Test
	public void testInitialize() throws SQLException {
		login tester = new login();	
		assertNotNull(tester.connection);

	}
	


}
