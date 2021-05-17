public class main {



    public static void main(String[] args) {



        Product product1 = new Product("Headphone",11.50,1122);
        Product product2 = new Product("Iphone oplader", 8.20,3525);
        Product product3 = new Product("Iphone case", 2.00,5789);
        Product product4 = new Product("pen", 1.00, 1987);

        Shoppingcart shoppingcart1 = new Shoppingcart();
        shoppingcart1.addtocart(product2);
        shoppingcart1.addtocart(product3);

        Guest guest =new Guest();
        guest.viewproducts(product4);




        Customer customer1 = new Customer("Hussin",11,shoppingcart1,"Hussin Almoustafa","NL 99 INGB 99999999 ","ideal");

        Admin admin1 = new Admin("Mark", 8, product1);



        admin1.addProducts(product1);
        System.out.println(admin1.toString());


        System.out.println(customer1.toString());
















    }


}