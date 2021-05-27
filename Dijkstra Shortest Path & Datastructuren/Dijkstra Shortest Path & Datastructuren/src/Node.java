import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;


public class Node implements Comparable<Node> {
    private final int id;
    private final List<Stap> verbindingen_out = new ArrayList<>();
    private final List<Stap> verbindingen_in = new ArrayList<>();
    public double prijs;
    public Stap vorige_stap;
    int x;
    int y;
    int size = 35;

    public Node(int id ,int x, int y){
    this.id =id;
        this.x = x;
        this.y = y;}




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

    public boolean mouse_on(int mouse_x, int mouse_y) {
        double afstand = Point2D.distance(x, y,  mouse_x, mouse_y);
        return afstand < size;
    }

    void g_default(Graphics g) {
        setG(g, Color.WHITE);
    }

    void setG(Graphics g, Color color) {
        g.setColor(color);
        g.fillOval(x-size/2, y-size/2, size, size);
        g.setColor(Color.BLUE);
        g.drawOval(x-size/2, y-size/2, size, size);
        g.setFont(new Font("Helvetica", Font.PLAIN, 15));
        g.drawString(""+id, x-6, y+7);
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