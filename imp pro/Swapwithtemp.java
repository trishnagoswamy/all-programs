import java.util.Scanner;
public class Swapwithtemp {
	public static void main(String args[])
	{
		int a,b,temp;
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the value of a and b");
		a=in.nextInt();
		b=in.nextInt();
		System.out.println("Elements before swap="+a+"\n="+b);
		temp=a;
		a=b;
		b=temp;
		System.out.println("elements after swaping="+a+"\n"+b);
		
		
		
	}

}
