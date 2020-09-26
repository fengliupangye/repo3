package day001;

public class Threed008 {
	class Res{
		private String userName;
		private String sex;
		private boolean flag;
	}
	
	class InputThread extends Thread{
		Res res;
		
		public InputThread(Res res) {
			// TODO Auto-generated constructor stub
			this.res=res;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			int count=0;
			while (true) {
				synchronized (res) {
					try {
						if(res.flag){
						res.wait();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					if(count==0){
						res.userName="王靖伟";
						res.sex="男";
								
					}else{
						res.userName="小微";
						res.sex="女";
					}
					res.flag=true;
					//唤醒消费者为就绪状态，得到CPU调度
					res.notify();
					//负载均衡，轮循机制
					count=(count+1)%2;
				}
			}
			
		}
		
	}
	
	class OutputThread extends Thread{
		private Res res;
		public OutputThread(Res res) {
			// TODO Auto-generated constructor stub
			this.res=res;
		}
		@Override
		public void run() {
			while (true) {
				synchronized (res) {
						try {
							//释放res对象锁
							if(!res.flag){
								//释放消费者锁
								res.wait();
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					System.out.println(res.userName+","+res.sex);
					res.flag=false;
					res.notify();
				}
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		new Threed008().start();
	}
	
	public void start(){
	  Res res=new Res();
	  new InputThread(res).start();
	  new OutputThread(res).start();
	}
	
}
