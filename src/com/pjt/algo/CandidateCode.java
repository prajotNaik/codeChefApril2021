package com.pjt.algo;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {

    	BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        Integer T = Integer.valueOf(reader.readLine());
        String[] testCases = new String[T];
        for(int i =0 ;i <T ; i++){
            testCases[i] = reader.readLine();
        }

        for(int i=0; i<T ;i++){
        	String [] testCase = testCases[i].split(" ");
        	int no1 = Integer.valueOf(testCase[0]);
        	int no2 = Integer.valueOf(testCase[1]);
        	
        	if(no1 > no2) {
        		System.out.println("-1");
        	}else {
        		if(no1 == 1) {
        			no1++;
        		}else if(no1 == 0 ) {
        			no1+=2;
        		}
        		int firstPrime = -1;
        		for(int j = no1;j<=no2; j++) {
        			boolean isPrime = true;
        			for(int k=2;k<j;k++) {
        				if(j%k == 0) {
        					isPrime = false;
        					break;
        				}
        			}
        			if(isPrime) {
        				firstPrime = j;
        				break;
        			}
        		}
        		
        		int lastPrime = -1;
        		for(int j = no2;j>=no1; j--) {
        			boolean isPrime = true;
        			for(int k=2;k<j;k++) {
        				if(j%k == 0) {
        					isPrime = false;
        					break;
        				}
        			}
        			if(isPrime) {
        				lastPrime = j;
        				break;
        			}
        		}
        		
        		if(firstPrime == -1 && lastPrime == -1) {
        			System.out.println(-1);
        		}else if(firstPrime == -1 || lastPrime == -1) {
        			System.out.println(0);
        		}else {
        			System.out.println(lastPrime - firstPrime);
        		}
        	}
        }

   }
}
