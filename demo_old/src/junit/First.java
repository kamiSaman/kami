package junit;

public class First {
	public static void main(String[] args) {
		aa(2);
		String relativelyPath=System.getProperty("user.dir"); 
		System.out.println(relativelyPath);
	}
	
	public static void aa(int i){
		if(i==1){
			return;
		}
	}
}
