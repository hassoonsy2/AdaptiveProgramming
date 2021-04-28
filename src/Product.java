public class Product {
    private int id;
    private double price;
    private String name;

    public Product(String name, double price, int id)
    {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public void setproductname(String nm){
        nm = name;

    }
    public void setproductprice(double p){
        p = price;

    }

    public void setid(int id1){
        id1 = id;

    }

    public int getId(){
        return id;
    }

    public double getPrice(){
        return price;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", Price=" + price +
                ", Name=" + name +
                '}';
    }
}
