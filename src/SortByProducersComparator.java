import java.util.Comparator;

public class SortByProducersComparator implements Comparator<Items> {
    @Override
    public int compare(Items o1, Items o2) {
        int c=0;
        c=o1.getProducersName().compareTo(o2.getProducersName());


        return c;
    }

}





//
//import java.util.Comparator;
//
//public class SortByProducersComparator implements Comparator<Producers> {
//    @Override
//    public int compare(Producers p1, Producers p2) {
//        int c =0;
//        c=p1.getName().compareTo(p2.getName());
//
//
//        return c;
//    }
//
//}
