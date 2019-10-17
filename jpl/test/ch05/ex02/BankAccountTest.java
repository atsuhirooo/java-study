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
		bankAccount.withdraw(100);

		History history = bankAccount.history();
		Action a1 = history.next();
		assertThat("0 deposit 100", is(a1.toString()));

		Action a2 = history.next();
		assertThat("0 withdraw 100", is(a2.toString()));

	}

}
