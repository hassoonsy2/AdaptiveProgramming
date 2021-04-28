//interface
public interface Peyment {
    Customer customer = new Customer();
    boolean paymentstatus = false;
    int paymentnummber = customer.getid();
    String paymenttype = new String();

    public default boolean getpaymentstatus(){
        return paymentstatus;
    }

    public default void setpaymentstatus(boolean status){
        status = paymentstatus;


    }

    public default void setPaymenttype(String paymenttype1){
        paymenttype1 = paymenttype;
    }

    public default String getpaymenttype(){return paymenttype;}







}