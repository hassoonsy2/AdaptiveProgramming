import java.util.ArrayList;

public class Customer {
    private int id;
    private String naam;
    private Shoppingcart shoppingcart;
    private Product product;
    private Paymentmethode peyment;
    private ArrayList<Product>  new_ietemstobuy = new ArrayList<Product>();
    private String Cardname;
    private String Cardnumber;
    private String Paymenttype;

    public Customer(String name, int id ,Shoppingcart shoppingcart, String Cardname1, String Cardnumber,String Paymenttype)
    {

        this.naam = name;
        this.id = id;

        this.shoppingcart = shoppingcart;
        this.Cardname = Cardname1;
        this.Cardnumber = Cardnumber;
        this.Paymenttype = Paymenttype;

    }



    public Customer() {

    }



    public static Paymentmethode makepayment(String cardname,String cardnumber ,String payment_type ) {
        switch (payment_type) {
            case "credit":

                return new Creditcard(cardname ,cardnumber );
            case "ideal":
                return new Ideal(cardname ,cardnumber); }



        throw new IllegalArgumentException();











    }

    public String order(Paymentmethode method) {
        return method.pay(shoppingcart.gettotaalprice(shoppingcart.getproduct()));


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
                "iD : " + id + "\n"+
                ", Name : " + naam + '\n' +
                 shoppingcart.toString()+
                "Order ; "+order(makepayment(Cardname,Cardnumber,Paymenttype))
                ;
    }
}