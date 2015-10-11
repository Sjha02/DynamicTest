package tests.library.entities;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import library.interfaces.entities.EBookState;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;
import library.entities.Book;

import java.util.Date;
import java.util.Calendar;


public class TestBook {
	
	String _author;
	String _title;
    String _callNumber;
	int _id;
	
	private ILoan loan;
	private EBookState state;
	
	IBook _book;
	IMember _member;
	ILoan _loan;
	Date _borrowDate, _dueDate;
	Calendar _cal;

	@Before
	public void setUp() throws Exception {
		_loan = mock(ILoan.class);
		_member = mock(IMember.class);
		
		_cal = Calendar.getInstance();
		_borrowDate = _cal.getTime();
		_cal.add(Calendar.DATE, ILoan.LOAN_PERIOD);
		_dueDate = _cal.getTime();

		_book = new Book (_author, _title, _callNumber, _id);

	}

	@After
	public void tearDown() throws Exception {
		_book = null;
	}
	
	@Test
	public void testCreate() {
		IBook book = new Book(_author, _title, _callNumber, _id);
		assertTrue( book instanceof Book);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateBadParamBookNull() {
		IBook book = new Book( null,  _title, _callNumber, _id);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateBadParamMemberNull() {
		IBook book = new Book(_author, null, _callNumber, _id);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateBadParamBorrowDateNull() {
		IBook book = new Book(_author, _title, null, _id);
	}
	
	//@Test(expected=IllegalArgumentException.class)
	//public void testCreateBadParamDueDateNull() {
		//IBook book = new Book(_author, _title, _callNumber, null);
	//}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateBadParamDueDateLessThanBorrowDate() {
		IBook book = new Book(_author, _title, _callNumber, _id);
	}
	
	@Test
	public void testCreateBadParamDueDateEqualToBorrowDate() {
		IBook book = new Book(_author, _title, _callNumber, _id);
		assertTrue( book instanceof Book);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCommitBadParamLoanIdNegative() {
		_loan.commit(-1);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCommitBadParamLoanIdZero() {
		_loan.commit(-1);
	}
	
	@Test
	public void testIsCurrentPending() {
		assertFalse(_loan.isCurrent());
	}
	
	@Test
	public void testCommit() {
		//setup
		int id = 1;
		
		//execute
		_loan.commit(id);
		
		//verifies and asserts
		verify(_book).borrow(_loan);
		verify(_member).addLoan(_loan);
		
		assertTrue(_loan.isCurrent());
		int actual = _loan.getID();
		assertEquals(id, actual);
	}
	
	@Test(expected=RuntimeException.class)
	public void testCommitWhenCurrent() {
		_loan.commit(1);
		_loan.commit(1);
	}
	
	
	
/*
	@Test
	public void testComplete() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsCurrent() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsOverDue() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckOverDue() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBorrower() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetID() {
		fail("Not yet implemented");
	}
*/
}
