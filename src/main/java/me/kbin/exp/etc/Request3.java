package me.kbin.exp.etc;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Request3 {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String pw = sc.nextLine();
    //인코딩
    byte[] bytes = pw.getBytes(StandardCharsets.US_ASCII);

    String test = new String();
    for(int i = 0; i < bytes.length; i++) {
      test += bytes[i];
      test+=" ";
    }
    System.out.println("test = " + test);

    // 디코딩
    String[] splits = test.split(" ");
    String result = new String();
    for (String s : splits) {
      int i = Integer.parseInt(s);
      result += Character.toString((char) i);
    }

    System.out.println("result = " + result);
  }
}
