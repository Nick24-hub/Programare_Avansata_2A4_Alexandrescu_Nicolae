public class Main {
    public static void main(String[] args) {
        Source s1 = new Source();
        s1.setName("S1");
        s1.setType(SourceType.FACTORY);
        System.out.println(s1);
        Source s2 = new Source("sursa2", SourceType.WAREHOUSE);
        System.out.println(s2);
        Source s3 = new Source("sursa3", SourceType.WAREHOUSE);
        System.out.println(s3);
        Destination d1 = new Destination("destinatia1");
        System.out.println(d1);
        Destination d2 = new Destination("destinatia2");
        System.out.println(d2);
        Destination d3 = new Destination("destinatia3");
        System.out.println(d3);

        Problem pb = new Problem();
        Source[] surse = new Source[3];
        surse[0] = s1;
        surse[1] = s2;
        surse[2] = s3;
        pb.setSources(surse);
        Destination[] destinatii = new Destination[3];
        destinatii[0] = d1;
        destinatii[1] = d2;
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
    }
}
