package day001;

public class Threed002 implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"我是子线程");
	}

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"我是主线程");
		new Thread(new Threed002()).start();
		/*new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(Thread.currentThread().getName()+"我是子线程");
			}
		}).start();*/
		new Thread(() -> System.out.println(Thread.currentThread().getName()+"我是子线程")).start();
	}
	
}
