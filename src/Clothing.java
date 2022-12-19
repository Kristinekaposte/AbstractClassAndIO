public class Clothing extends Items{
    private String productName;
    private Double price;
    private ProductsType productsType;
    private Producers producers;


    public Clothing (String productName,Double price, ProductsType productsType){
        super(productName,price,productsType);
    }
    @Override
    public String getProductName() {
        return super.productName;
    }

    @Override
    public Double getPrice() {
        return super.price;
    }
    @Override
    public ProductsType getProductsType() {
        return super.productsType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // check for self
        if (o == null || getClass() != o.getClass())
            return false;   // if object is null or if they dont have same class return false
        Clothing clothing = ( Clothing) o;

        return (super.productName.toLowerCase().equals(clothing.getProductName().toLowerCase())&&
                super.price.equals(clothing.getPrice()) &&
                super.productsType == clothing.getProductsType() &&
                super.producers.equals(clothing.getProducers()));
    }

    @Override
    public int hashCode () {               //  we should get nr. back
        int result = 31 * super.productName.toLowerCase().hashCode()
                +super.price.hashCode()
                +super.productsType.hashCode()
                +super.producers.hashCode()
                ;
        return result;
    }
}
