package cqupt.interviewQ;

import java.io.IOException;
import java.math.BigDecimal;

public class Test {
	
	public static void main(String[] args) throws IOException {
//		int i = 1;
//		i = i++;
//		int j = i++;
//		int k = i + ++i * i++;
//		System.out.println("i=" + i);// 4
//		System.out.println("j=" + j);// 1
//		System.out.println("k=" + k);// 11
//		System.out.println(Runtime.getRuntime().availableProcessors());

//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		String s = reader.readLine();
//		System.out.println(s);


		BigDecimal b1 = new BigDecimal(0.1);
		BigDecimal b2 = new BigDecimal(0.1);
		System.out.println(b1.equals(b2));

		float f1 = 0.1f;
		float f2 = 0.1f;
		System.out.println(f1 == f2);

	}
}
