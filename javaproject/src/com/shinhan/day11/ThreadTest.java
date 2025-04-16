package com.shinhan.day11;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


public class ThreadTest {

	public static void main(String[] args) {
		call3();
	}

	private static void call3() {
		ExecutorService exService = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 100; i++) {
			int index = i;
			Future<Integer> future = exService.submit(new Callable<Integer>() {
				@Override
				public Integer call() throws Exception {
					int sum = 0;
					for (int i = 0; i < index; i++) {
						sum += i;
					}
					System.out.println(Thread.currentThread().getName() + " - " + (index + 1) + "까지 합계는 " + sum);
					return sum;
				}
			}); 
			
			try {
				int result = future.get();
				System.out.println("리턴값 " + result);

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		exService.shutdown(); 
	}

	private static void call2() {
		ExecutorService exService = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 100; i++) {
			int index = i;
			exService.execute(new Runnable() {
				@Override
				public void run() {
					int sum = 0;
					for (int i = 0; i < index; i++) {
						sum += i;
					}
					System.out.println(Thread.currentThread().getName() + (index + 1) + "까지 합계는 " + sum);
				}
			});
		}
	}

	private static void call() {
		// 지역 클래스에서 지역변수로 접근 가능하다면 이 변수는 final
		for (int i = 0; i < 100; i++) {
			int index = i;
			Thread t1 = new Thread(new Runnable() {
				@Override
				public void run() {
					int sum = 0;
					for (int i = 0; i < index; i++) {
						sum += i;
					}
					System.out.println(Thread.currentThread().getName() + (index + 1) + "까지 합계는 " + sum);
				}
			});
			t1.start();
		}

	}

	private static void autosave() {
		AutoSaveThread autoSaveThread = new AutoSaveThread();
		autoSaveThread.setDaemon(true); // 데몬 스레드로 만들기
		autoSaveThread.start();

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("메인 종료");
	}

}
