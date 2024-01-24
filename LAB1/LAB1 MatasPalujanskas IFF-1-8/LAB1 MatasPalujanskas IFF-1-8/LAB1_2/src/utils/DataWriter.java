package utils;

import models.Collector;
import models.Poster;

import java.io.FileWriter;
import java.io.IOException;

public class DataWriter {
    public static void PrintPostersToScreen(LinkedList<Poster> Posters, String header)
    {
        String dashes = new String("-".repeat(55));
        System.out.println(header);
        System.out.println(dashes);
        System.out.println(String.format("| %-15s | %-15s | %-15s |",
                "Pavadinimas", "Išleidimo data", "Vidutinė kaina"));
        System.out.println(dashes);
        for (Poster p: Posters)
        {
            System.out.println(p.toString());
        }
        System.out.println(dashes+"\n");

    }
    public static void PrintCollectorsToScreen(LinkedList<Collector> Collectors, String header)
    {
        String dashes = new String("-".repeat(120));
        System.out.println(header);
        System.out.println(dashes);
        System.out.println(String.format("| %-20s | %-20s | %-24s | %-20s | %-20s |",
                "Pavardė", "Vardas", "Pavadinimas", "Kiekis", "Pardavimo kaina"));
        System.out.println(dashes);
        for (Collector c: Collectors)
        {
            System.out.println(c.toString());
        }
        System.out.println(dashes+"\n");
    }
    public static void PrintOriginalsPosters(String FileName, LinkedList<Poster>
            Posters) throws IOException {
        FileWriter writer = new FileWriter(FileName);
        String dashes = new String("-".repeat(55));
        writer.write("Pradiniai pašto ženklų duomenys:\n");
        writer.write(dashes+"\n");
        writer.write(String.format("| %-15s | %-15s | %-15s |",
                "Pavadinimas", "Išleidimo data", "Vidutinė kaina"));
        writer.write("\n");
        writer.write(dashes+"\n");
        for (Poster p: Posters)
        {
            writer.write(p.toString()+"\n");
        }
        writer.write(dashes+"\n");
        writer.write("\n");
        writer.close();
    }

    public static void PrintOriginalCollectors(String FileName, LinkedList<Collector>
            Collectors) throws IOException {
        FileWriter writer = new FileWriter(FileName, true);
        String dashes = new String("-".repeat(120));
        writer.write("Pradiniai kolekcionierių duomenys:\n");
        writer.write(dashes+"\n");
        writer.write(String.format("| %-20s | %-20s | %-24s | %-20s | %-20s |",
                "Pavardė", "Vardas", "Pavadinimas", "Kiekis", "Pardavimo kaina"));
        writer.write("\n");
        writer.write(dashes+"\n");
        for (Collector c: Collectors)
        {
            writer.write(c.toString()+"\n");
        }
        writer.write(dashes+"\n");
        writer.write("\n");
        writer.close();
    }
    public static void PrintOtherPosters(String FileName, LinkedList<Poster>
            Posters, String header) throws IOException {
        FileWriter writer = new FileWriter(FileName, true);
        String dashes = new String("-".repeat(55));
        writer.write(header + "\n");
        writer.write(dashes+"\n");
        writer.write(String.format("| %-15s | %-15s | %-15s |",
                "Pavadinimas", "Išleidimo data", "Vidutinė kaina"));
        writer.write("\n");
        writer.write(dashes+"\n");
        for (Poster p: Posters)
        {
            writer.write(p.toString()+"\n");
        }
        writer.write(dashes+"\n");
        writer.write("\n");
        writer.close();
    }
    public static void PrintOtherCollectors(String FileName, LinkedList<Collector>
            Collectors, String header) throws IOException {
        FileWriter writer = new FileWriter(FileName, true);
        String dashes = new String("-".repeat(120));
        writer.write(header + "\n");
        writer.write(dashes+"\n");
        writer.write(String.format("| %-20s | %-20s | %-24s | %-20s | %-20s |",
                "Pavardė", "Vardas", "Pavadinimas", "Kiekis", "Pardavimo kaina"));
        writer.write("\n");
        writer.write(dashes+"\n");
        for (Collector c: Collectors)
        {
            writer.write(c.toString()+"\n");
        }
        writer.write(dashes+"\n");
        writer.write("\n");
        writer.close();
    }
}
