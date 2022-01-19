package me.kbin.exp.etc;

import java.util.Scanner;

public class Request1 {

  public static void main(String[] args) {
    int coin = 0;
    intro(); // "===자판기ver0.2==="
    while (true) {
      coin += inputCoin(); //동전투입
      coin -= selectMenu(coin); //메뉴 고르기
      System.out.println(String.format("현재 보유중인 금액 %d 입니다.", coin));
    }
  }

  public static void intro() {
    System.out.println("===자판기ver0.2===");
    return;
  }

  public static int inputCoin() {

    System.out.println("금액을 투입하세요");
    Scanner sc = new Scanner(System.in);
    int coin = sc.nextInt();
    System.out.println("입력하신 금액은 " + coin + "원 입니다.");
    return coin;
  }


  public static int selectMenu(int coin) {
    Scanner sc = new Scanner(System.in);

    System.out.println("메뉴를 선택하세요");

    if (coin < 400 && coin >= 300) {
      System.out.println("1.일반커피(300원)");
    } else if (coin >= 400) {
      System.out.println("1.일반커피(300원),2.고급커피(400원)");
    } else {
      System.out.println("잔액이 부족하여 선탟할 메뉴가 없습니다.");
      return 0;
    }

    int put = sc.nextInt();
    if (put == 1) {
      System.out.println("남은금액은은" + coin + "원 입니다.");
      System.out.println("커피를 추출중입니다.");
      System.out.println("================");
      System.out.println("일반 커피가 나왔습니다.");
      return 300;
    } else if (put == 2 && coin >= 400) {
      System.out.println("남은금액은은" + coin + "원 입니다.");
      System.out.println("커피를 추출중입니다.");
      System.out.println("================");
      System.out.println("고급 커피가 나왔습니다.");
      return 400;
    } else {
      System.out.println("잘못된 메뉴를 선택하였습니다.");
    }
    return 0;
  }
}