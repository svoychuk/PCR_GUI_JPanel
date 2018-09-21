import java.util.Arrays;

public class Test {
	public static void main(String[] args) {
		int a;
		int b;
		int x = 50;
		int[] num1 = {160, 200, 300, 325};
				
		Arrays.sort(num1);
		
		for (int i = 0; i < num1.length; i++) {
			a = num1[i];
			for (int j = i+1; j < num1.length; j++) {
				b = num1[j];
				
				if (a == b) System.out.println("null");
				if(a >= b-x && a!=b) System.out.println(a + " vs " + b + "a & b are equal");
				else System.out.println(a + " vs " + b + "a & b are NOT Equal");
				
				
				}
			}
		}
	}