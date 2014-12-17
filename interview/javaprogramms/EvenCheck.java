class EvenCheck
  {
   public boolean isEven(int e)
      {
        if((e%2)==0)
         {
           return true;
             
          }

        return false;
      }

     
   public static void main(String[] ar)
     {
        EvenCheck ch=new EvenCheck();
        boolean b=ch.isEven(34);
       System.out.println(b);
      }
 
  }