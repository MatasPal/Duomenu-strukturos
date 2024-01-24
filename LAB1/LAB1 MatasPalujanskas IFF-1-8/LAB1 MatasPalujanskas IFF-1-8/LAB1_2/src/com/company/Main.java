package com.company;

import models.Collector;
import models.Poster;
import utils.*;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //Files
        String file1 = "U20aa.txt";
        String file2 = "U20bb.txt";
        String resultFile = "Rezultatai.txt";

        //Reading data
        LinkedList<Poster> allPosters = DataReader.readPosters(file1);
        LinkedList<Collector> allCollectors = DataReader.readCollectors(file2);

        // Getting date
        System.out.println("Įveskite datą:");
        Scanner in = new Scanner(System.in);
        String Date = in.nextLine();

        //Printing primary data
        DataWriter.PrintPostersToScreen(allPosters, "Pradiniai pašto ženklų duomenys:");
        DataWriter.PrintOriginalsPosters(resultFile, allPosters);
        DataWriter.PrintCollectorsToScreen(allCollectors, "Pradiniai kolekcionierių duomenys:");
        DataWriter.PrintOriginalCollectors(resultFile, allCollectors);


        //Most popular posters
        LinkedList<Poster> mostPopular = TaskUtils.FindMosPopularPosters(allCollectors, allPosters);
        DataWriter.PrintPostersToScreen(mostPopular, "Populiariausi pašto ženklai:");
        DataWriter.PrintOtherPosters(resultFile, mostPopular, "Populiariausi pasto zenklai:");


        //Collectors who doesn't have popular posters
        LinkedList<Collector> noPopular = TaskUtils.NoPopularPoster(allCollectors, allPosters);
        DataWriter.PrintCollectorsToScreen(noPopular, "Kolekcionieriai, kurie neturi populiariausio pašto ženklo:");
        DataWriter.PrintOtherCollectors(resultFile, noPopular, "Kolekcionieriai, kurie neturi populiariausio pašto ženklo:");


        //Collectors who has chosen date posters
        LinkedList<Collector> ChosenPosters = TaskUtils.ChosenPoster(allCollectors,allPosters, Date);
        DataWriter.PrintCollectorsToScreen(ChosenPosters, "Kolekcionieriai, kurie turi nurodytos datos pašto ženklų:");
        DataWriter.PrintOtherCollectors(resultFile, ChosenPosters, "Kolekcionieriai, kurie turi nurodytos datos pašto ženklų:");


    }
}
