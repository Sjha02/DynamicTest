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

import library.daos.BookMapDAO;
import library.daos.LoanMapDAO;
import library.interfaces.daos.IBookDAO;
import library.interfaces.daos.IBookHelper;
import library.interfaces.daos.ILoanDAO;
import library.interfaces.daos.ILoanHelper;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IBook;
import library.interfaces.entities.IMember;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
public class TestBookDAO {
	
	@RunWith(MockitoJUnitRunner.class)
	public class TestLoanDAO {

		IBookHelper _helper;
		IBookDAO _dao;
		
		@Before
		public void setUp() throws Exception {
			_helper = mock(IBookHelper.class);
			_dao = new BookMapDAO(_helper);
		}
		
		@After
		public void tearDown() throws Exception {
			_helper = null;
			_dao = null;
		}
		
		@Test
		public void testConstructor() {
			BookMapDAO dao = new BookMapDAO(_helper);
			assertTrue(dao instanceof IBookDAO);
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testConstructorHelperNull() {
			BookMapDAO dao = new BookMapDAO(null);
		}
		
		@Test
		public void testCreateBook() {
			
			//setup
			IMember member = mock(IMember.class);
			ILoan loan= mock(ILoan.class);
			IBook expectedBook = mock(IBook.class);
			
			String _author = null;
			String _title = null;
			String _callNumber = null;
			int _id = 0;
			when(_helper.makeBook(eq(_author), eq(_title), eq(_callNumber), eq(_id))).thenReturn(expectedBook);
			
			//execute
			IBook actualBook = _dao.addBook( _author, _title, _callNumber);
			
			//verifies and asserts
			verify(_helper).makeBook(eq(_author), eq(_title), eq(_callNumber), eq(_id));
			assertEquals(expectedBook, actualBook);		
		}
		
		@Test(expected=IllegalArgumentException.class)
		public void testCreateLoanBookNull() {
			
			//setup
			IMember member = mock(IMember.class);
			
			int id = 0;
			//execute
			IBook actualBook = _dao.getBookByID( id);
			
			//verifies and asserts
			fail("Should have thrown exception");
		}
	}
}
		

	/**@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

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


