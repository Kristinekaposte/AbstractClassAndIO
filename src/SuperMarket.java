import java.io.*;
import java.util.*;

public class SuperMarket {
    public static Map<Category, List<Items>> map = new HashMap<>();
    public static List<Items> listOfAllItems=new ArrayList<>();

    public static void main(String[] args) throws IOException {
//********************************PRODUCERS OBJECTS*************************************************************/
        Producers producer1 = new Producers("AAC");
        Producers producer2 = new Producers("BBB");
        Producers producer3 = new Producers("AAD");
        Producers.allProducers.add(producer1);
        Producers.allProducers.add(producer2);
        Producers.allProducers.add(producer3);
        //  System.out.println("are these objects EQUAL ? "+producer1.equals(producer2));
        //  System.out.println(producer1.hashCode() == producer2.hashCode());

        //System.out.println( Producers.allProducers.toString());

//********************************CUSTOMERS OBJECTS*****************************************************************/
//        Customers customer1 = new Customers("John", 100);
//        Customers customer2 = new Customers("Jo", 200);
//        Customers.allCustomers.add(customer1);
//        Customers.allCustomers.add(customer2);
        //System.out.println(  Customers.allCustomers.toString());

//********************************CLOTHING OBJECTS*****************************************************************/
        Clothing wClothing1 = new Clothing("Sneakers", 6.99, ProductsType.SHOES);
        Clothing wClothing2 = new Clothing("AShoe", 1.99, ProductsType.SHOES);
        Clothing wClothing3 = new Clothing("Cocktail dress", 15.99, ProductsType.DRESSES);
        wClothing1.setProducers(producer1);
        wClothing2.setProducers(producer2);
        wClothing3.setProducers(producer3);
        //  System.out.println("are these objects EQUAL ? "+ wClothing1.equals(wClothing2));
        //  System.out.println(wClothing1.hashCode() == wClothing3.hashCode());

        Items.clothingItemList.add(wClothing1);
        Items.clothingItemList.add(wClothing2);
        Items.clothingItemList.add(wClothing3);

        //   System.out.println(Items.clothingItemList);
//********************************GARDENING OBJECTS*****************************************************************/
        GardeningItems gItems1 = new GardeningItems("Light Soil", 1.99, ProductsType.SOILS);
        GardeningItems gItems2 = new GardeningItems("Medium base Soil", 2.99, ProductsType.SOILS);
        GardeningItems gItems3 = new GardeningItems("Low acid Soil", 5.99, ProductsType.SOILS);
        gItems1.setProducers(producer1);
        gItems2.setProducers(producer2);
        gItems3.setProducers(producer3);

        Items.gardeningItemList.add(gItems1);
        Items.gardeningItemList.add(gItems2);
        Items.gardeningItemList.add(gItems3);
        //System.out.println( Items.gardeningItemList);
//******************************** MAP ******************************************************************************/

        map.put(Category.WOMENS_CLOTHING, Items.clothingItemList);
        map.put(Category.GARDEN_PRODUCTS, Items.gardeningItemList);

//        for (Map.Entry<Category, List<Items>> allItemsInMap: map.entrySet()){
//            System.out.println(allItemsInMap+"\n");
//        }
//******************************** Sorting n searching by producers letters or names ***********************************/
         //  ArrayList<Items> results = Producers.searchAndSortProducers((ArrayList<Items>) Items.clothingItemList,"A");
         // System.out.println(results);
//******************************** MAP VALUES TO LIST, SORT BY PRODUCER NAME *****************************************/
        //  addAllMapItemsToList();
        //  sortAllItemsListByProducer();
//********************************Write files from customer.txt and sort to customer-sorted.txt *********************
        writeAndSortCustomersTxt();

//***********************************customer-sorted write into object***************************************************
        //read file
        Customers[] customers = readFile("src/files/sorted-customers.txt");
          printCustomers(customers);
    }



    public static void printCustomers(Customers[] customers){
        //loop thought array
            for (Customers c : customers){
                //print each name if they are not null
                if( c != null)
                    System.out.println(c);
            }
        }
    public static Customers[] readFile(String fileName)throws FileNotFoundException {
        Customers[] customersList = new Customers[25]; // accepts 25 inputs from txt
        int count=0;
   //open file
       File fileNames = new File(fileName);
       if (fileNames.canRead()){
    //get scanner on file
           Scanner scFileNames = new Scanner(fileNames);
     //sentinel loop on hasNext
     //
     while(scFileNames.hasNext()){
         //red name
             String customerName = scFileNames.next();
         //read price
            double balance = scFileNames.nextDouble();
        //Build the name and put into Array
         customersList[count] = new Customers(customerName,balance);
         count++;
     }
   }
      return  customersList;
    }

//*********************************************************************************************
public static void writeAndSortCustomersTxt(){
    BufferedReader in = null;
    BufferedWriter out = null;
    try {
        in = new BufferedReader(new FileReader("src/files/customers.txt"));
        out = new BufferedWriter(new FileWriter("src/files/sorted-customers.txt"));

        ArrayList<String> myCustomerArrayList = new ArrayList<>();

        String currentLine = in.readLine();
        while (currentLine != null) {
            myCustomerArrayList .add(currentLine);
            currentLine = in.readLine();
        }
        Collections.sort(myCustomerArrayList );
        for (String line : myCustomerArrayList ) {
            out.write(line);
            out.newLine();
            //  System.out.println(line);
        }
        in.close();
        out.close();

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

    public static void addAllMapItemsToList(){
        for(Map.Entry<Category,List<Items>> entry: map.entrySet()){
            List<Items> value=entry.getValue();
            for (Items itemm : value)
                listOfAllItems.add(itemm);

        }
      //  System.out.println(listOfAllItems);
    }
    public static void sortAllItemsListByProducer(){

           Collections.sort(listOfAllItems, new SortByProducersComparator());
                System.out.println(listOfAllItems.toString());
        }




}
















//****************************RETURNS SORTED USERS BY SEARCHING NAME OR LETTER**********************************
//    ArrayList<Producers> results = searchAndSortProducers((ArrayList<Producers>) Producers.allProducers,"AB");
//        System.out.println(results); // Output: [Alex, Amanda]
//                }
//
//public static ArrayList<Producers> searchAndSortProducers(ArrayList<Producers> producers, String searchTerm) {
//        ArrayList<Producers> matchingProducers = new ArrayList<>();
//
//        // Loop over the producers and if there is a match, add it to the new list
//        for (Producers producer : producers) {
//        if (producer.getName().contains(searchTerm)) {
//        matchingProducers.add(producer);
//        }
//        }
//
//        // sort the new list
//        matchingProducers.sort(new SortByProducersComparator());
//
//        // return matchingProducers
//        return matchingProducers;
//
//
//
//        }
//****************************RETURNS SORTED USERS**********************************************
//Collections.sort(Items.clothingItemList, new SortByProducersComparator());
   //      System.out.println(Items.clothingItemList.toString());
//*************************************RANDOOM CODES*********************************************

//        private static void printCataloge(){
//            for (Map.Entry<Category, List<Items>> allItemsInMap: map.entrySet()){
//              //  System.out.println(allItemsInMap+"\n");
//                String key = entry.getKey();
//                List<Items> itemsList = entry.getValue();
//                System.out.println(key+"===>");
//                    for(Items item: itemsList){
//                        System.out.println(item.toString()+"|");
//                    }
//            }

//            for (Category key: map.keySet()){
//                for(Items itemsList: map.get(key)){
//





// add collection of producers  ( name, totalRevenue )
// add collection of customers.txt ( name, balance, email, phone )



// getItemByProducer("n")

// [list of all items]
    /*
        Comparator
        Comparable
     */
// [list of all items sorted by producer string provided]
