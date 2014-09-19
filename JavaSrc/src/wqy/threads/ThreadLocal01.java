package wqy.threads;

import java.util.Random;

public class ThreadLocal01 {
	private static int k = 0;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<2;i++){
			new Thread(){
				public void run(){
					k = new Random().nextInt();
					System.out.println(Thread.currentThread().getName()+" put value to i "+k);
					new A().get();
					new B().get();
					try{
						Thread.sleep(2000);
					}catch(Exception e){
						e.printStackTrace();
					}
				}
			}.start();
		}
	}
	
	static class A{
		public void get(){
			System.out.println("A from "+Thread.currentThread().getName()+" get value "+k);
		}
	}

	static class B{
		public void get(){
			System.out.println("B from "+Thread.currentThread().getName()+" get value "+k);
		}
	}
	
}
