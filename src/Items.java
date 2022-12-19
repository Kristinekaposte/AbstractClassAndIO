import java.util.ArrayList;
import java.util.List;

public abstract class Items  {
    private final String ANSI_GREEN = "\u001B[32m";
    private   final String RESET = "\033[0m";
    public String productName;
    public Double price;
    public ProductsType productsType;
    public Producers producers;
    public static List<Items> clothingItemList=new ArrayList<>();
    public static List<Items> gardeningItemList=new ArrayList<>();

    public Items (String productName,Double price, ProductsType productsType){
        this.productName=productName;
        this.price=price;
        this.productsType=productsType;
    }
    public void setProducers(Producers producers) {
        this.producers = producers;
    }

 // this class makes sure
 // that all classes who extends it has these methods
 // we can't make object with this abstract class
 // but can access its methods from child classes
    public abstract String getProductName();
    public abstract Double getPrice();
    public abstract ProductsType getProductsType();

    public Producers getProducers() {
        return producers;
    }
    public String getProducersName(){
        return this.producers.getName();
    }

//    @Override
//    public int hashCode () {               //  we should get nr. back
//        int result = 31 * productName.toLowerCase().hashCode()
//                + price.hashCode()
//                +productsType.hashCode()
//                +producers.hashCode()
//                ;
//        return result;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true; // check for self
//        if (o == null || getClass() != o.getClass())
//            return false;   // if object is null or if they dont have same class return false
//        Items items = (Items) o;
//
//        return (productName.toLowerCase().equals(items.getProductName().toLowerCase())
//                && price == items.getPrice()
//                && productsType == items.getProductsType()
//                && producers == items.getProducers()
//        );
//    }

    public String toString(){
        return ANSI_GREEN+"\nNAME: "+RESET+this.productName
                +ANSI_GREEN+", PRICE: "+RESET+this.price
                +ANSI_GREEN+", PRODUCT TYPE: "+RESET+this.productsType
                +ANSI_GREEN+", PRODUCER : "+RESET+this.producers;
    }

}
