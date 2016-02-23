package com.boshkov.os.lab1;

import java.io.*;

public class HW01_4 {

    public static void main(String[] args) throws IOException {
        BufferedReader is = null;
        try{
            is = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
            int c;
            String s = "";
            while((c = is.read()) != -1){
                s += (char)c;
            }
            int offset = 0, count = 0, idx = 0;
            while ((idx = s.indexOf(args[1], offset)) != -1){
                count++;
                offset = idx + args[1].length();
            }

            System.out.println(count);
        }
        catch (IOException e){
            System.out.println("[IOException] " + e.getMessage());
        }
        finally {
            if (is != null) is.close();

        }
    }
}
