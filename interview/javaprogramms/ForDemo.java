package mypack;

public class ForDemo {
	public static void main(String[] ar) {
		int count=0;
		for (int i = 0; i <= 100; i++) {
           if((i%2)==0)
           {
        	   System.out.println(i);
        	   count++;
           }
		}
		System.out.println(
count);
	}
}
