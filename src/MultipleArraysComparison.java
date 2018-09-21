import java.util.Arrays;

/***This loop was created by Serhiy Voychuk on 20.09.2018

It lets to compare two arrays of different length;
The same algorithm can be used for comparison of more then two arrays. 
***/

public class MultipleArraysComparison {
	public static void main(String[] args) {
/*** 	Here are several arrays: ***/
		int[] array1 = {1, 2, 3, 1, 2, 2, 1, 8, 2, 1, 1, 5};
		int[] array2 = {3, 2, 3, 5, 2, 3, 1, 3, 4, 6};
		int[] array3 = {3, 2, 3, 1, 2, 2, 1, 8, 2, 1, 3, 5, 6};
				
/***	Stage A: Determine the lengths of the arrays to find the smallest one, we'll need this value for looping:***/
		int array1Length = array1.length;
		int array2Length = array2.length;
		int array3Length = array3.length;
		
/***	Stage B: Find the smallest length of arrays.
		In case of two arrays: 
			to find the minimum array length use Math.min command: ***/
		int MinValueForTwoArrays = Math.min(array1Length, array2Length);
		
/***	In case of three and more arrays: 
			To find the Min value you can do it with the help of a new array (in which put all the lengths of all arrays): ***/
		int [] collectionOfArraysLengths = {array1Length, array2Length, array3Length};
		Arrays.sort(collectionOfArraysLengths);
		int MinValueForMultyArrays = collectionOfArraysLengths[0];
		
/***	Stage C: Loop creation:
			In case of comparison of two arrays use next:
//				for (int i = 0; i < MinValueForTwoArrays; i++) {
			
			In case of comparison of three and more arrays use next:***/
		for (int i = 0; i < MinValueForMultyArrays; i++) {
	
/***		create variables that will represent the values in each of the arrays:***/
			int a = array1[i];
			int b = array2[i];
			int c = array3[i];
			
/***		Here determine how to compare the variables (in my case it (a == b && b==c)) and indicate what should be as a result of such comparison 
 			(in my case it's a System.out.println(...)):
 			***/
				if(a == b && b==c) 
					System.out.println(a + " num1 vs. " + b + " num2 vs. " + c + " num3: are equal");
				else 
					System.out.println(a + " num1 vs. " + b + " num2 vs. " + c + " num3: are NOT Equal");
			}
		}
	}
