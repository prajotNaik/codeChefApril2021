package com.pjt.algo;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class StrongLang {
    public static void main(String args[] ) throws Exception {

    	BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        Integer T = Integer.valueOf(reader.readLine());
        String[] testCases = new String[T];
        String [] inputs = new String[T];
        for(int i =0 ;i <T ; i++){
            testCases[i] = reader.readLine();
            inputs[i] = reader.readLine();
        }

        
        for(int i=0; i<T ;i++){
        	String [] testCase = testCases[i].split(" ");
        	int n = Integer.valueOf(testCase[0]);
        	int k = Integer.valueOf(testCase[1]);
        
        	String input = inputs[i];
        	int count = 0;
        	String out = "NO";
        	for(int j =0; j< input.length(); j++) {
        		char charAt = input.charAt(j);
        		if(charAt == '*') {
        			count ++;
        		}else {
        			count = 0;
        		}
        		if(count==k) {
        			out = "YES";
        			break;
        		}
        	}
        	System.out.println(out);
        }
        
   }
}
