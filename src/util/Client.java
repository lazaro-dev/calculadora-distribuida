package util;

// Java implementation for a client
// Save file as Client.java

import java.io.*;
import java.net.*;
import java.util.Scanner;

// Client class
public class Client
{
    public static void main(String[] args) throws IOException
    {
        try
        {
            Scanner scn = new Scanner(System.in);

            InetAddress ip = InetAddress.getByName("localhost");
            String str;
            String str1;
            String str3;
            String str5;
           
            Socket s = new Socket(ip, 5056);
            Socket s2 = new Socket(ip, 5057);

            while (true)
            {
            	InputStream i = s.getInputStream();
            	OutputStream o = s.getOutputStream();
            	InputStream i2 = s2.getInputStream();
            	OutputStream o2 = s2.getOutputStream();
	        	 byte[] line1 = new byte[100];
	        	 byte[] line2 = new byte[100];
	        	 byte[] line3 = new byte[100];
	        	 byte[] total = new byte[500];
            	System.out.println("Digite o primeiro número:");
                System.in.read(line1);              
                System.out.println("Digite a operação: + => (soma) - => (subtração) * => (multiplicação) / => (divisão) r => raiz ^ => pontencia s => sair?");
                System.in.read(line2);              
                System.out.println("Digite o segundo número:");
                System.in.read(line3);              

                str1 = new String(line1);                
                str = new String(line2);                
                str3 = new String(line3);   
                
                String tot;        
            	
                if(str.trim().equals("+") || str.trim().equals("-") || str.trim().equals("*") || str.trim().equals("/")) {
                	
                	tot = str1.trim()+" "+str.trim()+" "+str3.trim();                	
                	total = tot.getBytes();
                	o.write(total);
                	i.read(total);
                }else if(str.trim().equals("r") || str.trim().equals("^") || str.trim().equals("%")){
                	
                	tot = str1.trim()+" "+str.trim()+" "+str3.trim();
                	total = tot.getBytes();
                	o2.write(total);
                	i2.read(total);
                }
                
                
				str5 = new String(total);
				System.out.println("\n"+str5+"\n");
                
                if(str.trim().equals("s"))
                {
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                }
              
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}