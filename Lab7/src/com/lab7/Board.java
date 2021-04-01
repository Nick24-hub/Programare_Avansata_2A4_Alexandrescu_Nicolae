package com.lab7;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Board {
    private int tokenNumber;
    private List<Token> tokenList = new ArrayList<>();

    public Board(int tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    public int getTokenNumber() {
        return tokenNumber;
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    public void setTokenList(List<Token> tokenList) {
        this.tokenList = tokenList;
    }

    public void generateTokens()
    {
        Random rand = new Random();
        List<Integer> shuffledList = new ArrayList<>();
        for(int i=0;i<tokenNumber;++i)
            shuffledList.add(i);
        Collections.shuffle(shuffledList);
        for(int i=0;i<tokenNumber;++i)
            tokenList.add(new Token(i,shuffledList.get(i),rand.nextInt(10)));
    }

    public Token takeToken(int x){
        Token token = tokenList.get(x);
        tokenList.remove(x);
        tokenNumber--;
        return token;
    }
}
