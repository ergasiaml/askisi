package org.teipir.softeng.jdbc;

import static org.junit.Assert.*;

import org.junit.Test;

public class startTest {

	@Test
	public void testconn() {
		start tester = new start();		
		assertNotNull(tester.conn);
	}
}
