package mypack;

import java.util.Scanner;

import mypack.sample.Student;



public class ArrayDeclaration {
	public static void main(String[] ar)
	{
		Student[] s=new Student[5];
		Scanner sc=new Scanner(System.in);
		     for(int i=0;i<s.length;i++)
		     {
		       System.out.println("enter string");
		    	 s[i].name=sc.next();
		    	 System.out.println("enter no");
		    	 s[i].rollNo=sc.nextInt();
		     }
		     System.out.println(" array values are");
//		     for(int i=0;i<s.length;i++)
//		     {
//		    	 System.out.println(s[i]);
//		     }
//		     System.out.println(s.hashCode());
		     
		     for(Student tem:s)
		     {
		    	 System.out.println(tem.name);
		    	 System.out.println(tem.rollNo);
		     }
	}

}
