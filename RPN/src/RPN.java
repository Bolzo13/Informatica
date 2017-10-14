package com.simone;

import java.util.ArrayList;

public class RPN {
    private ArrayList<Item> exp;

    public RPN(ArrayList<Item> exp){
        this.exp = exp;
    }

    public RPN(){
        exp = new ArrayList<>();
    }

    public void append(char op){
        this.exp.add(new Item(op));
    }

    public void append(int val){
        this.exp.add(new Item(val));
    }

    public int eval(){
        if(this.exp == null)
            throw new NullPointerException("Expression not initialized");
        else{
            Pila s = new Pila();
            for(int i = 0; i < exp.size(); i++){
                if(exp.get(i).isOp){
                    switch (exp.get(i).op){
                        case '+': s.push((int) (s.pop()) + (int) (s.pop())); break;
                        case '-': s.push((int) (s.pop()) - (int) (s.pop())); break;
                        case '*': s.push((int) (s.pop()) * (int) (s.pop())); break;
                        case '/': s.push((int) (s.pop()) / (int) (s.pop())); break;
                    }
                }
                else
                    s.push(exp.get(i).val);
            }
            return (int)s.pop();
        }
    }
}
