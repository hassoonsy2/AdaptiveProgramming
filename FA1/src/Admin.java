public class Admin {
    private int id;
    private String name;
    private Product product;

    public void addProducts(String productname , int product_id , Double product_price ) {
        product.setid(product_id);
        product.setproductprice(product_price);
        product.setproductname(productname);

        System.out.println("There is a new product  : " + product + "\n");

    }



    public int getid() { return id;}

    public String getnaam() { return name; }

    public void setnaam(String nm) {
        nm = name;

    }

    public void setid(int id1) {
        id1 = id;

    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ",added product=" + product +
                '}';
    }
}
