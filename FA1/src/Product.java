public class Product {
    private int id;
    private double price;
    private String name;

    public void setproductname(String nm){
        nm = name;

    }
    public void setproductprice(double p){
        p = price;

    }

    public void setid(int id){
        id = id;

    }

    public int getId(){
        return id;
    }

    public double getPrice(){
        return price;
    }


    @Override
    public String toString() {
        return "product{" +
                "id=" + id +
                ", prijs=" + price +
                ", naam=" + name +
                '}';
    }
}
