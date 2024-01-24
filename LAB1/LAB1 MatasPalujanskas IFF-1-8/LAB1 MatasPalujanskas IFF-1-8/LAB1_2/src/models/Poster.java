package models;

import java.util.Objects;

public class Poster {
    public String Name;
    public String Year;
    public Double AvgPrice;

    public Poster(){}

    public Poster(String name, String year, Double avgPrice)
    {
        this.Name = name;
        this.Year = year;
        this.AvgPrice = avgPrice;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Collector)) return false;
        Poster poster = (Poster) o;
        return Name.equals(poster.Name) &&
                Year.equals(poster.Year) &&
                AvgPrice.equals(poster.AvgPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Name, Year, AvgPrice);
    }

    @Override
    public String toString(){
        return String.format("| %-15s | %15s | %15s |", Name, Year, AvgPrice);
    }



}
