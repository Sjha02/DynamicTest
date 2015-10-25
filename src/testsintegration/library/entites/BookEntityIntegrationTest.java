package testsintegration.library.entites;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;

import library.entities.Book;
import library.entities.Loan;
import library.entities.Member;
import library.interfaces.entities.EBookState;
import library.interfaces.entities.IBook;
import library.interfaces.entities.ILoan;
import library.interfaces.entities.IMember;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class BookEntityIntegrationTest {
	private IBook book;
	private String author;
	private String title;
	private String callNumber;
	private int bookID;
	
	private IMember borrower;
	private String fName;
	private String lName;
	private String contact;
	private String email;
	private int memberID;
	
	private ILoan loan;
	private int loanID;
	private Date borrowDate;
	private Date dueDate;
	private Calendar calendar;

	@Before
	public void setUp() throws Exception {
		author = "Jim T";
		title = "itc205";
		callNumber = "88";
		bookID = 10;
		book = new Book(author, title, callNumber, bookID);
		
		fName = "Rob";
		lName = "Jones";
		contact = "0430283468";
		email = "skj@gmail.com";
		memberID = 01;
		borrower = new Member(fName, lName, contact, email, memberID);
		
		loanID = 1;
		calendar = Calendar.getInstance();
		borrowDate = new Date();
		calendar.setTime(borrowDate);
		calendar.add(Calendar.DATE, ILoan.LOAN_PERIOD);
		dueDate = calendar.getTime();
		loan = new Loan(book, borrower, borrowDate, dueDate);
		loan.commit(loanID);
	}

	@After
	public void tearDown() throws Exception {
		book = null;
		borrower = null;
		loan = null;
	}

	@Test
	public void testBook() {
		assertNotNull(book);
		assertTrue(book instanceof IBook);
	}
	
	@Test
	public void testBorrow() {
		assertTrue(book.getState() == EBookState.ON_LOAN);
		assertTrue(loan == book.getLoan());
	}
	
	@Test
	public void testGetLoan() {
		assertTrue(book.getLoan() == loan);
	}
	
}
