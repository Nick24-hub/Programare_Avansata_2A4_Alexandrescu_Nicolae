package com.lab7;

import java.awt.*;
import java.util.ArrayList;
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
        for(int i=0;i<tokenNumber-1;++i)
        {
            for(int j=i+1;j<tokenNumber;++j)
                tokenList.add(new Token(i,j,rand.nextInt(10)));
        }
    }

    public Token takeToken(int x){
        Token token = tokenList.get(x);
        tokenList.remove(x);
        tokenNumber--;
        return token;
    }
}
