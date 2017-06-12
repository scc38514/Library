package library;

import java.util.ArrayList;

import org.junit.Test;

public class libraryTest {
	Member member1 = new Member();
	Member member2 = new Member();
	Member member3 = new Member();
	Book book1 = new Book("0001", "ISBN-1-1", "book-1");
	Book book2 = new Book("0002", "ISBN-2-1", "book-2");
	Book book3 = new Book("0003", "ISBN-3-1", "book-3");
	Book book4 = new Book("0004", "ISBN-4-1", "book-4");
	Member loanmember = member1;
	Book loanbook = book1;
	ArrayList<Loan> Loans = new ArrayList<Loan>();

	public libraryTest() {
		member1.setId("01");
		member1.setName("Member-1");
		member2.setId("02");
		member2.setName("Member-2");
		member3.setId("03");
		member3.setName("Member-3");		
		Loan loan1 = new Loan();
		loan1.setMember(loanmember);
		loan1.setBook(book3);
		Loans.add(loan1);				
		loanmember.setLoans(Loans);
	}

	@Test
	public void Loan() {
		 Loan loan=loanmember.Loan(loanbook);
		 if(!(loan==null)){
		 System.out.println(" Success comes!");
		 System.out.println(" Loan-Massage"+'\r'+
		 " Loan-Date: " +loan.getLoanDate()+'\r'+
		 " Return-Date: " + loan.getDateForReuturn()+'\r'+
		 " Member-Name: " + loanmember.getName()+'\r'+
		 " Book-Title: " + loanbook.getTitle());
		 }
		 else{
		 System.out.println("Failure");
		 }
		loanmember.Return(loanbook); 

	}
	
	@Test
	public void rule(){
	LoanOnlyOneSpecification one = new LoanOnlyOneSpecification(loanbook);
	System.out.println(one.IsSatisfiedBy(loanmember));		
	}

}
