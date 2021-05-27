import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;


public class Node implements Comparable<Node> {
    private final int id;
    private final List<Stap> verbindingen_out = new ArrayList<>();
    private final List<Stap> verbindingen_in = new ArrayList<>();
    public double prijs;
    public Stap vorige_stap;

    public Node(int id){
    this.id =id;}




    public List<Stap> alle_verbindigen_in() {
        return verbindingen_in;
    }

    public List<Stap> alle_verbindigen_out() {
        return verbindingen_out;
    }

    public int get_id() {
        return id;
    }


    public void setConnection(Stap connctie) {
        if(connctie.get_eind_id() == id) {
            verbindingen_in.add(connctie);
        }
        if(connctie.get_begin_id() == id) {
            this.verbindingen_out.add(connctie);
        }
    }
    @Override
    public int compareTo(Node node) {
        return Double.compare(prijs, node.prijs);
    }

    @Override
    public String toString() {
        return "Node " + id;
    }

    @SuppressWarnings("unchecked")
    public <T> List<Stap> get_stappen_van_type(Class<T> step_type) {
        return (List<Stap>) verbindingen_out.stream()
                .filter(step_type::isInstance)
                .map(step_type::cast)
                .collect(toList());
    }
}