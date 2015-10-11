package tests.library.entities;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;
import library.entities.Book;
import library.entities.Loan;

import java.util.Date;
import java.util.Calendar;

public class TestBook {
	
	IBook _book;
	IMember _member;
	ILoan _loan;
	
	String _author, _title, _callNumber;
	Date _borrowDate, _dueDate;
	Calendar _cal;
	
	int _bookId;	
	
	@Before
	public void setUp() throws Exception {
		
		_member = mock(IMember.class);
		_loan = mock(ILoan.class);
		
		
		
		
		_cal = Calendar.getInstance();
		_borrowDate = _cal.getTime();
		_cal.add(Calendar.DATE, ILoan.LOAN_PERIOD);
		_dueDate = _cal.getTime();
		 
		
		_book = new Book( _author, _title, _callNumber, _bookId);
	}

	@After
	public void tearDown() throws Exception {
		
		_book = null;
	}
	
	@Test
	public void testCreate() {
		IBook book = new Book( _author, _title, _callNumber,_bookId);
		assertTrue( book instanceof Book);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateBadParamBookNull() {
		IBook book = new Book( _author, _title, _callNumber,_bookId);
	}

	/**
	/@Test

	public void testBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testBorrow() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLoan() {
		fail("Not yet implemented");
	}

	@Test
	public void testReturnBook() {
		fail("Not yet implemented");
	}

	@Test
	public void testLose() {
		fail("Not yet implemented");
	}

	@Test
	public void testRepair() {
		fail("Not yet implemented");
	}

	@Test
	public void testDispose() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetState() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetAuthor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTitle() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetCallNumber() {
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
