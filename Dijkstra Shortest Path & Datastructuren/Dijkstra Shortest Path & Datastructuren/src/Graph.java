import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph implements KeyListener, MouseListener {
    JFrame frame;
    P paint;
    Set<Character> sleutelhouder = new HashSet<>();
    Verbindingen connections_map;

    public void graph(int breedte, int hoogte) {
        frame = new JFrame();
        paint = new P();
        frame.add(paint);
        frame.setSize(breedte, hoogte);
        frame.setTitle("Dijkstra");
        frame.addKeyListener(this);
        frame.addMouseListener(this);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setMap(Verbindingen connections_map) {
        this.connections_map = connections_map;
        paint.set_map(connections_map);
    }

    public void run() {
        frame.setVisible(true);
        boolean running = true;
        while(running) {
            if(sleutelhouder.contains('r')) {
                paint.stap_type = Rit.class;
            } else if(sleutelhouder.contains('v')) {
                paint.stap_type = Vlucht.class;
            } else if(sleutelhouder.contains('t')) {
                paint.stap_type = Treinrit.class;
            } else if(sleutelhouder.contains('q')) {
                running = false;
            }

            paint.repaint();
            try {
                Thread.sleep(1000/20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        frame.dispose();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for(Node node : connections_map.get_all_nodes()) {
            if(node.mouse_on(e.getX(), e.getY())) {
                int button = e.getButton();
                if(button == 1) {
                    paint.begin_id = node.get_id();
                } else if(button == 3) {
                    paint.eind_id = node.get_id();
                }
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
class P extends JPanel {
    private Verbindingen map;
    public int begin_id = 1;
    public int eind_id = 5;
    public Class<?> stap_type = Rit.class;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);


        try {
            Reis reis = map.Dijkstra(begin_id, eind_id, stap_type);
            for(Stap stap : reis.get_stapen()) {
                stap.ghrap(g, map, Color.BLUE, 15);
            }
            g.setColor(Color.BLACK);
            g.drawString("Totaal: " + reis.total_kosten() +" "+ reis.get_eenheid(), 4, 39);
        } catch (Exception e) {
            g.drawString("Geen route mogelijk tussen node " + begin_id + " en " + eind_id, 4, 39);
            g.drawString("Gebruik R, V en T om het reistype te wijzigen.", 4, 26);


        }


        List<Stap> stapen_done = new ArrayList<>();
        for(Node node : map.get_all_nodes()) {
            for(Stap stap : node.alle_verbindigen_in()) {
                if(!stapen_done.contains(stap)) {
                    stap.paint_normal(g, map);
                    stapen_done.add(stap);
                }
            }
        }

        for(Node node: map.get_all_nodes()) {
            if(node.get_id() == begin_id) {
                node.setG(g, Color.RED);
            } else if(node.get_id() == eind_id) {
                node.setG(g, Color.BLUE);
            } else {
                node.g_default(g);
            }
        }
    }

    public void set_map(Verbindingen map) {
        this.map = map;
    }
}
