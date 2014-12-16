import java.util.Scanner;
public class largest3 {
	public static void main(String args[])
	{
		int a,b,c;
		Scanner in=new Scanner(System.in);
		System.out.println("enter the value of a,b,c");
		a=in.nextInt();
		b=in.nextInt();
		c=in.nextInt();
		if(a>b && a>c)
			System.out.println("A is large"+a);
		else if(b>a && b>c)
		{
			System.out.println("B is larger"+b);
					}
		else
		{
			System.out.println("C is larger"+c);
		}
	}

}
