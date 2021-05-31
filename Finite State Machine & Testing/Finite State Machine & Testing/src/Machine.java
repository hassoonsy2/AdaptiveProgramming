import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Machine {

    public ArrayList<Node> run(Node begin_node, ArrayList<String> richting) {
        Node f_node = begin_node;
        ArrayList<Node> resultaat = new ArrayList();
        resultaat.add(begin_node);

        while(!f_node.is_laste_node() && !((String)richting.get(0)).equals("stop")) {
            String volgende_pad;
            if (!(((String)richting.get(0)).equals("rondom vanaf nu") | ((String)richting.get(0)).equals("random"))) {
                volgende_pad = (String)richting.get(0);
                richting.remove(0);
            } else {
                volgende_pad = f_node.pad_locatie(this.willekeurige_niet_uniforme_verdeling(f_node.get_kans_verdeling()));
                if (((String)richting.get(0)).equals("random")) {
                    richting.remove(0);
                }
            }

            f_node = f_node.get_node_via_pad(volgende_pad);
            resultaat.add(f_node);
        }

        return resultaat;
    }

    public int willekeurige_niet_uniforme_verdeling(ArrayList<Double> kansen) {
        double sum = 0.0D;

        Double d;
        for(Iterator var4 = kansen.iterator(); var4.hasNext(); sum += d) {
            d = (Double)var4.next();
        }

        if (sum > 1.0D) {
            throw new Error("De kans is opgeteld meer dan 1,0");
        } else {
            double kans_over = 1.0D;
            Random rand = new Random();

            for(int j = 0; j < kansen.size(); ++j) {
                if (rand.nextDouble() < (Double)kansen.get(j) / kans_over) {
                    return j;
                }

                kans_over -= (Double)kansen.get(j);
            }

            return kansen.size() - 1;
        }
    }
}