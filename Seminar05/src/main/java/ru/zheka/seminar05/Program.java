package ru.zheka.seminar05;

import java.io.IOException;

import static ru.zheka.seminar05.Backup.*;

public class Program {
    public static void main(String[] args) throws IOException {
        String source = "C:\\Users\\Zheka\\Desktop\\IT\\книги";
        String destination = "C:/backup";
        backupFolder(source, destination );

    }
}

