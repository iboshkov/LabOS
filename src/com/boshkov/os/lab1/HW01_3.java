package com.boshkov.os.lab1;

import java.io.*;

public class HW01_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader is = null;
        BufferedWriter os = null;
        try{
            is = new BufferedReader(new InputStreamReader(new FileInputStream("izvor.txt"), "UTF-8"));
            os = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("destinacija.txt"), "UTF-8"));
            int c;
            String s = "";
            while((c = is.read()) != -1){
                s += (char)c;
            }

            for (int i = s.length()-1; i >= 0; i--){
                os.write(s.charAt(i));
            }
        }
        catch (IOException e){
            System.out.println("[IOException] " + e.getMessage());
        }
        finally {
            if (is != null) is.close();
            if (os != null) os.close();
        }
    }
}
