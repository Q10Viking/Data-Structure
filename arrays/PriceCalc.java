package org.q10viking.arrays;

import java.util.Scanner;

public class PriceCalc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T!=0) {
			int N = sc.nextInt();
			int[] priceArr = new int[N];
			for(int i=0;i<N;i++)
				priceArr[i] = sc.nextInt();
			average(priceArr);
			T--;
		}
	}
	
	private static void average(int[] priceArr) {
		int sum=0,length=priceArr.length;
		float avg;
		for(int a: priceArr)
			sum += a;
		avg = (float)sum/length;
		String strAvg = String.format("%.02f", avg);
		System.out.println(sum+" "+strAvg);
		
	}

}

/*
2
5
1 2 3 4 5
15 3.00
9
2 55 85 656 52 554 545 5 2
1956 217.33
*/

