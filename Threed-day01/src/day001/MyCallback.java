package day001;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MyCallback implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		try {
			System.out.println(Thread.currentThread().getName()+"正在开始异步发送短信");
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "异步发送短信";
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		FutureTask<String>  futureTask=new FutureTask<>(new MyCallback());
		new Thread(futureTask).start();
		System.out.println("result:"+futureTask.get());
	}

}
