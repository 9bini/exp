package me.kbin.exp.algo.reflexive;

import java.util.Scanner;

/**
 * 회고: 적절히 배치를 조건으로 생각하지 못했다.
 * <p>
 * opt을 주면 틀리는 이유는
 * <p>
 * 블랙잭이나 스마트와 링크는 선택 순서가 상관 없지만
 * <p>
 * 차이를 최대로에서는 순서가 중요하다 그래서 결과가 다르게 나왔다.
 */
public class P_10819_3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scanner.nextInt();
    }
    boolean[] root = new boolean[n];
    int solution = reflexive(arr, root, 0, arr.length, Integer.MIN_VALUE, new int[n], 0);
    System.out.println(solution);
  }

  /**
   * @param options 선택지
   * @param root    경로
   * @param cP      현재 진행도
   * @param mP      최대 진행도
   * @param p       문제
   * @param sP      풀이과정
   * @return
   */
  public static int reflexive(int[] options, boolean[] root, int cP, int mP,
      int p, int[] sP, int opt) {
    if (cP == mP) {
      int sum = 0;
      for (int i = 0; i < mP - 1; i++) {
        sum += Math.abs(sP[i] - sP[i + 1]);
      }
      return sum;
    }
    for (int i = opt; i < options.length; i++) {
      if (root[i]) {
        continue;
      }
      root[i] = true;
      sP[cP] = options[i];
      p = Math.max(p, reflexive(options, root, (cP + 1), mP, p, sP, i));
      root[i] = false;
    }
    return p;
  }
}
