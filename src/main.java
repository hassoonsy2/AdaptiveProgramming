import java.util.ArrayList;
import java.util.List;

public class main {



    public static void main(String[] args) {

        Customer customer1;

        Admin admin1;

        Peyment payement;

        Shoppingcart shoppingcart1;

        Guest guest;

        Product  product1 ;

        Product  product2;

        Product  product3;

        Product  product4;

        product1 = new Product("Headphone",11.50,1122);
        product2 = new Product("Iphone oplader", 8.20,3525);
        product3 = new Product("Iphone case", 2.00,5789);
        product4 = new Product("pen", 1.00, 1987);

        shoppingcart1 = new Shoppingcart();
        shoppingcart1.addtocart(product2);
        shoppingcart1.addtocart(product3);

        System.out.println("Total price : "+ shoppingcart1.gettotaalprice(shoppingcart1.getproduct()));





        customer1 = new Customer("Hussin",11);

        admin1 = new Admin("Mark", 8, product1);


        admin1.addProducts(product1);
        System.out.println(admin1.toString());


        customer1.makepeyment(50.30, shoppingcart1.getproduct(), "IDeal");
        System.out.println(customer1.toString());














    }


}