package me.kbin.exp.algo;

import java.util.Scanner;

public class P_14889 {

  // 첫째 줄에 이 주어진다.
  // 둘째 줄부터 N개의 줄에 S가 주어진다.
  // 각 줄은 N개의 수로 이루어져 있고,
  // i번 줄의 j번째 수는 Sij 이다.
  // Sii는 항상 0이고, 나머지 Sij는 1보다 크거나 같고, 100보다 작거나 같은 정수이다.
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();// N(4 ≤ N ≤ 20, N은 짝수)
    // 숫자 모음
    int[] numbs = new int[N];
    for (int i = 0; i < N; i++) {
      numbs[i] = 0;
    }
    int[][] abls = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        abls[i][j] = sc.nextInt();
      }
    }
    int[] temp = new int[N];
    boolean[] visits = new boolean[N];
    recursive(0, N, numbs, visits, abls, temp);
  }

  private static int recursive(int nowDepth, int maxDepth, int[] numbs, boolean[] visits,
      int[][] abls, int[] temp) {
    int result = Integer.MAX_VALUE;
    if (nowDepth == maxDepth) {

    }
    for (int i = 0; i < numbs.length; i++) {
      if (visits[i]) {
        continue;
      }
      visits[i] = true;
      temp[i] = numbs[i];
      result = Math.min(result, recursive(nowDepth + 1, maxDepth, numbs, visits, abls, temp));
      visits[i] = false;
    }
    return result;
  }
}
