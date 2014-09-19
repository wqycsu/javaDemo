package wqy;

interface A{
	public void printf();
	public int printf(int i);
}

//interface B{
//	public int printf();
//}

class B{
	public void printf(){
		System.out.println("printf of B");
	}
}

class Test implements A{

	@Override
	public void printf() {
		// TODO Auto-generated method stub
		System.out.println("printf of Test");
	}

	@Override
	public int printf(int i) {
		// TODO Auto-generated method stub
		System.out.println("printf(int) of Test");
		return 0;
	}
	
}

public class TestInterface {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test test = new Test();
		test.printf();
		test.printf(0);
		A a = new Test();
		a.printf();
		a.printf(0);
	}

}
