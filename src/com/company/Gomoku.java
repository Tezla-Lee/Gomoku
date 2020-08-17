package com.company;

import java.util.Scanner;

public class Gomoku implements Simulatable, Winnable, Playable, Printable {
    static int[][] board;
    int count = 0;
    static Player p1 = new Player();
    static Player p2 = new Player();

    @Override
    public void play(Player player, Position pos) {
        if (count % 2 == 0) {
            board[pos.getX()][pos.getY()] = 1;
            count++;
        } else if (count % 2 == 1) {
            board[pos.getX()][pos.getY()] = 2;
            count++;
        }
    }

    @Override
    public void printStatus() {
        for (int i = 0; i < board.length; i++) {
            if (i == 0) {
                System.out.println();
                System.out.println("    1  2  3  4  5  6  7  8  9 10 11 12 13 14 15");
            }
            System.out.printf("%2d  ", i + 1);
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    System.out.printf("%c  ", '+');
                } else if (board[i][j] == 1) {
                    System.out.printf("%c  ", 'X');
                } else {
                    System.out.printf("%c  ", 'O');
                }
            }
            System.out.println();
        }
        if (count % 2 == 0) {
            p1.getKeyboardInput();
            count++;
        } else if (count % 2 == 1) {
            p2.getKeyboardInput();
            count++;
        }
    }

    @Override
    public void initialize() {
        Scanner sc = new Scanner(System.in);
        board = new int[15][15];
        if (count % 2 == 0) {
            p1.getKeyboardInput();
            count++;
        } else if (count % 2 == 1) {
            p2.getKeyboardInput();
            count++;
        }
        sc.close();
    }

    @Override
    public void isFinished() {
        // 가로
        p1.lineNum = 1;
        p2.lineNum = 1;
        if (board[Player.pos.getX()][Player.pos.getY()] == 1) {
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getX() + i >= 15)
                    break;
                if (board[Player.pos.getX() + i][Player.pos.getY()] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getX() - i < 0)
                    break;
                if (board[Player.pos.getX() - i][Player.pos.getY()] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            if (p1.lineNum == 5) {
                p1.numWin += 1;
                System.out.println(p1.getName() + " : " + p1.numWin + " 번 이겼습니다.");
                this.end();
            }
        }
        if (board[Player.pos.getX()][Player.pos.getY()] == 2) {
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getX() + i >= 15) {
                    break;
                } else if (board[Player.pos.getX() + i][Player.pos.getY()] == 2) {
                    p2.lineNum++;
                } else {
                    break;
                }
            }
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getX() - i < 0) {
                    break;
                } else if (board[Player.pos.getX() - i][Player.pos.getY()] == 2) {
                    p2.lineNum++;
                } else {
                    break;
                }
            }
            if (p2.lineNum == 5) {
                p2.numWin += 1;
                System.out.println(p2.getName() + " : " + p2.numWin + " 번 이겼습니다.");
                this.end();
            }
        }

        //세로
        p1.lineNum = 1;
        p2.lineNum = 1;
        if (board[Player.pos.getX()][Player.pos.getY()] == 1) {
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getY() + i >= 15)
                    break;
                if (board[Player.pos.getX()][Player.pos.getY() + i] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getY() - i < 0)
                    break;
                if (board[Player.pos.getX()][Player.pos.getY() - i] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            if (p1.lineNum == 5) {
                p1.numWin += 1;
                System.out.println(p1.getName() + " : " + p1.numWin + " 번 이겼습니다.");
                this.end();
            }
        }
        if (board[Player.pos.getX()][Player.pos.getY()] == 2) {
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getY() + i >= 15)
                    break;
                if (board[Player.pos.getX()][Player.pos.getY() + i] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getY() - i < 0)
                    break;
                if (board[Player.pos.getX()][Player.pos.getY() - i] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            if (p2.lineNum == 5) {
                p2.numWin += 1;
                System.out.println(p2.getName() + " : " + p2.numWin + " 번 이겼습니다.");
                this.end();
            }
        }

        // 대각선1
        p1.lineNum = 1;
        p2.lineNum = 1;
        if (board[Player.pos.getX()][Player.pos.getY()] == 1) {
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getX() + i >= 15 || Player.pos.getY() + i >= 15)
                    break;
                if (board[Player.pos.getX() + i][Player.pos.getY() + i] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getX() - i < 0 || Player.pos.getY() - i < 0)
                    break;
                if (board[Player.pos.getX() - i][Player.pos.getY() - i] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            if (p1.lineNum == 5) {
                p1.numWin += 1;
                System.out.println(p1.getName() + " : " + p1.numWin + " 번 이겼습니다.");
                this.end();
            }
        }
        if (board[Player.pos.getX()][Player.pos.getY()] == 2) {
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getX() + i >= 15 || Player.pos.getY() + i >= 15)
                    break;
                if (board[Player.pos.getX() + i][Player.pos.getY() + i] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getY() - i < 0)
                    break;
                if (board[Player.pos.getX() - i][Player.pos.getY() - i] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            if (p2.lineNum == 5) {
                p2.numWin += 1;
                System.out.println(p2.getName() + " : " + p2.numWin + " 번 이겼습니다.");
                this.end();
            }
        }

        // 대각선2
        p1.lineNum = 1;
        p2.lineNum = 1;
        if (board[Player.pos.getX()][Player.pos.getY()] == 1) {
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getX() - i < 0 || Player.pos.getY() + i > 14)
                    break;
                if (board[Player.pos.getX() - i][Player.pos.getY() + i] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getX() + i > 14 || Player.pos.getY() - i < 0) {
                    break;
                } else if (board[Player.pos.getX() + i][Player.pos.getY() - i] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            if (p1.lineNum == 5) {
                p1.numWin += 1;
                System.out.println(p1.getName() + " : " + p1.numWin + " 번 이겼습니다.");
                this.end();
            }
        }
        if (board[Player.pos.getX()][Player.pos.getY()] == 2) {
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getX() - i < 0 || Player.pos.getY() + i >= 15)
                    break;
                if (board[Player.pos.getX() - i][Player.pos.getY() + i] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 5; i++) {
                if (Player.pos.getX() + i >= 15 || Player.pos.getY() - i < 0)
                    break;
                if (board[Player.pos.getX() + i][Player.pos.getY() - i] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            if (p2.lineNum == 5) {
                p2.numWin += 1;
                System.out.println(p2.getName() + " : " + p2.numWin + " 번 이겼습니다.");
                this.end();
            }
        }
    }

    @Override
    public void reset() {
        p1.lineNum = 1;
        p2.lineNum = 1;
        p1.threeNum = 0;
        p2.threeNum = 0;
        this.initialize();
    }

    @Override
    public void end() {
        System.out.println("종료하시려면 q를 입력하세요. 계속 하시려면 아무 키나 입력하세요.");
        Scanner sc = new Scanner(System.in);
        String q = sc.nextLine();
        if (q.equals("q")) {
            System.out.println(p1.getName() + " " + p1.numWin + " - " + p2.numWin + " " + p2.getName());
            System.exit(0);
        } else {
            this.reset();
        }
    }

    @Override
    public void checkTPT() {
        // 가로
        p1.threeNum = 0;
        p2.threeNum = 0;
        p1.lineNum = 1;
        p2.lineNum = 1;
        if (board[Player.pos.getX()][Player.pos.getY()] == 1) {
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getX() + i > 14)
                    break;
                if (board[Player.pos.getX() + i][Player.pos.getY()] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }

            for (int i = 1; i < 3; i++) {
                if (Player.pos.getX() - i < 0)
                    break;
                if (board[Player.pos.getX() - i][Player.pos.getY()] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            if (p1.lineNum == 3) {
                p1.threeNum += 1;
            }
        }
        if (board[Player.pos.getX()][Player.pos.getY()] == 2) {
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getX() + i > 14)
                    break;
                if (board[Player.pos.getX() + i][Player.pos.getY()] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getX() - i < 0)
                    break;
                if (board[Player.pos.getX() - i][Player.pos.getY()] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            if (p2.lineNum == 3) {
                p2.threeNum += 1;
            }
        }

        //세로
        p1.lineNum = 1;
        p2.lineNum = 1;
        if (board[Player.pos.getX()][Player.pos.getY()] == 1) {
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getY() + i > 14)
                    break;
                if (board[Player.pos.getX()][Player.pos.getY() + i] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getY() - i < 0)
                    break;
                if (board[Player.pos.getX()][Player.pos.getY() - i] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            if (p1.lineNum == 3) {
                p1.threeNum += 1;
            }
        }

        if (board[Player.pos.getX()][Player.pos.getY()] == 2) {
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getY() + i > 14) {
                    break;
                } else if (board[Player.pos.getX()][Player.pos.getY() + i] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getY() - i < 0)
                    break;
                if (board[Player.pos.getX()][Player.pos.getY() - i] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            if (p2.lineNum == 3) {
                p2.threeNum += 1;
            }
        }

        // 대각선1
        p1.lineNum = 1;
        p2.lineNum = 1;
        if (board[Player.pos.getX()][Player.pos.getY()] == 1) {
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getX() + i > 14 || Player.pos.getY() + i > 14)
                    break;
                if (board[Player.pos.getX() + i][Player.pos.getY() + i] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getX() - i < 0 || Player.pos.getY() - i < 0)
                    break;
                if (board[Player.pos.getX() - i][Player.pos.getY() - i] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            if (p1.lineNum == 3) {
                p1.threeNum += 1;
            }
        }
        if (board[Player.pos.getX()][Player.pos.getY()] == 2) {
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getX() + i > 14 || Player.pos.getY() + i > 14)
                    break;
                if (board[Player.pos.getX() + i][Player.pos.getY() + i] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getY() - i < 0)
                    break;
                if (board[Player.pos.getX() - i][Player.pos.getY() - i] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            if (p2.lineNum == 3) {
                p2.threeNum += 1;
            }
        }

        // 대각선2
        p1.lineNum = 1;
        p2.lineNum = 1;
        if (board[Player.pos.getX()][Player.pos.getY()] == 1) {
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getX() - i < 0 || Player.pos.getY() + i > 14)
                    break;
                if (board[Player.pos.getX() - i][Player.pos.getY() + i] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getX() + i > 14 || Player.pos.getY() - i < 0) {
                    break;
                } else if (board[Player.pos.getX() + i][Player.pos.getY() - i] == 1) {
                    p1.lineNum++;
                } else
                    break;
            }
            if (p1.lineNum == 3) {
                p1.threeNum += 1;
            }
        }
        if (board[Player.pos.getX()][Player.pos.getY()] == 2) {
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getX() - i < 0 || Player.pos.getY() + i > 14)
                    break;
                if (board[Player.pos.getX() - i][Player.pos.getY() + i] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            for (int i = 1; i < 3; i++) {
                if (Player.pos.getX() + i >= 14 || Player.pos.getY() - i < 0)
                    break;
                if (board[Player.pos.getX() + i][Player.pos.getY() - i] == 2) {
                    p2.lineNum++;
                } else
                    break;
            }
            if (p2.lineNum == 3) {
                p2.threeNum += 1;
            }
        }
        if (p1.threeNum >= 2) {
            p2.numWin += 1;
            System.out.println(p1.getName() + " 33 반칙패");
            System.out.println(p2.getName() + " : " + p2.numWin + " 번 이겼습니다.");
            this.end();
        } else if (p2.threeNum >= 2) {
            p1.numWin += 1;
            System.out.println(p1.getName() + " 33 반칙패");
            System.out.println(p1.getName() + " : " + p1.numWin + " 번 이겼습니다.");
            this.end();
        }
    }

    @Override
    public Player getWinner() {
        return null;
    }
}