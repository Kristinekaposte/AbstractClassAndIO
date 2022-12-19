import java.util.ArrayList;
import java.util.List;

public class Producers {
    public static List<Producers> allProducers = new ArrayList<>();
    private String name;
    private Double totalRevenue;

    public Producers(String name) {
        this.name = name;
        this.totalRevenue = 0.0;
    }

    public String getName() {
        return this.name;
    }

    public Double getTotalRevenue() {
        return this.totalRevenue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // check for self
        if (o == null || getClass() != o.getClass())
            return false;   // if object is null or if they dont have same class return false
        Producers producers = (Producers) o;

        return (this.name.toLowerCase().equals(producers.getName().toLowerCase())
                //&& totalRevenue.equals(producers.getTotalRevenue())
        );
    }

        @Override
        public int hashCode () {               //  we should get nr. back
            int result = 31 * this.name.toLowerCase().hashCode()
                    //+totalRevenue.hashCode()
                    ;
            return result;
        }


        @Override
        public String toString () {
            return "Name: " + this.name + ", Revenue: " + this.totalRevenue;
        }

    public static ArrayList<Items> searchAndSortProducers(ArrayList<Items> items, String searchByName) {
        ArrayList<Items> matchingProducers = new ArrayList<>();

        // Loop over the items producersNames and if there is a match, add it to the new list we created
        for (Items iteems : items) {
            if (iteems.getProducersName().contains(searchByName)) {
                matchingProducers.add(iteems);
            }}
        // sort the new list
        matchingProducers.sort(new SortByProducersComparator());
        // return matchingProducers
        return matchingProducers;
    }
}