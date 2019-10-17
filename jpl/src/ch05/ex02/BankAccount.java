package ch05.ex02;

public class BankAccount {
	private long number;
	private long balance;
	private Action lastAct;
	private History history;
	{
		history = new History();

	}

	public class Action {
		private String act;
		private long amount;
		public Action next;

		Action(String act, long amount) {
			this.act = act;
			this.amount = amount;
		}

		public String toString() {
			return number + " " + act + " " + amount;
		}
	}

	public class History {
		Action head;
		int nextCnt = 0;

		public void add(Action value) {

			if (head == null)
				head = value;
			else {
				int length = 1;
				Action tmp = head;
				while (tmp.next != null) {
					tmp = tmp.next;
					length++;
				}
				if (length == 10) {
					head = head.next;
				}

				tmp.next = value;

			}
		}

		public Action next() {
			if (head == null)
				return null;
			Action tmp = head;
			for (int i = 0; i < nextCnt; i++) {
				tmp = tmp.next;
				if (tmp == null)
					return null;
			}
			nextCnt++;
			return tmp;

		}
	}

	public History history() {
		return history;
	}

	public void depsiot(long amount) {
		balance += amount;
		lastAct = new Action("deposit", amount);
		history.add(lastAct);
	}

	public void withdraw(long amount) {
		balance -= amount;
		lastAct = new Action("withdraw", amount);

		history.add(lastAct);
	}
}
