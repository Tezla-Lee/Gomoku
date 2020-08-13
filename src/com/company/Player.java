package com.company;

import java.util.Scanner;

public class Player implements Inputtable {
    static int count = 0;
    private String name ;
    int numWin = 0;
    static Gomoku g;
    static Position pos;
    int lineNum = 1;
    int threeNum = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void getKeyboardInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("좌표 입력하세요 : ");
        String cor = sc.nextLine();
        String [] corNum = cor.split(",");
        int [] corInt = new int [2];
        for (int i = 0; i < corInt.length; i++) {
            corInt[i] = Integer.parseInt(corNum[i]);
        }
         pos.setX(corInt[0]);
         pos.setY(corInt[1]);

        // 돌을 놓을 수 없는 경우
        if (pos.getX() < 0 || pos.getY() < 0 || pos.getX() > 15 || pos.getY() > 15 || Gomoku.board[pos.getX()][pos.getY()] == 1 || Gomoku.board[pos.getX()][pos.getY()] == 2) {
            System.out.println("Error, 다시 입력하세요.");
            this.getKeyboardInput();
        } else {
            if (count %2 == 0) {
                g.play(Gomoku.p1, pos);
                count++;
            } else if (count %2 == 1) {
                g.play(Gomoku.p2, pos);
                count++;
            }
            g.checkTPT();
            g.isFinished();
            g.printStatus();
        }
    }
}