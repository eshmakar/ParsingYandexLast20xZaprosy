package com.test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.Scanner;

public class ParsingYandexLast20x {
    public static void main(String[] args) throws IOException, InterruptedException {
        LocalDateTime l = LocalDateTime.now();
        String date = l.getYear() + "-" + l.getMonthValue() + "-" + l.getDayOfMonth();
        FileWriter f = new FileWriter(new File("C:/YANDEX/" + date + ".txt"), true);
        String url = "https://export.yandex.ru/last/last20x.xml";
        while (true) {
            StringBuilder sb = new StringBuilder();
            InputStream response = null;
            try {
                response = new URL(url).openStream();
                Scanner scanner = new Scanner(response);
                while (scanner.hasNext())
                    sb.append(scanner.nextLine()).append("\n");
                response.close();
                String temp = sb.toString();
                String res = temp.replaceAll("<item found=\"\\d+\">|<\\/item>|<page>|<last20x>|<\\/last20x>|\\/page>|<\\?xml version=\"1.0\" encoding=\"utf-8\"\\?>|<", "").strip();
//            System.out.println(res);
                f.write(res);
                f.flush();
            } catch (Exception e) {
            }
            Thread.sleep(100);
        }
    }
}