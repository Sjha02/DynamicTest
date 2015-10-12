package tests.library.daos;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import library.daos.LoanMapDAO;
import library.daos.MemberMapDAO;
import library.interfaces.daos.ILoanDAO;
import library.interfaces.daos.ILoanHelper;
import library.interfaces.daos.IMemberDAO;
import library.interfaces.daos.IMemberHelper;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IBook;
import library.interfaces.entities.IMember;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RunWith(MockitoJUnitRunner.class)
public class TestMemberDAO {
	
	String firstName = null;
	String lastName = null;
	String contactPhone = null;
	String emailAddress = null;
	int id = 1;
	
	
	IMemberHelper _helper;
	IMemberDAO _dao;
	
	@Before
	public void setUp() throws Exception {
		_helper = mock(IMemberHelper.class);
		_dao = new MemberMapDAO(_helper);
	}
	
	@After
	public void tearDown() throws Exception {
		_helper = null;
		_dao = null;
	}
	
	@Test
	public void testConstructor() {
		MemberMapDAO dao = new MemberMapDAO(_helper);
		assertTrue(dao instanceof IMemberDAO);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testConstructorHelperNull() {
		MemberMapDAO dao = new MemberMapDAO(null);
	}
	
	@Test
	public void testCreateMember() {
		
		//setup
		ILoan loan = mock(ILoan.class);
		IBook book = mock(IBook.class);
		IMember expectedMember = mock(IMember.class);
		
		
		when(_helper.makeMember(eq(firstName), eq(lastName), eq(contactPhone), eq(emailAddress), eq(id))).thenReturn(expectedMember);
		
		//execute
	
		
		IMember actualMember = _dao.getMemberByID(1);
		
		//verifies and asserts
		verify(_helper).makeMember(eq(firstName), eq(lastName), eq(contactPhone), eq(emailAddress), eq(id));
		assertEquals(expectedMember, actualMember);		
	}
	
	
	/**

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMember() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasOverDueLoans() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasReachedLoanLimit() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasFinesPayable() {
		fail("Not yet implemented");
	}

	@Test
	public void testHasReachedFineLimit() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFineAmount() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddFine() {
		fail("Not yet implemented");
	}

	@Test
	public void testPayFine() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddLoan() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLoans() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveLoan() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetState() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetFirstName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLastName() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetContactPhone() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmailAddress() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetID() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}
	*/

}
