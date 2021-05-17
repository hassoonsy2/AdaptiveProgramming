import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Node {
    private final String naam;
    private final Map<String, Node> connctie = new HashMap<>();
    private final ArrayList<Double> kansen = new ArrayList<>();

    public Node(String naam){
        this.naam = naam;
    }

    public String getNaam() {
        return naam;
    }

    public void set_connctie(String padnaam, Node node, double kans){
        this.connctie.put(padnaam, node);
        this.kansen.add(kans);
    }

    public ArrayList<Double> get_kans_verdeling(){
        return kansen;
    }

    public String pad_locatie(int locatie){
        ArrayList<String> as_list = new ArrayList<>(connctie.keySet());
        if(locatie < as_list.size()){
            return as_list.get(locatie);
        } else {
            throw new IllegalArgumentException("dit node heeft geen " + (locatie+1) + " pad.");
        }
    }



    public Node get_node_via_pad(String padnaam){
        if(connctie.containsKey(padnaam)){
            return connctie.get(padnaam);
        }else {
            throw new IllegalArgumentException(padnaam + " is pad van node " + naam);
        }
    }


    public boolean is_laste_node(){
        return connctie.size() == 0;
    }

    @Override
    public String toString(){
        return getNaam();
    }



}
//Soures : https://www.javatpoint.com/java-map
//https://examples.javacodegeeks.com/java-node-example/
