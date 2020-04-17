package ch14.ex08;

class Friendly {

	private Friendly partner;
	private String name;

	public Friendly(String name) {
		this.name = name;
	}

	public static synchronized void hug(Friendly f) {
		System.out.println(Thread.currentThread().getName() + " in " + f.name + ".hug() trying to invoke "
				+ f.partner.name + ".hugback()");
		f.partner.hugBack(f.partner);
	}

	private static synchronized void hugBack(Friendly f) {
		System.out.println(Thread.currentThread().getName() + " in " + f.name + ".hugBack()");
	}

	public void becomeFriend(Friendly partner) {
		this.partner = partner;
	}

	public static void main(String[] args) {

		final Friendly jareth = new Friendly("jareth");
		final Friendly cory = new Friendly("cory");

		jareth.becomeFriend(cory);
		cory.becomeFriend(jareth);

		new Thread(new Runnable() {

			@Override
			public void run() {
				jareth.hug(jareth.partner);
			}
		}, "Thread1").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				cory.hug(cory.partner);
			}
		}, "Thread2").start();
	}

}
