/*
 * Copyright (C) 2012, 2013 RICOH Co., Ltd. All rights reserved.
 * Copyright (C) 2019 Yoshiki Shibata. All rights reserved.
 */
package ch14.ex10;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Simple Thread Pool class.
 *
 * This class can be used to dispatch an Runnable object to be exectued by a
 * thread.<br>
 * <br>
 *
 * [Instruction]
 * <ul>
 * <li>Implement one constructor and three methods.</li>
 * <li>Don't forget to write a Test program to test this class.</li>
 * <li>Pay attention to @throws tags in the javadoc.</li>
 * <li>If needed, you can put "synchronized" keyword to methods.</li>
 * <li>All classes for implementation must be private inside this class.</li>
 * <li>Don't use java.util.concurrent package.</li>
 * <li>Don't use {@link java.lang.Thread#interrupt} method to stop a thread</li>
 * </ul>
 *
 * @author Yoshiki Shibata
 */
public class ThreadPool {
	/**
	 * Constructs ThreadPool.
	 *
	 * @param queueSize
	 *            the max size of queue
	 * @param numberOfThreads
	 *            the number of threads in this pool.
	 *
	 * @throws IllegalArgumentException
	 *             if either queueSize or numberOfThreads is less than 1
	 */

	private List<Thread> threads = new ArrayList<Thread>();

	private RunableQueue runableQueue;

	public static class WorkerThread extends Thread {
		private final RunableQueue queue;

		public WorkerThread(RunableQueue taskQueue) {
			assert taskQueue != null;
			this.queue = taskQueue;
		}

		@Override
		public void run() {

			while (!queue.isStop() || queue.numOfTasks() != 0) {
				Runnable task = null;
				try {

					if (null == (task = queue.take())) {
						// System.out.println("queue was is empty" + Thread.currentThread().getName());

					}

				} catch (InterruptedException e) {
					e.printStackTrace();
					System.err.println("worker thread interrupted in taking a task.");
				}
				if (task != null) {
					task.run();

				}
			}
		}
	}

	public static class RunableQueue {
		private Runnable[] queue;
		private int queueMax = 0;
		private int head = 0;
		private int tail = 0;
		private volatile int length = 0;

		private volatile boolean isStop;

		private boolean isStop() {

			return isStop;
		}

		private synchronized void doStop() {
			isStop = true;
			notifyAll(); // important
		}

		public RunableQueue(int queueSize) {
			queueMax = queueSize;
			queue = new Runnable[queueMax];

		}

		public synchronized boolean put(Runnable task) throws InterruptedException {
			assert task != null;
			while (queueMax <= numOfTasks() && !isStop()) {
				System.out.println("put wait" + " " + Thread.currentThread().getName());
				wait();
			}

			if (isStop())
				return false;

			System.out.println("put " + " " + Thread.currentThread().getName());
			queue[tail] = task;
			tail = (tail + 1) % queueMax;
			length++;
			notifyAll();

			return true;
		}

		public synchronized Runnable take() throws InterruptedException {

			while (numOfTasks() == 0 && !isStop()) {
				System.out.println("take wait current" + " " + Thread.currentThread().getName());
				wait();
			}
			if (numOfTasks() <= 0) {
				return null;
			}

			System.out.println("take" + " " + Thread.currentThread().getName());
			Runnable task = queue[head];
			head = (head + 1) % queueMax;
			length--;
			notifyAll();

			return task;
		}

		public synchronized int numOfTasks() {
			return length;
		}

	}

	public ThreadPool(int queueSize, int numberOfThreads) {
		System.out.println(queueSize + " " + numberOfThreads);
		if (queueSize < 1) {
			throw new IllegalArgumentException("queueSize must be 1 or more.");
		}
		if (numberOfThreads < 1) {
			throw new IllegalArgumentException("numberOfThreads must be 1 or more.");
		}

		runableQueue = new RunableQueue(queueSize);

		for (int i = 0; i < numberOfThreads; i++) {

			threads.add(new WorkerThread(runableQueue));

		}

	}

	/**
	 * Starts threads.
	 *
	 * @throws IllegalStateException
	 *             if threads has been already started.
	 */
	public synchronized void start() {
		if (hasStarted) {
			throw new IllegalStateException("start has been already invoked.");
		}
		for (Thread thread : threads) {
			System.out.println("start curent" + " " + Thread.currentThread().getName());
			System.out.println("start thread" + " " + thread.getName());
			thread.start();
		}
		hasStarted = true;
		notifyAll();

	}

	/**
	 * Stop all threads gracefully and wait for their terminations. All requests
	 * dispatched before this method is invoked must complete and this method also
	 * will wait for their completion.
	 *
	 * @throws IllegalStateException
	 *             if threads has not been started.
	 */
	public synchronized void stop() {

		System.out.println("stop " + "current" + Thread.currentThread().getName());
		if (!hasStarted) {
			throw new IllegalStateException("start has not been invoked yet.");
		}
		if (runableQueue.isStop()) {
			throw new IllegalStateException("start has not been invoked yet.");
		}

		runableQueue.doStop();
		for (Thread t : threads) {
			try {
				notifyAll();
				t.join();

			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
	}

	/**
	 * Executes the specified Runnable object, using a thread in the pool. run()
	 * method will be invoked in the thread. If the queue is full, then this method
	 * invocation will be blocked until the queue is not full.
	 *
	 * @param runnable
	 *            Runnable object whose run() method will be invoked.
	 *
	 * @throws NullPointerException
	 *             if runnable is null.
	 * @throws IllegalStateException
	 *             if this pool has not been started yet.
	 */

	private boolean hasStarted = false;

	public synchronized void dispatch(Runnable runnable) {
		Objects.requireNonNull(runnable, "runnable must not be null.");
		if (!hasStarted) {
			throw new IllegalStateException("start has not been invoked yet.");
		}
		try {
			while (!runableQueue.put(runnable) && !runableQueue.isStop()) {
				System.err.println("queue is full" + Thread.currentThread().getName());
				wait();

			}
		} catch (InterruptedException e) {
			e.printStackTrace();

		}
		// notifyAll();
	}

}
