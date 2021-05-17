public class Guest {

    private Product product;

    public void viewproducts(Product product) {
       System.out.println("Guest saw that product :" + product.toString()+'\n');
    }


}
