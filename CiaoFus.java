package com.company;
import java.io.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
        String stringa="ciao fus";
        PrintWriter out=new PrintWriter("output.txt");
        for(;;)
            out.print(stringa);
    }
}
