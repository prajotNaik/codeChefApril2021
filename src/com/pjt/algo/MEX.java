package com.pjt.algo;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class MEX {
    public static void main(String args[] ) throws Exception {

    	BufferedReader reader = new BufferedReader(
            new InputStreamReader(System.in));
        Integer T = Integer.valueOf(reader.readLine());
        String[] testCases = new String[T];
        for(int i =0 ;i <T ; i++){
            testCases[i] = reader.readLine();
            int seq =0;
            String valueOrg = new String(testCases[i]);
            int count1 = 0;
            int count0 = 0;
            for(int k=0;k<valueOrg.length();k++) {
            	if('0'==valueOrg.charAt(k)) {
            		count0++;
            	}else {
            		count1++;
            	}
            }
            
            int maxCount = count0>count1 ? count0 : count1;
            
            StringBuffer sb = new StringBuffer();
            for(int k =0;k<maxCount;k++) {
            	sb.append("1");
            }
            String maxNum = sb.toString();
            
            while(true) {
            	String value = valueOrg;
            	String binRep = Integer.toBinaryString(seq);
            	boolean check = false;
            	//System.out.println("Checking for " + binRep);
            	if(value.contains(binRep)) {
            		seq++;
            		continue;
            	}
            	
            	for(int j = 0; j<binRep.length(); j++) {
            		int beginIndex = value.indexOf(binRep.charAt(j));
            		if(beginIndex == -1) {
            			check = true;
            			break;
            		}
            		value = value.substring(beginIndex+1);
            	}
            	
            	if(check) {
            		System.out.println(binRep);
            		break;
            	}
            	seq++;
            }
        }

   }
}
