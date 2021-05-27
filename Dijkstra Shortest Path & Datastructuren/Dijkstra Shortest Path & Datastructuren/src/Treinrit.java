

public class Treinrit extends Stap {
    private final double tijd;

    public Treinrit(int begin_id, int einde_id, double tijd) {
        super(begin_id, einde_id);
        this.tijd = tijd;
    }

    @Override
    public double get_prijs() {
        return tijd;
    }

    @Override
    public String get_eenheid() {
        return "Min";
    }

    @Override
    public Stap clone() {
        return new Treinrit(get_begin_id(), get_eind_id(), get_prijs());
    }


}