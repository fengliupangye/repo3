package day001;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Mytask  {
	private ReentrantReadWriteLock lock=new ReentrantReadWriteLock();
	
	//多个线程访问，读读共享
	public void read() {
		// TODO Auto-generated method stub
		lock.readLock().lock();
		System.out.println(Thread.currentThread().getName()+"正在读取操作");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"结束读取操作");
		lock.readLock().unlock();
	}
	//多个线程访问，写写互斥
	public void write() {
		// TODO Auto-generated method stub
		lock.writeLock().lock();
		System.out.println(Thread.currentThread().getName()+"正在写入取操作");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(Thread.currentThread().getName()+"结束写入操作");
		lock.writeLock().unlock();
	}
	
	public static void main(String[] args) {
		Mytask mytask=new Mytask();
		/*for(int i=0;i<10;i++){
			new Thread(()-> {mytask.read();}).start();
		}*/
		for(int i=0;i<10;i++){
			new Thread(()-> {mytask.write();}).start();
		}
		for(int i=0;i<10;i++){
			new Thread(()-> {mytask.read ();}).start();
		}
	}

}
