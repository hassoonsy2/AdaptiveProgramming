import java.util.*;

public class Verbindingen {
    private final HashMap<Integer, Node> nodes = new HashMap<>();

    public void add_node(Node node) {
        nodes.put(node.get_id(), node);
    }

    public Node get_node(int id) {
        return nodes.get(id);
    }

    public void setconnection(Stap connection) {
        nodes.get(connection.get_begin_id()).setConnection(connection);
        nodes.get(connection.get_eind_id()).setConnection(connection);
    }

    public void add_connection_beide_kanten(Stap connctie) {
        Stap reversed = connctie.reversed_clone();
        setconnection(connctie);
        setconnection(reversed);
    }

    public <T> Reis Dijkstra(int begin_id, int end_id, Class<T> step_type) {
        PriorityQueue<Node> Prioriteits_rij = new PriorityQueue<>();
        List<Integer> done_ids = new ArrayList<>();
        Node begin_node = get_node(begin_id);
        begin_node.prijs = 0;
        begin_node.vorige_stap = null;
        Prioriteits_rij.add(begin_node);

        while(true) {
            Node polled = Prioriteits_rij.poll();

            if(polled == null) {
                throw new IllegalArgumentException("Geen traject mogelijk.");
            } else if(polled.get_id() == end_id) {
                return route_door_backtracking_node(polled);
            } else {
                done_ids.add(polled.get_id());
                uitbreiden(polled, Prioriteits_rij, step_type, done_ids);
            }
        }
    }

    private <T> void uitbreiden(Node geselecteerd, PriorityQueue<Node> Prioriteits_rij, Class<T> stap_type, List<Integer> ids_done) {
        for(Stap stap : geselecteerd.get_stappen_van_type(stap_type)) {
            Node new_node = get_node(stap.get_eind_id());
            double new_cost = geselecteerd.prijs + stap.get_prijs();
            if((Prioriteits_rij.contains(new_node) && new_node.prijs < new_cost) | ids_done.contains(new_node.get_id())) {
                continue;
            }
            new_node.prijs = new_cost;
            new_node.vorige_stap = stap;
            if(!Prioriteits_rij.contains(new_node)) {
                Prioriteits_rij.add(new_node);
            }
        }
    }

    private Reis route_door_backtracking_node(Node node) {
        Reis reis = new Reis();
        while(true) {
            Stap previous_stap = node.vorige_stap;
            if(previous_stap == null) {
                break;
            }
            reis.add_step_front(previous_stap);
            node = get_node(previous_stap.get_begin_id());
        }
        return reis;
    }

    public List<Node> get_all_nodes() {
        return new ArrayList<>(nodes.values());
    }
}
