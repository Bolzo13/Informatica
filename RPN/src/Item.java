package com.simone;

public class Item {
    int val;
    char op;
    boolean isOp;

    public Item(int val){
        this.val = val;
        isOp = false;
    }

    public Item(char op){
        this.op = op;
        isOp = true;
    }
}