import java.util.ArrayList;

public class Shoppingcart {
    private ArrayList<Product>  product_list = new ArrayList<Product>();

    private ArrayList<Double> prices = new ArrayList<Double>();


    private double totaalprice;
    private Product product;





    public ArrayList<Product> getproduct() { return product_list;

    }


    public void deletfromcart(Product product1 , ArrayList<Product> product_list1) {
        product1 = product;
        product_list1 = product_list;
        product_list1.remove(product1);
    }

    public void addtocart(Product product1) {

        product_list.add(product1);
    }

    public double gettotaalprice(ArrayList<Product> product_list1){
        ArrayList<Double> prices1 = prices;
        for (Product i : product_list1){
            if(i != null){
                double singel_price = i.getPrice();
                prices1.add(singel_price);

            }


        }
        return prices1.stream().mapToDouble(f -> f.doubleValue()).sum();



    }
    public double getTotaalprice(){
        return totaalprice;
    }

    @Override
    public String toString() {
        return "Shoppingcart : " +
                "product_list=" + product_list +'\n'
                ;
    }


}