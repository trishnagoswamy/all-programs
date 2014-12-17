package mypack;

public class ConstructorDemo {
	public static void main(String[] ar)
	{
		ConstructorDemo cd=new ConstructorDemo(10,"hai",false);
	}
	public ConstructorDemo()
	{
		System.out.println("default constructor");
	}
	public ConstructorDemo(int a)
	{
		System.out.println("integer constructor"+a);
	}
	public ConstructorDemo(int s,String a,boolean b)
	{
		System.out.println("string value"+a);
	}

}
