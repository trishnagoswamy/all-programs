package mypack;

public class WhileLoopdemo {
	public static void main(String[] ar)
	{
		int i=0;
		int count=0;
		while(i>100)
		{
			if((i%2)==0)
			{
				System.out.println(i);
				count++;
			}
			System.out.println("in loop");
			i++;
		}
		System.out.println("count="+count);
		
	}

}
