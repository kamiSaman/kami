package utils;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import encryption.Base64Utils;

public class Test {
	public static void main(String[] args) {
		String str = Base64Utils.getBase64Str("1234567");
		System.out.println(str);
		
		Test test = new Test();
		String aa = test.getNoRepetitionRandomNumber();
		System.out.println(aa);
		
		System.out.print(new Random().nextInt(10));
		
		System.out.println("*********************");
		
		int numner[] = Randoms(9);
        for (int i : numner) {
             System.out.println(i);
        }
	}
	
	 public static int[] Randoms(int number) {

         Random rand = new Random(); //创建一个新随机数生成器
         int nu[] = new int[7];   //创建一个7位的数组,主要是保存结果，我需要7个不重复的随机值
         boolean[] bool = new boolean[number + 1];  //#+1是因为在下面随机数中我为了避开传入的数，不从0开始，所以+1，如果现在这里不加1，会提示越界
         int randint = 0;
         for (int i = 0; i < 7; i++) {
              do {
                   randint = rand.nextInt(number) + 1;  //生成给定的随机数
              } while (bool[randint]);   //#是否已经生成数字，    bool[randint] 默认是false，如果状态已经设置为了true，不进入状态，有执行do
              bool[randint] = true;   //状态设置为true 
              nu[i] = randint;
         }
         return nu;
	 }
	
	public String getNoRepetitionRandomNumber() {
	    Random random = new Random();
	    HashSet<Integer> set = new HashSet<Integer>();
	    while(set.size() < 8) {
	    	int tmp = random.nextInt(10);
	    	System.out.print(tmp);
	    	set.add(tmp);
	    }
	    String result = set.toString();
	    
	    for (Integer integer : set) {
			System.out.println(integer);
		}
	    return result;
	}
	
	public String getRandomNumber() {
	    Random random = new Random();
	    String result = "";
	    while(result.length() < 8) {
	    	result += (random.nextInt(10));
	    }
	    return result;
	}
}
