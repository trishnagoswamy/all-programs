import java.util.Scanner;
public class factorial {
	public static void main(String args[])
	{
		int n,c,fact=1;
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the number");
		n=in.nextInt();
		if(n!=0)
		{
			for(c=1;c<=n;c++)
			{
				fact=fact*c;
			}
			
		}
		System.out.println("Factorial of a given number = "+fact);
	}

}
