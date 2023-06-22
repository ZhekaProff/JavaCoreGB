package ru.zheka.seminar05;
import java.io.File;
public class Tree {
    /**
     * Рекурсивно выводит директории и файлы
     * @param file
     * @param indent
     * @param isLast
     */
    public static void print(File file, String indent, boolean isLast){
        System.out.print(indent); // рисуем отступ
        if (isLast){
            System.out.print("└─");
            indent += "  ";
        }
        else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());
        // проверяем является ли данный файл директорией
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files == null)
                return;
            int subDirTotal = 0; // количество поддиректорий
            for (int i = 0; i < files.length; i++){
                if (files[i].isDirectory())
                    subDirTotal++;
            }
            int subDirCounter = 0; // счетчик обработанных поддиректорий
            for (int i = 0; i < files.length; i++){
                if (files[i].isDirectory() || files[i].isFile()){
                    print(files[i], indent, subDirCounter == subDirTotal - 1);
                    subDirCounter++;
                }
            }
        }
    }
}
