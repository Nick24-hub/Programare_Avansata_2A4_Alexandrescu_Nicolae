package com.lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Runnable {
    private final Board board;
    private String name;
    private List<Token> sequence = new ArrayList<>();

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public int getValue()
    {
        int sum=0;
        for (Token token : sequence) sum += token.getValue();
        return sum;
    }

    @Override
    public void run() {
        Random rand = new Random();
        Token token;
        while (board.getTokenNumber() > 0) {
            int x = rand.nextInt(board.getTokenNumber());
            token=board.takeToken(x);
            sequence.add(token);
            System.out.println(name + " a extras token-ul " + token.toString());
        }
    }
}
