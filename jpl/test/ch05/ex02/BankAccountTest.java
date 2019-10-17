package ch05.ex02;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

import ch05.ex02.BankAccount.Action;
import ch05.ex02.BankAccount.History;

public class BankAccountTest {
	@Test
	public void startTest() {
		BankAccount bankAccount = new BankAccount();

		bankAccount.depsiot(100);
		bankAccount.withdraw(200);
		bankAccount.depsiot(300);
		bankAccount.withdraw(400);
		bankAccount.depsiot(500);
		bankAccount.withdraw(600);
		bankAccount.withdraw(700);
		bankAccount.withdraw(800);
		bankAccount.withdraw(900);
		bankAccount.withdraw(1000);
		bankAccount.withdraw(1100);

		History history = bankAccount.history();

		Action a = history.next();
		assertThat("0 withdraw 200", is(a.toString()));

	}

}
