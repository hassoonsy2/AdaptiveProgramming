public class Admin {
    private int id;
    private String name;
    private Product product;


    public Admin(String name, int id, Product product)
    {
        this.name = name;
        this.id = id;
        this.product = product;

    }

    public void addProducts(Product product) {

        int id3 = product.getId();
        Double price4 = product.getPrice();
         String name4 = product.getName();



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
        return "Admin  :" +
                "ID :" + id + "\n"+
                "Name : "   + name + '\n' +
                "Added Products : " + product + "\n"
                ;
    }
}
