import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	
	static ArrayList<Integer> num1 = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		List<Integer> fresh1 = new ArrayList <Integer>();
		List<Integer> fresh2 = new ArrayList <Integer>();
		List<Test>[] sublist = new List[10];
		
		List<List<Test>> lists = null;
		
		Test ar;
		Test br;
		
		int b;
		int h;
		int rD = 50;
		int setQ = 2;		
				
		num1.add(160);
		num1.add(189);
		num1.add(230);
		num1.add(254);
		num1.add(320);
		num1.add(350);
		
		Collections.sort(num1);
		fresh1.add(num1.get(0));
		
		
		for (h = 1; h<=setQ; h++) {
			sublist[h] = new ArrayList<>();
			
			for (int l = 0; l < fresh1.size(); l++) {
				int lastValueInArray = fresh1.get(l);
				
				for (int a : num1) {
					br = new Test();
					System.out.println("Value of Val A1 is " + lastValueInArray);
				for (int j = 1; j < num1.size(); j++) {
					b = num1.get(j);
						
						if (a <= b-rD) {System.out.println(a + " vs " + b + " are Not equal");}
						else {System.out.println(a + " vs " + b + " are Equal");}
						
						if (b >= lastValueInArray + rD) {
							fresh1.add(b);
							sublist[h].add(br);
										
							break;
							} 
						else {
							if (!fresh1.equals(b)) {
								fresh2.add(b);
										
								lists = new ArrayList<>();
								for (int k = 0; k < setQ; k++) {
									lists.add(sublist[h]);
											}
								}
							}
						}	
					System.out.println("Value of Val A1 is " + lastValueInArray);
				break;
					}
				}
			break;
		}
			for (List<Test> temp: lists){
				System.out.println("Set " + h + " " + temp);
				}
			
		System.out.println("Array 1 " + fresh1);
		System.out.println("Array 2 " + fresh2);
		}
	}
	
