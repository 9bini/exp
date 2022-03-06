package me.kbin.exp.algo.reflexive;

import java.util.Scanner;

/**
 * 총 N명이고 신기하게도 N은 짝수이다
 * <p>
 * N/2명으로 이루어진 스타트 팀과 링크 팀으로 사람들을 나눠야 한다.
 * <p>
 * 사람에게 번호를 1부터 N까지로 배정 모든 경우, 대한 식 팀 능력치 최소
 */

/**
 * 현재방식으로는 결과는 나오지만 시간초과가된다.
 * 모든곳을 방문하기 때문에 시간이 많이 걸려 시간초과됨
 * 현재의 문제에서 모든 곳을 방문해야 되는 거 아닌가?
 * N이 4라고 가정할 때 현재 방문 수 12
 * 불필요한 방문을 줄이면 6
 *
 * opt을 줘서 지나간 index를 되돌아가는 걸 막는다.
 */
public class P_14889 {

  static int callCount = 0;
  static int[][] options;
  static int max;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int N = scanner.nextInt();
    options = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        options[i][j] = scanner.nextInt();
      }
    }
    max = N / 2;
    int temp = reflexive(new boolean[N], 0, Integer.MAX_VALUE,0);
    System.out.println(temp);
  }

  public static int reflexive(boolean[] root, int current, int problem, int opt) {
    if (current == max) {
      callCount++;
      int sum = 0;
      int teamLength = root.length / 2;

      int[] linkTeam = new int[teamLength];
      int linkCount = 0;

      int[] startTeam = new int[teamLength];
      int startCount = 0;

      for (int i = 0; i < root.length; i++) {
        if (root[i]) {
          linkTeam[linkCount++] = i;
        } else {
          startTeam[startCount++] = i;
        }
      }
      for (int j = 0; j < teamLength - 1; j++) {
        for (int k = j + 1; k < teamLength; k++) {
          sum += options[linkTeam[j]][linkTeam[k]] + options[linkTeam[k]][linkTeam[j]];
          sum -= options[startTeam[j]][startTeam[k]] + options[startTeam[k]][startTeam[j]];
        }
      }

      return Math.min(problem, Math.abs(sum));
    }
    for (int i = opt; i < root.length; i++) {
      if (root[i]) {
        continue;
      }
      root[i] = true;
      problem = Math.min(problem, reflexive(root, current + 1, problem, i));
      root[i] = false;
    }
    return problem;
  }

}
