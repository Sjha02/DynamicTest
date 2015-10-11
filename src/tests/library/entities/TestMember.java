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
import library.entities.Member;

import java.util.Date;
import java.util.Calendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMember {
	
	IBook _book;
	IMember _member;
	ILoan _loan;
	Date _borrowDate, _dueDate;
	Calendar _cal;
	String  _firstName, _lastName, _contactPhone, _emailAddress;
	int _id;


	@Before
	public void setUp() throws Exception {
		
		_book = mock(IBook.class);
		_loan = mock(ILoan.class);
		
		_cal = Calendar.getInstance();
		_borrowDate = _cal.getTime();
		_cal.add(Calendar.DATE, ILoan.LOAN_PERIOD);
		_dueDate = _cal.getTime();
		
		

		_member = new Member( _firstName, _lastName, _contactPhone, _emailAddress, _id);
	}

		public void tearDown() throws Exception {
		_member = null;
	}

	
	@Test
	public void testCreate() {
		IMember member =  new Member( _firstName, _lastName, _contactPhone, _emailAddress, _id);
		assertTrue( member instanceof Member);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateBadParamEmailNull() {
		IMember member = new Member( _firstName, _lastName, _contactPhone, null, _id);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testCreateBadParamIDNull() {
		IMember member =  new Member( _firstName, _lastName, _contactPhone, _emailAddress, _id);
		if (_id <- 0)
		{
			
		}
	}
}
