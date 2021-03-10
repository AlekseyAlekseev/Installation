package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File src = new File("D://JAVA//Installation//Games//src");
        File res = new File("D://JAVA//Installation//Games//res");
        File savegames = new File("D://JAVA//Installation//Games//savegames");
        File temp = new File("D://JAVA//Installation//Games//temp");
        File main = new File("D://JAVA//Installation//Games//src//main");
        File test = new File("D://JAVA//Installation//Games//src//test");
        File drawables = new File("D://JAVA//Installation//Games//res//drawables");
        File vectors = new File("D://JAVA//Installation//Games//res//vectors");
        File icons = new File("D://JAVA//Installation//Games//res//icons");
        File mainFile = new File(main, "Main.java");
        File utilsFile = new File(main, "Utils.java");
        File tempFile = new File(temp, "temp.txt");
        StringBuilder sb = new StringBuilder();

        /**
         * Создание папки src
         */
        if (src.mkdir()) {
            sb.append(createAccess(src));
        } else {
            sb.append(createFail(src));
        }
        /**
         * Создание папки res
         */
        if (res.mkdir()) {
            sb.append(createAccess(res));
        } else {
            sb.append(createFail(res));
        }
        /**
         * Создание папки savegames
         */
        if (savegames.mkdir()) {
            sb.append(createAccess(savegames));
        } else {
            sb.append(createFail(savegames));
        }
        /**
         * Создание папки temp
         */
        if (temp.mkdir()) {
            sb.append(createAccess(temp));
        } else {
            sb.append(createFail(temp));
        }
        /**
         * Создание папки main
         */
        if (main.mkdir()) {
            sb.append(createAccess(main));
        } else {
            sb.append(createFail(main));
        }
        /**
         * Создание папки test
         */
        if (test.mkdir()) {
            sb.append(createAccess(test));
        } else {
            sb.append(createFail(test));
        }
        /**
         * Создание папки drawables
         */
        if (drawables.mkdir()) {
            sb.append(createAccess(drawables));
        } else {
            sb.append(createFail(drawables));
        }
        /**
         * Создание папки vectors
         */
        if (vectors.mkdir()) {
            sb.append(createAccess(vectors));
        } else {
            sb.append(createFail(vectors));
        }
        /**
         * Создание папки icons
         */
        if (icons.mkdir()) {
            sb.append(createAccess(icons));
        } else {
            sb.append(createFail(icons));
        }
        /**
         * Создание файла Main.java
         */
        try {
            if (mainFile.createNewFile()) {
                sb.append(createAccess(mainFile));
            } else {
                sb.append(createFail(mainFile));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /**
         * Создание файла Utils.java
         */
        try {
            if (utilsFile.createNewFile()) {
                sb.append(createAccess(utilsFile));
            } else {
                sb.append(createFail(utilsFile));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        /**
         * Создание файла temp.txt
         */
        try {
            if (tempFile.createNewFile()) {
                sb.append(createAccess(tempFile));
            } else {
                sb.append(createFail(tempFile));
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        /**
         * Логирование в temp.txt
         */
        try (FileWriter writer = new FileWriter("D://JAVA//Installation//Games//temp//temp.txt")) {
            writer.append(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод возвращающий сообщение об успешном создании файла/каталога.
     * Сделан, чтобы не засорять код дубликата текста.
     */
    private static StringBuilder createAccess(File file) {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(file.getName()).append("'").append(" успешно создан");
        return sb;
    }

    /**
     * Метод возвращающий сообщение об не успешном создании файла/каталога.
     * Сделан, чтобы не засорять код дубликата текста.
     */
    private static StringBuilder createFail(File file) {
        StringBuilder sb = new StringBuilder();
        sb.append("'").append(file.getName()).append("'").append(" уже существует");
        return sb;
    }
}