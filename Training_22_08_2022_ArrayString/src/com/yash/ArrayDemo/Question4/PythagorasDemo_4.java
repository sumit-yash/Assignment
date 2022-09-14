package com.yash.ArrayDemo.Question4;

public class PythagorasDemo_4 {
	
	public static void main(String[] args) {
		int[] arr= {3,4,5,6,7,8,9,12,13};
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				for(int k=j+1;k<arr.length;k++) {
					int fnSquare=arr[i]*arr[i];
					int snSquare=arr[j]*arr[j];
					int lnSquare=arr[k]*arr[k];
					if(fnSquare+snSquare==lnSquare) {
						System.out.println(arr[i]+" : "+arr[j]+" = "+arr[k]);
					}
				}
			}
		}
	}

}
