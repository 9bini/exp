package me.kbin.exp.algo.reflexive;

import java.util.Scanner;

/*
 * 좋은 수열이고 그 중에서 가장 작은 수열
 *
 * 1. 수열 제공
 * 2. 좋은 수열 확인하는 로직
 * 3. 가장 작은 수열을 비교하는 로직
 */

public class P_2661 {


  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    String[] options = new String[]{"1", "2", "3"};
    dfs2(0,N,options,-1,"");
  }

  public static boolean goodSequence(String str) {
    for (int i = 1; i <= str.length() / 2; i++) {
      String front = str.substring(str.length() - i * 2, str.length() - i);
      String back = str.substring(str.length() - i);
      if (front.equals(back)) {
        return false;
      }
    }
    return true;
  }


  public static void dfs2(int current, int max, String[] options, int root, String now) {
    if (current == max) {
      System.out.println(now);
      System.exit(0);
    }
    for (int i = 0; i < options.length; i++) {
      if (i == root) continue;
      String temp = now + options[i];
      if (goodSequence(temp)) {
        dfs2(current+1, max, options, i, temp);
      }
    }
  }
}
