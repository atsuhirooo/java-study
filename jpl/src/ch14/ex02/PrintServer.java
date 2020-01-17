package ch14.ex02;

import java.util.ArrayList;
import java.util.List;

class PrintServer implements Runnable {

	public static void main(String... args) {
		PrintServer printServer = new PrintServer();
		printServer.run();

		printServer.print(new PrintJob("a"));
		printServer.print(new PrintJob("b"));
	}

	private final PrintQueue requests = new PrintQueue();
	private long threadId;

	public PrintServer() {
		Thread thread = new Thread(this);
		threadId = thread.getId();
		thread.start();
	}

	public void print(PrintJob job) {
		requests.add(job);
	}

	@Override
	public void run() {
		if (Thread.currentThread().getId() == threadId) {
			for (;;) {
				realPrint(requests.remove());
			}
		}

	}

	private void realPrint(PrintJob job) {
		System.out.println(job.toString());
	}

}

class PrintJob {
	String jobname;

	public PrintJob(String jobname_) {
		// TODO 自動生成されたコンストラクター・スタブ
		jobname = jobname_;
	}
}

class PrintQueue {

	List<PrintJob> queue = new ArrayList<PrintJob>();

	public synchronized void add(PrintJob job) {

		queue.add(job);
		notifyAll();
	}

	public synchronized PrintJob remove() {
		while (queue.size() == 0)
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}

		return queue.remove(0);
	}

}
