package day001;

public class Threed001 extends Thread{
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(Thread.currentThread().getName()+"我是子线程");
	}
	
	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName()+"我是主线程");
		new Threed001().start();
	}

}
