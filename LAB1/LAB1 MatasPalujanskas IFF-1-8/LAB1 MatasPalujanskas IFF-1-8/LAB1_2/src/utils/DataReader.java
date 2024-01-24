package utils;

import models.Collector;
import models.Poster;

import java.io.FileInputStream;
import java.util.Scanner;

public class DataReader {
    public static LinkedList<Poster> readPosters(String filePath) {
        LinkedList<Poster> allPosters = new LinkedList<Poster>();
        FileInputStream fileStream = null;
        Scanner scanner = null;
        try {
            fileStream = new FileInputStream(filePath);
            scanner = new Scanner(fileStream, "UTF-8");
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split(";");
                allPosters.add(new Poster(lines[0], lines[1], Double.parseDouble(lines[2])));
            }
            fileStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return allPosters;
    }
    public static LinkedList<Collector> readCollectors(String filePath) {
        LinkedList<Collector> allCollectors = new LinkedList<Collector>();
        FileInputStream fileStream = null;
        Scanner scanner = null;
        try {
            fileStream = new FileInputStream(filePath);
            scanner = new Scanner(fileStream, "UTF-8");
            while (scanner.hasNextLine()) {
                String[] lines = scanner.nextLine().split(";");
                allCollectors.add(new Collector(lines[0], lines[1], lines[2], Integer.parseInt((lines[3])), Double.parseDouble(lines[4])));
            }
            fileStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            if (scanner != null) {
                scanner.close();
            }
        }
        return allCollectors;
    }
}
