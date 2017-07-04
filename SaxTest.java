/*哥德巴赫猜想：任何一个大于2的偶数都能表示为两个素数之和。下程序的目的就是在1~100内验证该猜想的正确性*/
public class SaxTest {
   public int array[] = new int[101];  //以其值为下标来存储100以内的素数
   public static void main(String[] args){
      SaxTest st = new SaxTest();
      st.find();
      st.verify();
      //System.out.println(5>=5);
   }
   //找出100内的所有素数，并让其下标与其值等同，即array[7]=7,array[13]=13
   public void find(){
      array[2] = 2;
      for(int i=3; i<100; i=i+2){
         int flag = 0;
         for(int j=3; j<i; j++){
            if(i%j == 0)
               flag = 1;
         }
         if(flag == 0){
            array[i] = i;
         }
      }
   }
   //证明
   public void verify(){
      for(int k=4; k<101; k=k+2){
         int temp = k;
         while(temp >= k/2){
            if(array[temp] !=0 && array[k-temp]!=0){
               System.out.println(k +"="+array[temp]+"+"+array[k-temp]+";");
               break;
            }
            temp--;
         }
      }
   }
}
