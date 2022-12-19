import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customers {
    public static List<Customers> allCustomers = new ArrayList<>();
    private String name;
    private double balance;
    private String email;
 //   private float phone; //234234f

    public Customers(String name,double balance){
             this.name=name;
            this.balance=balance;
           // this.email=email;
    }
    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public String getEmail() {
        return email;
    }
    @Override
    public String toString() {
        return "Name "+this.name+", Balance "+this.balance;
}
}



// add collection of customers.txt ( name, balance, email, phone )