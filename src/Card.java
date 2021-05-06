public abstract class Card implements Paymentmethode {

    private final String nameoncard;
    private final String cardnumber;


    public Card(String nameoncard, String cardnumber) {
        this.nameoncard = nameoncard;
        this.cardnumber = cardnumber;

    }

    @Override
    public String toString() {
        return "Card : " +getType()+'\n'+
                "name on card='" + nameoncard + '\n' +
                ", card number='" + cardnumber + '\n'
                ;
    }

    @Override
    public String pay(double euros) {

        return "Payed " + euros + " euros using " + toString() ;
    }

    protected abstract String getType();

}
