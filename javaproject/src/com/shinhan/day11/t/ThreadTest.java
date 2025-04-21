package com.shinhan.day11.t;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadTest {

	public static void main(String[] args) {
		 
		try {
			call3();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

		System.out.println("main종료");
	}

	private static void call4() {
		 Thread thread1 = new MovieThread();
		 thread1.start();
		 
		 Thread thread2 = new Thread(new MusicRunnable());
		 thread2.start();
		
	}

	private static void call3() throws InterruptedException, ExecutionException {
	    List<Future<Integer>> arr = new ArrayList<>();
	    
		ExecutorService exService = Executors.newFixedThreadPool(5);
		for (int i = 1; i <= 100; i++) {
			int index = i;
			Future<Integer> result = exService.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int su = 1; su <= index; su++) {
						sum += su;
					}
					System.out.println(Thread.currentThread().getName() + "=====>" + index + " 까지의 합계는 " + sum);
					return sum;
				}
			});
			arr.add(result);
			//System.out.println("Future로 받은 result=" + result.get());
		}
	    for(Future<Integer> f:arr) {
	    	System.out.println(f.get());
	    }
	    exService.shutdown();
	}

	private static void call2() {
		ExecutorService exService = Executors.newFixedThreadPool(5);

		for (int i = 1; i <= 100; i++) {
			int index = i;
			Runnable r1 = () -> {
				int sum = 0;
				for (int su = 1; su <= index; su++) {
					sum += su;
				}
				System.out.println(Thread.currentThread().getName() + "=====>" + index + " 까지의 합계는 " + sum);

			};

			exService.execute(r1);
		}
		exService.shutdown();
	}

	private static void call() {
		// 1~100까지 loop, 1~1 1~2 1~3.......1~100

		for (int i = 1; i <= 100; i++) {
			// Local class에서 local변수를 접근하면 이 변수는 final이다. (수정불가)
			int index = i;

			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					int sum = 0;
					for (int su = 1; su <= index; su++) {
						sum += su;
					}
					System.out.println(Thread.currentThread().getName() + "=====>" + index + " 까지의 합계는 " + sum);

				}
			});
			t1.start();
		}

	}

	private static void autoSave() {
		AutoSaveThread t1 = new AutoSaveThread();
		t1.setDaemon(true); // Daemon은 main종료시 자동으로 끝난다.
		t1.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("autoSave함수종료");

	}

}
