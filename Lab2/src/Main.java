public class Main {
    public static void main(String[] args) {

        // Creez sursele si destinatiile

        Factory s1 = new Factory();
        s1.setName();
        System.out.println(s1);
        Warehouse s2 = new Warehouse("S2");
        System.out.println(s2);
        Warehouse s3 = new Warehouse("S3");
        System.out.println(s3);
        Destination d1 = new Destination("D1");
        System.out.println(d1);
        Destination d2 = new Destination("D2");
        System.out.println(d2);
        Destination d3 = new Destination("D3");
        System.out.println(d3);

        // Creez o instanta a problemei

        Problem pb = new Problem();
        Source[] surse = new Source[3];
        surse[0] = s1;
        surse[1] = s2;

        // Testez daca ma lasa sa introduc de 2 ori aceeasi sursa
        surse[2] = s1;
        pb.setSources(surse);

        // Afiseaza eroare pentru partea de mai sus

        // Continui sa introduc in mod corect datele din enunt

        surse[2] = s3;
        pb.setSources(surse);
        Destination[] destinatii = new Destination[3];
        destinatii[0] = d1;
        destinatii[1] = d2;

        // Testez daca ma lasa sa introduc de 2 ori aceeasi destinatie
        destinatii[2] = d2;
        pb.setDestinations(destinatii);

        // Afiseaza eroare

        // Continui sa introduc in mod corect datele din enunt
        destinatii[2] = d3;
        pb.setDestinations(destinatii);
        int[] stoc = new int[3];
        stoc[0] = 10;
        stoc[1] = 35;
        stoc[2] = 25;
        pb.setSupply(stoc);
        int[] cerere = new int[3];
        cerere[0] = 20;
        cerere[1] = 25;
        cerere[2] = 25;
        pb.setDemand(cerere);
        int[][] cost = new int[3][3];
        cost[0][0] = 2;
        cost[0][1] = 3;
        cost[0][2] = 1;
        cost[1][0] = 5;
        cost[1][1] = 4;
        cost[1][2] = 8;
        cost[2][0] = 5;
        cost[2][1] = 6;
        cost[2][2] = 8;
        pb.setCost(cost);
        System.out.println(pb);

        // aplic algoritmul si returnez solutia

        Algorithm greedy = new GreedyAlgorithm(pb);
        Solution sol = greedy.solve();
        System.out.println(sol);
        int costTotal = sol.computeCost(pb);
        System.out.println("Costul total: " + costTotal);
    }
}
