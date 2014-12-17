package mypack;

public class DoWhileDemo {
	public static void main(String[] ar)
	{
		int i=0;
		int count=0;
		do
		{
			if((i%2)==0)
			{
				System.out.println(i);
				count++;
			}
			System.out.println("in loop");
			i++;
		}while(i<=100);
		System.out.println("count="+count);
		
	}

}
