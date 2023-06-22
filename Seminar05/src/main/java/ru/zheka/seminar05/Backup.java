package ru.zheka.seminar05;


import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class Backup {
    public static void backupFolder(String sourcePath, String backupPath) {
        File sourceFolder = new File(sourcePath);
        File backupFolder = new File(backupPath);
        if (!backupFolder.exists()) {
            backupFolder.mkdir();
        }
        if (sourceFolder.listFiles().length > 0) {
            for (File file : sourceFolder.listFiles()) {
                if (file.isFile()) {
                    Path sourceFilePath = file.toPath();
                    Path backupFilePath = Paths.get(backupPath + File.separator + file.getName());
                    try {
                        Files.copy(sourceFilePath, backupFilePath, StandardCopyOption.REPLACE_EXISTING);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                    backupFolder(file.getAbsolutePath(), backupPath);
                }
            }
        }
    }
}
