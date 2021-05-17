import java.util.Random;
import java.util.ArrayList;


public class Machine {
    public ArrayList<Node> run(Node begin_node , ArrayList<String> richting ){
        Node f_node = begin_node;
        ArrayList<Node> resultaat = new ArrayList<>();
        resultaat.add(f_node);


       while (! f_node.is_laste_node()){
           String volgende_pad;

           if (richting.get(0).equals("stop")){
               break;
           }
           if (!(richting.get(0).equals("rondom vanaf nu") | richting.get(0).equals("random"))){
               volgende_pad = richting.get(0);
               richting.remove(0);
           }
           else {
               volgende_pad = f_node.pad_locatie(willekeurige_niet_uniforme_verdeling(f_node.get_kans_verdeling()));
               if (richting.get(0).equals("random")){
                   richting.remove(0);
               }
           }
           f_node = f_node.get_node_via_pad(volgende_pad);
           resultaat.add(f_node);
       }
       return resultaat;
    }
    public int willekeurige_niet_uniforme_verdeling(ArrayList<Double> kansen){
        double sum = 0; for(Double d : kansen){
            sum+=d;
        }
        if (sum > 1.0){
            throw new java.lang.Error("De kans is opgeteld meer dan 1,0");
        }
        double kans_over = 1.0;
        Random rand = new Random();
        for(int j=0; j<kansen.size(); j++){
            if(rand.nextDouble() < kansen.get(j)/kans_over){
                return j;
            }
            else {
                kans_over -= kansen.get(j);
            }
        }
        return kansen.size()-1;

    }
}
