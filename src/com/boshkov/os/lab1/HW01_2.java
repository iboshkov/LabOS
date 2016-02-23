package com.boshkov.os.lab1;
import java.io.*;

public class HW01_2 {

    public static void main(String[] args) throws java.io.IOException {
        FileInputStream is = null;
        FileOutputStream os = null;
        try{
            is = new FileInputStream("izvor.txt");
            os = new FileOutputStream("destinacija.txt");
            int c;
            String s = "";
            while((c = is.read()) != -1){
                s += (char)c;
            }

            for (int i = s.length()-1; i >= 0; i--){
                os.write(s.charAt(i));
            }
        }
        catch (java.io.IOException e){
            System.out.println("[IOException] " + e.getMessage());
        }
        finally {
            if (is != null) is.close();
            if (os != null) os.close();
        }
    }
}
