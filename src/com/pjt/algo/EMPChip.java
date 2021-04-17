package com.pjt.algo;

/* 
 * Enter your code here. Read input from STDIN. Print your output to STDOUT. 
 * Your class should be named CandidateCode.
*/
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class EMPChip {
    public static void main(String args[] ) throws Exception {

    	BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String initParams = reader.readLine();
        int T = Integer.valueOf(initParams.split(" ")[0]);
        int Q = Integer.valueOf(initParams.split(" ")[1]);
        int D = Integer.valueOf(initParams.split(" ")[2]);
        
        long multiplier = 2000000000000000000l;//200000l;//
    	long trueleft = -1*multiplier;
    	long trueright = multiplier;
    	String prev="";
        for(int i =0 ;i <T ; i++){
        	long rightx=trueright;
        	long leftx=trueleft;
        	long righty=trueright;
        	long lefty=trueleft;

        	//2000000000000000000l
        	int attack = 1;
        	long mid = (trueleft+trueright)/2;
        	long y = 1;
        	String response = "";
        	long x1= leftx;
        	long x2 = rightx;
        	long y1 = lefty;
        	long y2 = leftx;
        	int outCount = 0;
        	int iteration = 1;
        	
        	while(!response.equalsIgnoreCase("O")) {
        		
        		if(attack==1) {
        			System.out.println(attack+" "+mid+" "+y);
        		}else {
        			System.out.println(attack+" "+x1+" "+y1+" "+x2+" "+y2);
        		}
        		
        		response = reader.readLine();
        		if(response.equalsIgnoreCase("O")) {
        			break;
        		}
        		if(response.equalsIgnoreCase("FAILED")) {
        			throw new NullPointerException();
        		}

        		if(response.equalsIgnoreCase("NN")) {
        			leftx=mid;
        			lefty=y;
        			mid=mid+(rightx-mid)/2;// ==> increase X
        			y=y+(righty-y)/2;// ==> increase Y
        			//attack=1;
        		}else if(response.equalsIgnoreCase("NP")) {
        			leftx=mid;
        			righty=y;
        			mid=mid+(rightx-mid)/2;// ==> increase X
        			y=y-(y-lefty)/2;// ==> decrease Y
        			//attack=1;
        		}else if(response.equalsIgnoreCase("PN")) {
        			lefty=y;
        			rightx=mid;
        			mid=mid-(mid-leftx)/2;// ==> decrease X
        			y=y+(righty-y)/2;// ==> increase Y
        			//attack=1;
        		}else if(response.equalsIgnoreCase("PP")) {
        			rightx=mid;
        			righty=y;
        			mid=mid-(mid-leftx)/2;// ==> decrease X
        			y=y-(y-lefty)/2;// ==> decrease Y
        			//attack=1;
        		}else if(response.charAt(0) == 'X') {
        			attack=2;
        			//		2 x1  y1        x2  y2
        			x1=mid;
        			y1=trueleft;
        			x2=mid+1;
        			y2=trueright;
        			prev="xattack";
        		}else if(response.charAt(1) == 'Y') {
        			attack=2;
        			//		2 x1  y1        x2  y2
        			x1=trueleft;
        			y1=y;
        			x2=trueright;
        			y2=y+1;
        			prev="yattack";
        		}else if(response.equalsIgnoreCase("OUT")) {
        			if(outCount>=1) {
        				attack=1;
        				outCount = 0;
        			}else {
	        			if(prev.equalsIgnoreCase("yattack")) {
	            			x1 = trueleft;
	        				y1 = y-1;
	        				x2=trueright;
	        				y2=y;
	        			}else if(prev.equalsIgnoreCase("xattack")) {
	        				x1 = mid-1;
	        				y1 = trueleft;
	        				x2 = mid;
	        				y2 = trueright;
	        			}
	        			outCount++;
        			}
        		}else if(response.equalsIgnoreCase("IN")) {
        			attack=2;

        			if(prev.equalsIgnoreCase("yattack")) {
        				x1 = trueleft;
        				y1 = y;
        				x2=trueright;
        				y2=y;
        			}else if(prev.equalsIgnoreCase("xattack")) {
        				x1 = mid;
        				y1 = trueleft;
        				x2 = mid;
        				y2 = trueright;
        			}
        			
        		}
        		
        		
        	}
        }

   }
    
}
