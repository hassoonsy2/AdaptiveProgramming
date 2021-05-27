public abstract class Stap {
    private int begin_id;
    private int einde_id;

    public Stap(int begin_id, int einde_id) {
        this.begin_id = begin_id;
        this.einde_id = einde_id;
    }

    public abstract double get_prijs();

    public abstract String get_eenheid();

    public int get_begin_id() {
        return begin_id;
    }

    public int get_eind_id() {
        return einde_id;
    }

    public Stap reversed_clone() {
        Stap clone = clone();
        int temp = clone.begin_id;
        clone.begin_id = clone.einde_id;
        clone.einde_id = temp;
        return clone;
    }

    public abstract Stap clone();
}