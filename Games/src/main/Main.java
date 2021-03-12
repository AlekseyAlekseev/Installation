package main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        File src = new File("C://JAVA//Installation//Games//src");
        File res = new File("C://JAVA//Installation//Games//res");
        File savegames = new File("C://JAVA//Installation//Games//savegames");
        File temp = new File("C://JAVA//Installation//Games//temp");
        File main = new File("C://JAVA//Installation//Games//src//main");
        File test = new File("C://JAVA//Installation//Games//src//test");
        File drawables = new File("C://JAVA//Installation//Games//res//drawables");
        File vectors = new File("C://JAVA//Installation//Games//res//vectors");
        File icons = new File("C://JAVA//Installation//Games//res//icons");
        File mainFile = new File(main, "Main.java");
        File utilsFile = new File(main, "Utils.java");
        File tempFile = new File(temp, "temp.txt");
        StringBuilder sb = new StringBuilder();


        /**
         * Создание каталогов src, res, savegames, temp, main,
         * test, drawables, vectors, icons
         */
        createCatalog(src, sb);
        createCatalog(res, sb);
        createCatalog(savegames, sb);
        createCatalog(temp, sb);
        createCatalog(main, sb);
        createCatalog(test, sb);
        createCatalog(drawables, sb);
        createCatalog(vectors, sb);
        createCatalog(icons, sb);

        /**
         * Создание файлов Main.java, Utils.java, temp.txt
         */
        createFile(mainFile, sb);
        createFile(utilsFile, sb);
        createFile(tempFile, sb);

        /**
         * Логирование в temp.txt
         */
        writeFile(tempFile, sb);
    }

    /**
     * Метод, который создает передаваемый в него каталог
     * @param file
     * @param sb
     */
    private static void createCatalog(File file, StringBuilder sb) {
        if (file.mkdir()) {
            sb.append("Каталог '").append(file.getName()).append("' успешно создан\n");
        } else {
            sb.append("Каталог '").append(file.getName()).append("' уже существует\n");
        }
    }

    /**
     * Метод, который создает передаваемый в него файл
     * @param file
     * @param sb
     */
    private static void createFile(File file, StringBuilder sb) {
        try {
            if (file.createNewFile()) {
                sb.append("Файл '").append(file.getName()).append("' успешно создан\n");
            } else {
                sb.append("Файл '").append(file.getName()).append("' уже существует\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод записывающий информацию о результате создания файла/каталога в temp.txt
     * @param filePath
     * @param sb
     */
    private static void writeFile(File filePath, StringBuilder sb) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append(sb.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}