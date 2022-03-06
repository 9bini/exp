package me.kbin.exp.algo.reflexive;

import java.util.Scanner;

/**
 * N장의 카드에 써져 있는 숫자가 주어졌을 때 M을 넘지 않으면서 M에 최대한 가까운 카드 3장의 합을 구해 출력하시오.
 */
public class P_2798_3 {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    int M = scanner.nextInt();

    int[] arr = new int[N];
    for (int i = 0; i < N; i++) {
      arr[i] = scanner.nextInt();
    }
    int temp = reflexive(arr, new boolean[N], 0, 3, -1, 0, M, 0);
    System.out.println(temp);
  }

  /**
   *
   * @return
   */
  /**
   * @param options  선택지
   * @param root     경로
   * @param current  현재 진행도
   * @param max      최대 진행도
   * @param problem  문제
   * @param solution 풀이과정
   * @param opt      M
   * @return
   */
  public static int reflexive(int[] options, boolean[] root, int current, int max,
      int problem, int solution, int opt, int opt2) {
    if (current == max) {
      if (solution > opt) {
        return problem;
      }
      return Math.max(problem, solution);
    }
    for (int i = opt2; i < options.length; i++) {
      if (root[i]) {
        continue;
      }
      root[i] = true;
      problem = Math.max(problem,
          reflexive(options, root, current + 1, max, problem, solution + options[i], opt, i));
      root[i] = false;
    }

    return problem;
  }

}
