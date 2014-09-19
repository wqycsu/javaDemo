package wqy;
class Parent{
	private int i = 9;
	protected int j;
	Parent(){
		System.out.println("i = "+i+", j = "+j);
		j = 39;
	}
	private static int x1 = printInit("static Parent.x1 initialized");
	static int printInit(String s){
		System.out.println(s);
		return 47;
	}
}
public class TestExtends extends Parent{
	private int k = printInit("TestExtends.k initialized");
	public TestExtends()
	{
		System.out.println("j = "+j);
		System.out.println("k = "+k);
	}
	
	private static int x2 = printInit("static TestExtends.x2 initialized");
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("TestExtends constructor");
//		TestExtends test = new TestExtends();
		/*
		 *  static Parent.x1 initialized
			static TestExtends.x2 initialized
			TestExtends constructor
		 */
		TestExtends test = new TestExtends();
	}

}
