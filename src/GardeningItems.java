public class GardeningItems extends Items{
    private String productName;
    private Double price;
    private ProductsType productsType;


    public   GardeningItems(String productName,Double price, ProductsType productsType){
        super(productName,price,productsType);
    }
    @Override
    public String getProductName() {
        return this.productName;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
    @Override
    public ProductsType getProductsType() {
        return productsType;
    }

}
