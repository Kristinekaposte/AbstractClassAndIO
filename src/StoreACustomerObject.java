import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class StoreACustomerObject {
    public static void main(String[] args) {
        BufferedReader in=null;
        BufferedWriter out=null;


        try {

            in = new BufferedReader(new FileReader("src/files/customers.txt"));
            out = new BufferedWriter(new FileWriter("src/files/sorted-customers.txt"));

            ArrayList<String> myArrayList = new ArrayList<>();

            String currentLine = in.readLine();
            while (currentLine != null){
                myArrayList.add(currentLine);
                currentLine =in.readLine();
            }
            Collections.sort(myArrayList);
            for (String line : myArrayList) {
                out.write(line);
                out.newLine();
              //  System.out.println(line);
            }
            in.close();
            out.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }




    }
}
