

public class Vlucht extends Stap {
    private final double prijs;

    public Vlucht(int begin_id, int eind_id, double prijs) {
        super(begin_id, eind_id);
        this.prijs = prijs;
    }

    @Override
    public double get_prijs() {
        return prijs;
    }

    @Override
    public String get_eenheid() {
        return "euros";
    }

    @Override
    public Stap clone() {
        return new Vlucht(get_begin_id(), get_eind_id(), get_prijs());
    }

}