import java.util.Scanner;
public class swapwithout3rd {
	public static void main(String args[])
	{
		int a,b;
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the value of a and b");
		a=in.nextInt();
		b=in.nextInt();
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println("elements after swap = "+a+"  "+b);
		
	}

}
