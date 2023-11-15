package com.cg.src;

import java.util.Scanner;

public class ArmStrong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter a number");
		int n= sc.nextInt();
		int t=n,r=0,sum=0;
		while(n>0)
		{
			r=n%10;
			sum=sum+r*r*r;
			n=n/10;	
		}
		if(sum==t) {
			System.out.println("ArmStrong Number");
		}
		else {
			System.out.println("Not an ArmStrong Number");
		}
 

	}

}
