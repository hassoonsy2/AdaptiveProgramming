import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class TestUnit {

    @Test
    public void zeszijdige_dobbelsteen_structuur(Machine machine){
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");
        Node s4 = new Node("s4");
        Node s5 = new Node("s5");
        Node s6 = new Node("s6");
        Node dobbelsteen1 = new Node("1");
        Node dobbelsteen2 = new Node("2");
        Node dobbelsteen3 = new Node("3");
        Node dobbelsteen4 = new Node("4");
        Node dobbelsteen5 = new Node("5");
        Node dobbelsteen6 = new Node("6");

        s0.set_connctie("A", s1, 0.5);
        s0.set_connctie("B", s2, 0.5);

        s1.set_connctie("A", s3, 0.5);
        s1.set_connctie("B", s4, 0.5);

        s2.set_connctie("A", s5, 0.5);
        s2.set_connctie("B", s6, 0.5);

        s3.set_connctie("A", s1, 0.5);
        s3.set_connctie("B", dobbelsteen1, 0.5);

        s4.set_connctie("A", dobbelsteen2, 0.5);
        s4.set_connctie("B", dobbelsteen3, 0.5);

        s5.set_connctie("A", dobbelsteen4, 0.5);
        s5.set_connctie("B", dobbelsteen5, 0.5);

        s6.set_connctie("A", dobbelsteen6, 0.5);
        s6.set_connctie("B", s2, 0.5);

        ArrayList<Node> output = machine.run(s0, new ArrayList<>() {{
            add("rondom vanaf nu");
        }});
        System.out.println("Zes zijdige dobbelstenen roll: " + output.get(output.size() - 1));

        output = machine.run(s0, new ArrayList<>() {{
            add("A");
            add("rondom vanaf nu");
        }});
        System.out.println("Zes zijdige dobbelstenen rollen (alleen 1, 2 or 3 mogelijk): " + output.get(output.size() - 1));

        System.out.println("Tests met zeszijdige dobbelsteenstructuren voltooid\n");
    }


    @Test
    public void tekst_correct_basis(Machine machine, Node s0, Node s1, Node s2, Node s3){
        try{
            ArrayList<Node> resultaat = machine.run(s0, new ArrayList<>() {{
                add("B");
                add("A");
                add("A");
                add("B");
                add("stop");
            }});

            ArrayList<Node> verwacht = new ArrayList<>() {{
                add(s0);
                add(s1);
                add(s1);
                add(s1);
                add(s2);
            }};

            assertEquals(verwacht, resultaat);
            System.out.println("tekst_correct_basis is voltooid , resultaat: " + resultaat);
        } catch (Exception e){
            System.out.println("Error in tekst_correct_basis: " + e);
        }
    }

    @Test
    public void tekst_fout(Machine machine, Node s0, Node s1, Node s2, Node s3){
        try{
            ArrayList<Node> resultaat = machine.run(s0, new ArrayList<>() {{
                add("B");
                add("A");
                add("B");
                add("A");
                add("stop");
            }});

            ArrayList<Node> verwacht = new ArrayList<>() {{
                add(s0);
                add(s1);
                add(s1);
                add(s1);
                add(s2);
            }};

            assertEquals(verwacht, resultaat);
            System.out.println("tekst_fout is voltooid , resultaat: " + resultaat);
        } catch (Exception e){
            System.out.println("Error in tekst_fout: " + e);
        }
    }

    @Test
    public void text_correct_lang(Machine machine, Node s0, Node s1, Node s2, Node s3){
        try{
            ArrayList<Node> resultaat = machine.run(s2, new ArrayList<>() {{
                add("B");
                add("A");
                add("B");
                add("A");
                add("B");
                add("B");
                add("B");
                add("A");
                add("B");
                add("stop");
            }});

            ArrayList<Node> verwacht = new ArrayList<>() {{
                add(s2);
                add(s3);
                add(s3);
                add(s0);
                add(s2);
                add(s3);
                add(s0);
                add(s1);
                add(s1);
                add(s2);
            }};

            assertEquals(verwacht, resultaat);
            System.out.println(" tekst_correct_lang is voltooid, resultaat: " + resultaat);
        } catch (Exception e){
            System.out.println("Error in tekst_correct_long: " + e);
        }
    }


    @Test
    public void diamant_structuur(Machine machine){
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");

        s0.set_connctie("A", s2, 0.5);
        s0.set_connctie("B", s1, 0.5);

        s1.set_connctie("A", s1, 0.5);
        s1.set_connctie("B", s2, 0.5);

        s2.set_connctie("B", s3, 1.0);

        s3.set_connctie("A", s3, 0.5);
        s3.set_connctie("B", s0, 0.5);

        tekst_correct_basis(machine, s0, s1, s2, s3);
        tekst_fout(machine, s0, s1, s2, s3);
        text_correct_lang(machine, s0, s1, s2, s3);

        System.out.println("Voltooid diamant structuur testen\n");
    }






}
