package com.lab7;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(20);
        board.generateTokens();
        Runnable player1 = new Player("Andrei",board);
        Runnable player2 = new Player("George",board);
        new Thread(player1).start();
        new Thread(player2).start();
    }
}
