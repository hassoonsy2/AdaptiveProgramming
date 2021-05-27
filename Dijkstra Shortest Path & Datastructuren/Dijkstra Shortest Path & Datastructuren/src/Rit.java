import java.awt.*;

public class Rit extends Stap {
    private final double afstand;

    public Rit(int begin_id, int eind_id, double afstand) {
        super(begin_id, eind_id);
        this.afstand = afstand;
    }

    @Override
    public double get_prijs() {
        return afstand;
    }

    @Override
    public String get_eenheid() {
        return "km";
    }

    @Override
    public Stap clone() {
        return new Rit(get_begin_id(), get_eind_id(), get_prijs());
    }

    @Override
    public Color get_color() {
        return Color.RED;
    }

    @Override
    public int ghrap_offset() {
        return -2;
    }
}
