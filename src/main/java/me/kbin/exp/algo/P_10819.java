package me.kbin.exp.algo;

import java.util.Scanner;

// 제목: 차이를 최대로
public class P_10819 {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    // 최대 깊이, 숫자 모음 길이
    int depth = scanner.nextInt();
    // 숫자 모음
    int[] nums = new int[depth];
    for (int i = 0; i < depth; i++) {
      nums[i] = scanner.nextInt();
    }
    // 선택한 숫자
    boolean[] visits = new boolean[depth];
    // 식 계산에 필요한 변수
    int[] temp = new int[depth];
    System.out.println(recursive(0, depth, nums, visits, temp));
  }

  private static int recursive(int nowDept, int maxDept, int[] numbs, boolean[] visits, int[] temp) {
    int result = Integer.MIN_VALUE;
    if (nowDept == maxDept){
      int sum = 0;
      for (int i = 0; i < temp.length-1; i++) {
        sum += Math.abs(temp[i] - temp[i+1]);
      }
      return  sum;
    }
    for (int i = 0; i < numbs.length; i++) {
      if (visits[i])continue;
      visits[i] = true;
      temp[nowDept] = numbs[i];
      result = Math.max(result, recursive(nowDept+1, maxDept, numbs, visits, temp));
      visits[i] = false;
    }
    return result;
  }
}
