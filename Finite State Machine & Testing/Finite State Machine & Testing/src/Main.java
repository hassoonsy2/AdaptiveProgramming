public class Main {
    public static void main(String[] args){
        Machine machine = new Machine();
        TestUnit TestUnit = new TestUnit();
        TestUnit.diamant_structuur(machine);
        TestUnit.zeszijdige_dobbelsteen_structuur(machine);

    }
}
class Test_Unit {

    @Test
    static void zeszijdige_dobbelsteen_structuur(Machine machine) {
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
        s0.set_connctie("A", s1, 0.5D);
        s0.set_connctie("B", s2, 0.5D);
        s1.set_connctie("A", s3, 0.5D);
        s1.set_connctie("B", s4, 0.5D);
        s2.set_connctie("A", s5, 0.5D);
        s2.set_connctie("B", s6, 0.5D);
        s3.set_connctie("A", s1, 0.5D);
        s3.set_connctie("B", dobbelsteen1, 0.5D);
        s4.set_connctie("A", dobbelsteen2, 0.5D);
        s4.set_connctie("B", dobbelsteen3, 0.5D);
        s5.set_connctie("A", dobbelsteen4, 0.5D);
        s5.set_connctie("B", dobbelsteen5, 0.5D);
        s6.set_connctie("A", dobbelsteen6, 0.5D);
        s6.set_connctie("B", s2, 0.5D);
        ArrayList<Node> output = machine.run(s0, new ArrayList<String>() {
            {
                this.add("rondom vanaf nu");
            }
        });
        PrintStream var10000 = System.out;
        Object var10001 = output.get(output.size() - 1);
        var10000.println("Zes zijdige dobbelstenen roll: " + var10001);
        output = machine.run(s0, new ArrayList<String>() {
            {
                this.add("A");
                this.add("rondom vanaf nu");
            }
        });
        var10000 = System.out;
        var10001 = output.get(output.size() - 1);
        var10000.println("Zes zijdige dobbelstenen rollen (alleen 1, 2 of 3 mogelijk): " + var10001);
        System.out.println("Tests met zeszijdige dobbelsteenstructuren voltooid\n");
    }

    static void achtzijdige_blokjesstructuur(Machine machine) {
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
        Node dobbelsteen7 = new Node("7");
        Node dobbelsteen8 = new Node("8");
        s0.set_connctie("A", s1, 0.5D);
        s0.set_connctie("B", s2, 0.5D);
        s1.set_connctie("A", s3, 0.5D);
        s1.set_connctie("B", s4, 0.5D);
        s2.set_connctie("A", s5, 0.5D);
        s2.set_connctie("B", s6, 0.5D);
        s3.set_connctie("A", dobbelsteen1, 0.5D);
        s3.set_connctie("B", dobbelsteen2, 0.5D);
        s4.set_connctie("A", dobbelsteen3, 0.5D);
        s4.set_connctie("B", dobbelsteen4, 0.5D);
        s5.set_connctie("A", dobbelsteen5, 0.5D);
        s5.set_connctie("B", dobbelsteen6, 0.5D);
        s6.set_connctie("A", dobbelsteen7, 0.5D);
        s6.set_connctie("B", dobbelsteen8, 0.5D);
        ArrayList<Node> output = machine.run(s0, new ArrayList<String>() {
            {
                this.add("rondom vanaf nu");
            }
        });
        PrintStream var10000 = System.out;
        Object var10001 = output.get(output.size() - 1);
        var10000.println("Acht zijdige dobbelstenen rollen:: " + var10001);
        output = machine.run(s0, new ArrayList<String>() {
            {
                this.add("A");
                this.add("rondom vanaf nu");
            }
        });
        var10000 = System.out;
        var10001 = output.get(output.size() - 1);
        var10000.println("Acht zijdige dobbelstenen rollen (allen 1, 2, 3 of 4 mogelijk): " + var10001);
        System.out.println("testeb met achtzijdige_blokjesstructuur voltooid \n");
    }

    @Test
    static void tekst_correct_basis(Machine machine, final Node s0, final Node s1, final Node s2, Node s3) {
        try {
            ArrayList<Node> resultaat = machine.run(s0, new ArrayList<String>() {
                {
                    this.add("B");
                    this.add("A");
                    this.add("A");
                    this.add("B");
                    this.add("stop");
                }
            });
            ArrayList<Node> verwacht = new ArrayList<Node>() {
                {
                    this.add(s0);
                    this.add(s1);
                    this.add(s1);
                    this.add(s1);
                    this.add(s2);
                }
            };
            Assertions.assertEquals(verwacht, resultaat);
            System.out.println("tekst_correct_basis is voltooid , resultaat: " + resultaat);
        } catch (Exception var7) {
            System.out.println("Error in tekst_correct_basis: " + var7);
        }

    }

    @Test
    static void tekst_fout(Machine machine, final Node s0, final Node s1, final Node s2, Node s3) {
        try {
            ArrayList<Node> resultaat = machine.run(s0, new ArrayList<String>() {
                {
                    this.add("B");
                    this.add("A");
                    this.add("B");
                    this.add("A");
                    this.add("stop");
                }
            });
            ArrayList<Node> verwacht = new ArrayList<Node>() {
                {
                    this.add(s0);
                    this.add(s1);
                    this.add(s1);
                    this.add(s1);
                    this.add(s2);
                }
            };
            Assertions.assertEquals(verwacht, resultaat);
            System.out.println("tekst_fout is voltooid , resultaat: " + resultaat);
        } catch (Exception var7) {
            System.out.println("Error in tekst_fout: " + var7);
        }

    }

    @Test
    static void text_correct_lang(Machine machine, final Node s0, final Node s1, final Node s2, final Node s3) {
        try {
            ArrayList<Node> resultaat = machine.run(s2, new ArrayList<String>() {
                {
                    this.add("B");
                    this.add("A");
                    this.add("B");
                    this.add("A");
                    this.add("B");
                    this.add("B");
                    this.add("B");
                    this.add("A");
                    this.add("B");
                    this.add("stop");
                }
            });
            ArrayList<Node> verwacht = new ArrayList<Node>() {
                {
                    this.add(s2);
                    this.add(s3);
                    this.add(s3);
                    this.add(s0);
                    this.add(s2);
                    this.add(s3);
                    this.add(s0);
                    this.add(s1);
                    this.add(s1);
                    this.add(s2);
                }
            };
            Assertions.assertEquals(verwacht, resultaat);
            System.out.println(" tekst_correct_lang is voltooid, resultaat: " + resultaat);
        } catch (Exception var7) {
            System.out.println("Error in tekst_correct_long: " + var7);
        }

    }

    @Test
    static void diamant_structuur(Machine machine) {
        Node s0 = new Node("s0");
        Node s1 = new Node("s1");
        Node s2 = new Node("s2");
        Node s3 = new Node("s3");
        s0.set_connctie("A", s2, 0.5D);
        s0.set_connctie("B", s1, 0.5D);
        s1.set_connctie("A", s1, 0.5D);
        s1.set_connctie("B", s2, 0.5D);
        s2.set_connctie("B", s3, 1.0D);
        s3.set_connctie("A", s3, 0.5D);
        s3.set_connctie("B", s0, 0.5D);
        tekst_correct_basis(machine, s0, s1, s2, s3);
        tekst_fout(machine, s0, s1, s2, s3);
        text_correct_lang(machine, s0, s1, s2, s3);
        System.out.println("Voltooid diamant structuur testen\n");
    }
}

