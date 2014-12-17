import java.util.Scanner;
class BiggestNo
{
  
   public static void main(String[] str)
    {
          
          int a,b,c;
           Scanner sc=new Scanner(System.in);
           System.out.println("enter a number");            
            a=sc.nextInt();
            System.out.println("enter a number");            
            b=sc.nextInt();
            System.out.println("enter a number");            
            c=sc.nextInt();

            if((a>b)&&(a>c))
             {
               System.out.println("a is greatest value  "+a);
             }
           else if((b>c)&&(b>a))
             {

               System.out.println("b is greatest value  "+b);
             } 
           else
              {    
               if((a==b)&&(a==c))
                 {
System.out.println(" all are equal");
}   
               
               System.out.println("c is greatest value  "+c);
                }


   }


}