package com.boshkov.os.lab1;

import java.io.*;
import java.util.ArrayList;

public class HW01_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader is = null;
        BufferedWriter os = null;
        try{
            is = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("rezultati.csv"), "UTF-8"));
            os = new BufferedWriter(
                    new OutputStreamWriter(
                            new FileOutputStream("rezultati.tsv"), "UTF-8"));

            ArrayList<String> redovi = new ArrayList<String>();
            String s;
            while ((s = is.readLine()) != null){
                redovi.add(s);
            }
            int c = 0;
            for (String r : redovi)
            {
                String[] split = r.split(",");
                if (c > 0){
                    float prosek = 0;
                    for (int i = 1; i < split.length; i++){
                        prosek += Integer.parseInt(split[i]);
                    }
                    prosek /= split.length - 1;

                    System.out.println(split[0] + " " + prosek);
                }

                os.write(r.replace(",", "\t"));
                os.write("\n");
                c++;
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
