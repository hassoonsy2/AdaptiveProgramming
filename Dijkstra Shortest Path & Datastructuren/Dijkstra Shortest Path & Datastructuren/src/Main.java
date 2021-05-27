import org.junit.jupiter.api.BeforeEach;



public class Main {
    public static void main(String[] args) {
        Test tester = new Test();
        tester.setup();
        tester.test_vlucht();
        tester.test_rit();


        Graph g = new Graph();
        g.graph(800, 600);
        g.setMap(tester.map);
        g.run();
    }
}


class Test {
    Verbindingen map;

    @BeforeEach
    public void setup() {
        map = new Verbindingen();
        map.add_node(new Node(0, 569, 420));
        map.add_node(new Node(1, 80, 400));
        map.add_node(new Node(2, 290, 450));
        map.add_node(new Node(3, 270, 200));
        map.add_node(new Node(4, 580, 180));
        map.add_node(new Node(5, 370, 60));
        map.add_node(new Node(6, 110, 100));

        map.add_connection_beide_kanten(new Vlucht(0, 1, 10.0));
        map.add_connection_beide_kanten(new Vlucht(1, 3, 10.0));
        map.add_connection_beide_kanten(new Vlucht(0, 2, 5.0));
        map.add_connection_beide_kanten(new Vlucht(2, 3, 20.0));
        map.add_connection_beide_kanten(new Vlucht(0, 3, 21.0));


        map.add_connection_beide_kanten(new Rit(1, 2, 7.0));
        map.add_connection_beide_kanten(new Rit(1, 3, 9.0));
        map.add_connection_beide_kanten(new Rit(1, 6, 14.0));
        map.add_connection_beide_kanten(new Rit(2, 3, 10.0));
        map.add_connection_beide_kanten(new Rit(2, 4, 15.0));
        map.add_connection_beide_kanten(new Rit(3, 4, 11.0));
        map.add_connection_beide_kanten(new Rit(3, 6, 2.0));
        map.add_connection_beide_kanten(new Rit(4, 5, 6.0));
        map.add_connection_beide_kanten(new Rit(6, 5, 9.0));


        map.add_connection_beide_kanten(new Treinrit(4, 1, 10.0));
        map.add_connection_beide_kanten(new Treinrit(6, 3, 10.0));
        map.add_connection_beide_kanten(new Treinrit(5, 0, 10.0));
        map.add_connection_beide_kanten(new Treinrit(1, 4, 10.0));
        map.add_connection_beide_kanten(new Treinrit(4, 6, 10.0));
    }


    public void test_vlucht() {
        String expected = "0 -> 1\t| Kost: 10\n" + "1 -> 3\t| Kost: 20\n";
        Reis reis = map.Dijkstra(0, 3, Vlucht.class);
        String result = reis.toString();
        assertEquals(expected, result);
    }

    private void assertEquals(String expected, String result) {
    }


    public void test_rit() {
        String expected = "1 -> 3\t| Kost: 9\n" + "3 -> 6\t| Kost: 11\n" + "6 -> 5\t| Kost: 20\n";
        Reis reis = map.Dijkstra(1, 5, Rit.class);
        String result = reis.toString();
        assertEquals(expected, result);
    }
}