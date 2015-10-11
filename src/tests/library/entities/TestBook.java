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
	Date _borrowDate, _dueDate;
	Calendar _cal;
	String _author , _title, _callNumber;
	int _bookID;

	@Before
	public void setUp() throws Exception {		
		
		_loan = mock(ILoan.class);
		_member = mock(IMember.class);
		
		_cal = Calendar.getInstance();
		_borrowDate = _cal.getTime();
		_cal.add(Calendar.DATE, ILoan.LOAN_PERIOD);
		_dueDate = _cal.getTime();

		_book = new Book( _author , _title, _callNumber, _bookID);
		
	}

	
	public void tearDown() throws Exception {
		
		_book = null;
	}

	@Test
	public void testCreate() {
		IBook book = new Book ( _author , _title, _callNumber, _bookID);
		assertTrue( book instanceof Book);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateBadParamBookNull() {
		IBook book = new Book ( null , _title, _callNumber, _bookID);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateBadParamMemberNull() {
		IBook book = new Book ( _author , null, _callNumber, _bookID);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateBadParamBorrowDateNull() {
		IBook book = new Book ( _author , _title, null, _bookID);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateBadParamDueDateNull() {
		IBook book = new Book ( _author , _title, _callNumber, _bookID);
		if (_bookID <- 0)
		{
			
		}
	}
	
		
	/**
	@Test
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
