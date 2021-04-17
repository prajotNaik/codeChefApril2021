package com.pjt.algo;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/
import java.io.*;
import java.math.BigDecimal;
public class Dice {
    public static void main(String args[] ) throws Exception {

    	BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        Integer T = Integer.valueOf(reader.readLine());
        String[] testCases = new String[T];
        for(int i =0 ;i <T ; i++){
            testCases[i] = reader.readLine();
        }

        //6<-->1
        //5<-->2
        //4<-->3
        for(int i=0; i<T ;i++){
        	Long testCase = Long.valueOf(testCases[i]);
        	if(testCase==1) {
        		System.out.println(20);
        	}else if(testCase == 2) {
        		System.out.println(36);
        	}else if(testCase == 3) {
        		System.out.println(51);
        	}else if(testCase == 4) {
        		System.out.println(60);
        	}else {
        		long topRow = testCase%4;//0
        		long stackHeight = (testCase-topRow)/4;//2500000000
        		long num = countPip(topRow) - ((topRow)* 4);//51 - 12 = 39
        		long completeStackPip = 44 * (stackHeight - 1) + 60; //44 * 2 = 88
        		//System.out.println("top : " + topRow + ", num : " + num + ", stackHeight :" + stackHeight + ", Final :" + (completeStackPip + num));
        		String answer = BigDecimal.valueOf((completeStackPip + num)).toEngineeringString(); //88 + 39
        		//110,000,000,016
        		//110,000,000,016
        		if(answer.contains(".")) {
        			System.out.println(answer.substring(0, answer.indexOf('.')));
        		}else {
        			System.out.println(answer);
        		}
        		//System.out.println(answer.substring(0, answer.indexOf('.')));
        	}
        }
        
   }
    public static long countPip(long testCase) {
    	if(testCase==1) {
    		return 20;
    	}else if(testCase == 2) {
    		return 36;
    	}else if(testCase == 3) {
    		return 51;
    	}else if(testCase == 4) {
    		return 60;
    	}
    		return 0;
    	
    }
}
