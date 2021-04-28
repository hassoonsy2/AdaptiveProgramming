import java.util.ArrayList;

public class Customer {
    private int id;
    private String naam;
    private Shoppingcart shoppingcart;
    private Product product;
    private Peyment peyment;
    private ArrayList<Product>  new_ietemstobuy = new ArrayList<Product>();

    public Customer(String name, int id)
    {
        name = name;
        id = id;
    }

    public Customer() {

    }



    public void makepeyment(double price_input , ArrayList<Product> new_ietemstobuy1, String payment_type ) {


        peyment.setPaymenttype(payment_type);
        if (price_input == shoppingcart.gettotaalprice(new_ietemstobuy1)){
            peyment.setpaymentstatus(true);
        }
        else {
            peyment.setpaymentstatus(false);
        }


    }

    public void setnaam(String nm) {
        nm = naam;

    }

    public void setid(int id1) {
        id1 = id;

    }

    public int getid() {
        return id;
    }

    public String getnaam() {
        return this.naam;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", naam='" + naam + '\'' +
                ", shoppingcart=" + shoppingcart +
                ", product=" + product +
                ", recent ietems=" + new_ietemstobuy +
                '}';
    }
}