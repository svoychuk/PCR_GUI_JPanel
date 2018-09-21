import java.util.Arrays;

public class IntraArrayValuesComparison {
	public static void main(String[] args) {

		int rangeOfDifference = 50;
				
		int[] num1 = {160, 380, 200, 300, 325, 380, 220, 417, 189};
		Arrays.sort(num1);
		
		for (int i = 0; i < num1.length; i++) {
			for (int j = i+1; j < num1.length; j++) {
				if(num1[i] >= num1[j]-rangeOfDifference) {
					System.out.println(num1[i] + " vs " + num1[j] + " are equal");
				}
				else {
					System.out.println(num1[i] + " vs " + num1[j] + " are NOT Equal");}
				}
			}
		}
	}