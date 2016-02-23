package com.boshkov.os.lab1;

import java.io.*;
import java.util.ArrayList;

public class HW01_1 {

    public static void main(String[] args) throws IOException {
        File dir = new File(args[0]);
        if (!dir.isDirectory())
            return;
        File[] files = dir.listFiles();
        float golemina = 0; int br = 0;
        for (File f : files){
            if (f.isDirectory() || !f.getName().contains(".txt") || !f.canRead())
                continue;
            System.out.println(f.getName());
            golemina += f.length();
            br++;
        }

        System.out.println(golemina/br);
    }
}
