package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        File dir = new File("D://Games");
        File src = new File(dir, newDir("src", dir));
        File res = new File(dir, newDir("res", dir));
        File savegame = new File(dir, newDir("savegame", dir));
        File temp = new File(dir, newDir("temp", dir));
        File main = new File(src, newDir("main", src));
        File test = new File(src, newDir("test", src));
        File drawables = new File(res, newDir("drawable", res));
        File vectors = new File(res, newDir("vectors", res));
        File icons = new File(res, newDir("icons", res));


        File mainJava = new File(main, newFile("Main.java", main));
        File utiljava = new File(main, newFile("Utils.java", main));
        File temptxt = new File(temp, newFile("temp.txt", temp));
        try (FileWriter writer = new FileWriter(temptxt, false)) {
            writer.write(String.valueOf(sb));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());

        }

     
    }

    private static String newDir(String nameDir, File dir) {
        File newDir = new File(dir, nameDir);
        if (newDir.mkdir()) {
            sb
                    .append("Папка " + nameDir + " создана")
                    .append("\n");

        }
        return nameDir;
    }

    private static String newFile(String nameFile, File dir) {
        File newFile = new File(dir, nameFile);
        try {
            if (newFile.createNewFile()) {
                sb
                        .append("Фаил " + nameFile + " создан")
                        .append("\n");
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            ;
        }
        return nameFile;
    }
}
