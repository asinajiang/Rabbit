import java.util.Scanner;

public class Factorial{
   public static void main(String[] args){
      System.out.println("请输入一个正整数：");
      Scanner scInt = new Scanner(System.in);
      int N = scInt.nextInt();
      int count = 0;
      for(int i=1; i<N+1; i++){
         int j = i;
         while(j%5 == 0){
            count++;
            j = j/5;
         }
      }
      System.out.println("一共 有"+count+"个0");
   }
}
