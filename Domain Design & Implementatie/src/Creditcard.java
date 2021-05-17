public class Creditcard extends Card {

    public Creditcard(String nameoncard, String cardnumber) {
        super(nameoncard, cardnumber);
    }

    @Override
    protected String getType() {
        return "creditcard";
    }




}
