package tests.library.entities;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import library.interfaces.entities.EBookState;
import library.interfaces.entities.ELoanState;
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
	ELoanState state;
	EBookState status;

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
	public void testCreateAuthorNull() {
		IBook book = new Book ( null , _title, _callNumber, _bookID);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateTitleNull() {
		IBook book = new Book ( _author , null, _callNumber, _bookID);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateBadParamCallNUmberNull() {
		IBook book = new Book ( _author , _title, null, _bookID);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateBadParamBookIDNull() {
		IBook book = new Book ( _author , _title, _callNumber, _bookID);
		if (_bookID <- 0)
		{
			
		}
	}
	
	@Test
	public void testCreateborrow(ILoan loan) {
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
}
	
	
	
		
	