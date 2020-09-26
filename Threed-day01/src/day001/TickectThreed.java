package day001;

public class TickectThreed implements Runnable{
	private static  int count=100;
	@Override
	public  void run() {
		// TODO Auto-generated method stub
		while(count>0){
			ticket();
		}
	}
	
	public synchronized static void ticket(){
		if(count>0){
			System.out.println(Thread.currentThread().getName()+",正在出票第"+(100-count+1)+"张");
			count--;
		}
	}
	
	public static void main(String[] args) {
		TickectThreed tickectThreed=new TickectThreed();
		new Thread(tickectThreed,"窗口一").start();
		new Thread(tickectThreed,"窗口二").start();
	}

}
