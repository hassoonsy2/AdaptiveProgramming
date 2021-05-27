import java.awt.*;

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
    public void ghrap(Graphics g, Verbindingen map, Color kluer, int dikte) {
        Node begin_node = map.get_node(get_begin_id());
        Node end_node = map.get_node(get_eind_id());
        g.setColor(kluer);
        Graphics2D g2 = (Graphics2D) g;
        g2.setStroke(new BasicStroke(dikte));
        g2.drawLine(begin_node.x+ghrap_offset(), begin_node.y, end_node.x+ghrap_offset(), end_node.y);

    }

    public abstract Stap clone();

    public void paint_normal(Graphics g, Verbindingen map)  {
        ghrap(g, map, get_color(), 2);
        Node begin_node = map.get_node(get_begin_id());
        Node end_node = map.get_node(get_eind_id());
        int text_x = (begin_node.x + end_node.x) / 2;
        int text_y = (begin_node.y + end_node.y) / 2;
        g.drawString(""+get_prijs(), text_x, text_y-7);
    }

    public abstract Color get_color();

    public abstract int ghrap_offset();
}