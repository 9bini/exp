package me.kbin.exp.algo;

import java.util.Scanner;

// 제목: 블랙잭
public class P_2798 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // 최대 깊이
    int depth = 3;
    // 숫자 모음 길
    int numbLength = scanner.nextInt();
    // 식 계산에 필요한 편수
    int target = scanner.nextInt();
    // 숫자 모음
    int[] numbs = new int[numbLength];
    for (int i = 0; i < numbLength; i++) {
      numbs[i] = scanner.nextInt();
    }
    // 선택한 숫자
    boolean[] visits = new boolean[numbLength];

    // 식 계산에 필요한 편수
    int[] cases = new int[depth];
    System.out.println(recursive(0, depth, numbs, visits, cases, target));
  }

  private static int recursive(int nowDept, int maxDept, int[] numbs, boolean[] visits, int[] cases,
      int target) {
    int result = Integer.MIN_VALUE;
    // 최대 깊이 처리
    if (nowDept == maxDept) {
      int sum = 0;
      for (int i = 0; i < maxDept; i++) sum += cases[i];
      if (sum <= target) return sum;
      return -1;
    }
    for (int i = 0; i < numbs.length; i++) {
      if (visits[i]) continue;
      visits[i] = true;
      cases[nowDept] = numbs[i];
      result = Math.max(result, recursive(nowDept + 1, maxDept, numbs, visits, cases, target));
      visits[i] = false;
    }
    return result;
  }
}
