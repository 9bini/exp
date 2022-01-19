package me.kbin.exp.etc;

import static java.lang.System.in;
import static java.lang.System.out;

import java.util.Scanner;


public class VendingMachine {

  private int coin = 0;
  private final Scanner sc = new Scanner(in);

  public void intro() {
    out.println("===자판기ver0.2===");
  }

  public void inputCoin() {
    out.println("금액을 투입하세요");
    Scanner sc = new Scanner(in);
    int addCoin = sc.nextInt();
    out.printf("입력하신 금액은 %d원 입니다.", addCoin);
    coin += addCoin;
  }

  public void selectMenu() {
    out.println("메뉴를 선택하세요");
    if (coin < 400 && coin >= 300) {
      out.println("1.일반커피(300원)");
    } else if (coin >= 400) {
      out.println("1.일반커피(300원),2.고급커피(400원)");
    } else {
      out.println("잔액이 부족하여 선탟할 메뉴가 없습니다.");
      return;
    }

    int put = sc.nextInt();
    if (put == 1) {
      coin -= 300;
      out.println("남은금액은은 " + coin + "원 입니다.");
      out.println("커피를 추출중입니다.");
      out.println("================");
      out.println("일반 커피가 나왔습니다.");

    } else if (put == 2 && coin >= 400) {
      coin -= 400;
      out.println("남은금액은은 " + coin + "원 입니다.");
      out.println("커피를 추출중입니다.");
      out.println("================");
      out.println("고급 커피가 나왔습니다.");

    } else {
      out.println("잘못된 메뉴를 선택하였습니다.");
    }
  }

}

class test6 {

  public static void main(String[] args) {
    VendingMachine vendingMachine = new VendingMachine();
    vendingMachine.intro();
    while (true) {
      vendingMachine.inputCoin();
      vendingMachine.selectMenu();
    }
  }
}