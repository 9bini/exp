package me.kbin.exp.etc.client;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Client {
	public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
	    String pw = sc.nextLine();
	    byte[] bytes = pw.getBytes(StandardCharsets.US_ASCII);

	    for(int i = 0; i < bytes.length; i++) {
	      char ch = (char) bytes[i];
	      System.out.println(bytes[i]);
	      System.out.println(ch);
	    }
	  }
}

