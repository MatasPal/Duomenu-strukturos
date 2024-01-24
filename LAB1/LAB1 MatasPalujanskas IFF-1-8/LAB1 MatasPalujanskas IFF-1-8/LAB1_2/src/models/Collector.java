package models;

import java.util.Objects;

public class Collector implements Comparable<Collector> {
    public String Surname;
    public String Name;
    public String PosterName;
    public Integer Amount;
    public Double Price;



    public Collector(String Surname, String Name, String PosterName, Integer Amount, Double Price) {
        this.Surname = Surname;
        this.Name = Name;
        this.PosterName = PosterName;
        this.Amount = Amount;
        this.Price = Price;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Collector)) return false;
        Collector collector = (Collector) o;
        return Surname.equals(collector.Surname) &&
                Name.equals(collector.Name) &&
                PosterName.equals(collector.PosterName) &&
                Amount.equals(collector.Amount)&&
                Price.equals(collector.Price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Surname, Name, PosterName, Amount, Price);
    }

    @Override
    public String toString() {
        return String.format("| %-20s | %-20s | %-24s | %20s | %20s |", Surname, Name, PosterName, Amount, Price);
    }


    @Override
    public int compareTo(Collector o) {
        if ((Object) o == null)
        {
            return 1;
        }
        Collector other = (o);//pakeisti!
        if (PosterName.compareTo(other.PosterName) == 0)
        {
            return Price.compareTo(other.Price);
        }
        else
        {
            return PosterName.compareTo(other.PosterName);
        }
    }
}
