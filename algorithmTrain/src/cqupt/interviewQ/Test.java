package cqupt.interviewQ;

public class Test {
	
	public static void main(String[] args) {
		int i = 1;
		i = i++;
		int j = i++;
		int k = i + ++i * i++;
		System.out.println("i=" + i);// 4
		System.out.println("j=" + j);// 1
		System.out.println("k=" + k);// 11
		System.out.println(Runtime.getRuntime().availableProcessors());
	}
}
