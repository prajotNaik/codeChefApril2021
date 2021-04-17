package com.pjt.algo;

import java.io.IOException;

/* Name of the class has to be "Main" only if the class is public. */
public class KMatrix
{
	
	public static void main (String[] args) throws java.lang.Exception
	{
		Integer T = readInt();
		for (int i = 0; i < T; i++) {
			int n = readInt();
			int m = readInt();
			int k = readInt();
			long [][] sumArray = new long[n][m];
			long [][] matSumArray = new long[n][m];
			
			long [][] matrix = new long[n][m];
			int count = 0;
			for(int j =0; j<n ; j ++) {
				for(int l=0;l<m;l++) {
					matrix[j][l]= readInt();
					sumArray[j][l] = (l == 0 ) ? matrix[j][l] : sumArray[j][l-1] + matrix[j][l];
					matSumArray[j][l] = (j==0) ? sumArray[j][l] : matSumArray[j-1][l] + sumArray[j][l];
					if(matrix[j][l]>=k) {
						count++;
					}
				}
			}

			int maxIndex = n<m ? n : m;
			boolean mIsEven = m%2 == 0;
			boolean nIsEven = n%2 == 0;
			int boundry = n/2;
			long start = System.nanoTime();
			for(int a = 2; a<= maxIndex; a++)
			{
				count+=getReverseSubArrayBak(a, matrix, boundry, m, k, matSumArray, n);
				count+=getSubArray(a, matrix, n, m, k, matSumArray,boundry+1);
//				count+=getSubArray(a, matrix, n, m, k, matSumArray,0);				
//				count+=getReverseSubArrayBak(a, matrix, n, m, k, matSumArray,n);
			}
//			System.out.println("Time Taken : " + (System.nanoTime()-start));
			System.out.println(count);
			
		}
	}

	public static int getReverseSubArrayBak(int size, long[][] array, int boundry, int m, int k, long [][] matSumArray, int n) {

		int count =0;
		//int iter = 0;
		boolean[] doneCols = new boolean[m];
		int minCol = -1;
		long nums=size*size;
		for(int i=boundry; i>=0; i--) {
			int iEndCoOrd = i+size-1;
			if(iEndCoOrd < 0 || iEndCoOrd >= n) {
				continue;
			}
			for(int j=m-size;j>=0; j--) {
				int jEndCord = j+size-1;
				if(jEndCord < 0 || jEndCord >= m) {
					continue;
				}
				if(j <minCol) {
					break;
				}
				long sum = 0;
	//			iter ++;
				if(doneCols[j]) {
					continue;
				}
				
				long endCoOrd = matSumArray[iEndCoOrd][jEndCord];
				long leftCoOrd = (i==0) ? 0 : matSumArray[i-1][jEndCord];
				long upCoOrd = (j==0) ? 0 : matSumArray[iEndCoOrd][j-1];
				long topCoOrd = (i==0 || j ==0) ? 0 : matSumArray[i-1][j-1];
				sum=endCoOrd - leftCoOrd - upCoOrd + topCoOrd;
				if(sum/nums >=k) {
					count++;
				}else {
/*					for(int l=0;l<size;l++) {
						if(j-l >= 0)
						doneCols[j-l] = true;
					}*/
					minCol = j;
					break;
				}
			}
		}
//		System.out.println("Size : " + size + ", iterations " + iter + ", Count : " + count);
		return count;
	}

	public static int getSubArray(int size, long[][] array, int n, int m, int k, long [][] matSumArray, int startn) {
		int count =0;
		int iter = 0;
		int nums=size*size;

		int minCol = m+n;
		for(int i=startn; i<n-size+1&&i>=0; i++) {
			for(int j =0 ;j<m-size+1; j++) {
				iter++;
				long sum = 0;
				if(j >=minCol) {
					break;
				}
		sum=matSumArray[i+size-1][j+size-1] - ((i==0) ? 0 : matSumArray[i-1][j+size-1]) - ((j==0) ? 0 : matSumArray[i+size-1][j-1]) + ((i==0 || j ==0) ? 0 : matSumArray[i-1][j-1]);
				if(sum/nums >=k) {
					count++;
					if(j<minCol) {
						if(minCol!=m+n)
					count+=(m-size-j+1)*(n-size-i+1)-1-(m-size-minCol+1)*(n-size-i+1);//(n-size-i);
						else
					count+=(m-size-j+1)*(n-size-i+1)-1;//(n-size-i);							
					minCol = j;
					
					
					break;
					}
				}
			}
		}
//		System.out.println("Size : " + size + ", iterations " + iter);
		return count;
	}
	
	private static int readInt() throws IOException {
	    int ret = 0;
	    boolean dig = false;
	    for (int c = 0; (c = System.in.read()) != -1; ) {
	        if (c >= '0' && c <= '9') {
	            dig = true;
	            ret = ret * 10 + c - '0';
	        } else if (dig) break;
	    }
	    return ret;
	}

}
