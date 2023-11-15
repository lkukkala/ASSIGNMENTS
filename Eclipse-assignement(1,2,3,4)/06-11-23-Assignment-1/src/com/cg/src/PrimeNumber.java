package com.cg.src;

public class PrimeNumber {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=100;
		for(int i=2;i<=n;i++) {
			boolean flag=true;
			for(int j=2;j<i;j++) {
				if(i%j==0)
					flag=false;
			}
			if(flag) {
			System.out.println("Prime numbers are:"+i);	
			}
		}


	}

}
