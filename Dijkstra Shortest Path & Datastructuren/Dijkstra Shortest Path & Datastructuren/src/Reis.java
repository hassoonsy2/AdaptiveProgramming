import java.util.ArrayList;
import java.util.List;

public class Reis {
    private final List<Stap> staps = new ArrayList<>();

    public void add_step_front(Stap stap) {
        staps.add(0, stap);
    }

    @Override
    public String toString(){
        StringBuilder string_builder = new StringBuilder();
        int cost = 0;
        for(Stap stap : staps) {
            cost += stap.get_prijs();
            string_builder.append(stap.get_begin_id())
                    .append(" -> ")
                    .append(stap.get_eind_id())
                    .append("\t| kost: ")
                    .append(cost)
                    .append("\n");
        }
        return string_builder.toString();
    }

    public List<Stap> get_stapen() {
        return staps;
    }

    public double total_kosten() {
        double total_cost = 0;
        for(Stap stap : get_stapen()) {
            total_cost += stap.get_prijs();
        }
        return total_cost;
    }

    public String get_eenheid() {
        return get_stapen().get(0).get_eenheid();
    }
}
