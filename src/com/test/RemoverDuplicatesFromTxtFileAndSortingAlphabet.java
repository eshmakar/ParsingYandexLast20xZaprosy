package com.test;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class RemoverDuplicatesFromTxtFileAndSortingAlphabet<K, V> {

    public static void main(String[] args) throws IOException {
        System.out.println("Starting...");
        LocalDateTime l = LocalDateTime.now();
        String date = l.getYear() + "-" + l.getMonthValue() + "-" + l.getDayOfMonth();
        BufferedReader inputFile = new BufferedReader(new FileReader("C:/YANDEX/2021-6-16.txt"));
        FileWriter outputFile = new FileWriter(new File("C:/YANDEX/res-" + date + ".txt"));

        Map<String, Integer> map = new TreeMap<>();
        List<String> list = new ArrayList<>();

        Scanner scanner = new Scanner(inputFile);
        while (scanner.hasNext()) {
            list.add(scanner.nextLine());
        }
        inputFile.close();
        scanner.close();

        for (String x : list) {
            int count = map.getOrDefault(x, 0);
            map.put(x, count + 1);
        }

        for (String x : list) {
            if (map.getOrDefault(x, 0) < 11)
                map.remove(x);
        }


        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            outputFile.write(entry.getKey() + " - " + entry.getValue().toString());
            outputFile.write("\n");
        }

        outputFile.flush();
        System.out.println("OK");

    }
}
