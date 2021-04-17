package com.pjt.algo;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.*;
public class Bolt {
    public static void main(String args[] ) throws Exception {

    	BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        Integer T = Integer.valueOf(reader.readLine());
        String[] testCases = new String[T];
        for(int i =0 ;i <T ; i++){
            testCases[i] = reader.readLine();
        }

        BigDecimal desiredTime = BigDecimal.valueOf(9.58);
        for(int i=0; i<T ;i++){
        	String [] testCase = testCases[i].split(" ");
        	BigDecimal k1 = new BigDecimal(testCase[0]);
        	BigDecimal k2 = new BigDecimal(testCase[1]);
        	BigDecimal k3 = new BigDecimal(testCase[2]);
        	BigDecimal v = new BigDecimal(testCase[3]);
        
        	BigDecimal speed = k1.multiply(k2).multiply(k3).multiply(v);
        	BigDecimal time = (BigDecimal.valueOf(100).divide(speed, 2, RoundingMode.HALF_UP));//.abs(new MathContext(2, RoundingMode.HALF_UP));
        	if(time.compareTo(desiredTime) == -1) {
        		System.out.println("YES");
        	}else {
        		System.out.println("NO");
        	}
        	}
        
   }
}
