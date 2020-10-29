package util;

import java.io.*;
import java.text.*;
import java.util.*;
import java.net.*;

public class ServerA
{
    public static void main(String[] args) throws IOException
    {

    	 try {
             ServerSocket s = new ServerSocket(9999);
             String str;
             while (true) {
                 Socket c = s.accept();
                 InputStream i = c.getInputStream();
                 OutputStream o = c.getOutputStream();
                 do {
                     byte[] line = new byte[100];                    
                     i.read(line);
                     str = new String(line);
                     
                     String total = calcular(str);
                     o.write(total.getBytes());                
//                     System.out.println(str.trim());
//                     str = new String(line);
                     		
                 } while ( !str.trim().equals("s") );
                 c.close();
             }
         }
         catch (Exception err){
             System.err.println(err);
         }
    }
    
    public static String calcular(String str) {
    	
		str.replace(" ", "").trim();
		char [] expre = str.toCharArray();
		String str1[] = new String[4];
		int h=0;
		for (int j=0; j < expre.length; j++) {
			
			if(Character.isDigit(expre[j])|| (expre[j] == '/') || (expre[j] == '*') || (expre[j] == '+') || (expre[j] == '-')) {
				
				if(Character.isDigit(expre[j])) {
						if(h>0 && Character.isDigit(expre[j-1])) {
							str1[h-1] = str1[h-1] + Character.toString(expre[j]);    
							h--;
						}else {
							str1[h] = Character.toString(expre[j]);  
						}
						    					
				}else {
					str1[h] = Character.toString(expre[j]);
				}
				h++;
			}
			
		}
		
		switch (str1[1]) {
		case "*":
			return "" + (Double.parseDouble(str1[0]) * Double.parseDouble(str1[2]));
			
		case "/":
			return "" + (Double.parseDouble(str1[0]) / Double.parseDouble(str1[2]));
			
		case "+":
			return "" + (Double.parseDouble(str1[0]) + Double.parseDouble(str1[2]));
			
		case "-":
			return "" + (Double.parseDouble(str1[0]) - Double.parseDouble(str1[2]));				

		default:
			return "" ;					
		}
	    	
    }	    	
}