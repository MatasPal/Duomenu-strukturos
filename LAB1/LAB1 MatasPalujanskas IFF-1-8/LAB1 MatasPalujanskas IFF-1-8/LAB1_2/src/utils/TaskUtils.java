package utils;
import models.Collector;
import models.Poster;
import java.util.ArrayList;
import java.util.List;

public class TaskUtils {

    /// <summary>
    /// Finds how many people have most popular posters
    /// </summary>
    /// <param name="collectors">List of collectors</param>
    /// <param name="posters">List of posters</param>
    /// <returns>Count of the most popular posters owners</returns>
    public static int HighestPosterCount(LinkedList<Collector> collectors, LinkedList<Poster> posters)
    {
        int maxCount = 0;
        for(Poster p: posters)
        {
            int posterCount = 0;
            for(Collector c: collectors)
            {
                if(c.PosterName.equals(p.Name))
                    posterCount++;
            }
            if(posterCount > maxCount)
            {
                maxCount = posterCount;
            }
        }
        return  maxCount;
    }
    public boolean Contains(LinkedList<Collector> list, String obj)
    {
        for(Collector collector: list)
        {
            if(collector.PosterName == obj)
            {
                return true;
            }
        }
        return false;
    }
    /// <summary>
    /// Finds the most popular poster
    /// </summary>
    /// <param name="collectors">List of collectors</param>
    /// <param name="posters">List of posters</param>
    /// <returns>Most popular posters</returns>
    public static LinkedList<Poster> FindMosPopularPosters(LinkedList<Collector> collectors, LinkedList<Poster> posters) {
        LinkedList<Poster> mostPopularPosters = new LinkedList<Poster>();
        int maxCount = HighestPosterCount(collectors, posters);
        int posterCount = 0;
        for (Poster p : posters) {
            posterCount = 0;
            for (Collector c : collectors) {
                if (c.PosterName.equals( p.Name)) posterCount++;
            }
            if (posterCount == maxCount) {
                mostPopularPosters.add(p);
            }
        }
        return mostPopularPosters;
    }
    /// <summary>
    /// Finds collectors who doesn't have popular posters
    /// </summary>
    /// <param name="Collectors">Collector data</param>
    /// <param name="posters">posters data</param>
    /// <returns>List of collectors, who doesn't have popular posters</returns>
    public static LinkedList<Collector> NoPopularPoster(LinkedList<Collector> collectors, LinkedList<Poster> posters )
    {
        LinkedList<Collector> NCollectors = new LinkedList<Collector>();
        LinkedList<Poster> mostPopular = FindMosPopularPosters(collectors, posters);
        for(Poster p: mostPopular) {
            for (Collector c : collectors) {
                if ( c.PosterName != (p.Name) && !collectors.equals(mostPopular)){
                    NCollectors.add(c);
                }
            }
        }
        return NCollectors;
    }
    /// <summary>
    /// Searches for posters, which are the same date as written in the web and puts it's owner to a list
    /// </summary>
    /// <param name="CollectorData">Collector info</param>
    /// <param name="PosterData">Poster info</param>
    /// <param name="Date">Date written from web</param>
    /// <returns>List of collectors who has chosen year's poster</returns>
    public static LinkedList<Collector> ChosenPoster(LinkedList<Collector> collectors, LinkedList<Poster> posters, String Date)
    {
        LinkedList<Collector> CollectorsC = new LinkedList<Collector>();
        for(Poster p: posters) {
            for (Collector c : collectors) {

                if (Date.equals(p.Year) && p.Name.equals(c.PosterName) &&
                        c.Price <= p.AvgPrice)
                {
                    CollectorsC.add(c);
                }
            }
        }
        return CollectorsC;
    }
}
