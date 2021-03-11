import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        Museum m = new Museum();
        m.setOpeningTime(LocalTime.of(9, 30)); //9:30
        m.setClosingTime(LocalTime.parse("17:00"));
        m.setTicketPrice(20);
        System.out.println(m.toString());
        Church c = new Church();
        c.setOpeningTime(LocalTime.of(7, 0));
        c.setClosingTime(LocalTime.MIDNIGHT);
        System.out.println(c.toString());
        Visitable[] arr = {m, c};
        System.out.println(Arrays.toString(arr) + '\n');

        Hotel v1 = new Hotel("Hotel", 4.3);
        System.out.println(v1.getDetails());

        Museum v2 = new Museum();
        v2.setName("Museum A");
        v2.setClosingTime(LocalTime.of(16, 30));
        v2.setOpeningTime(LocalTime.of(9, 0));
        v2.setTicketPrice(15);
        System.out.println(v2.getDetails());

        Museum v3 = new Museum();
        v3.setName("Museum B");
        v3.setClosingTime(LocalTime.of(18, 0));
        v3.setOpeningTime(LocalTime.of(8, 0));
        v3.setTicketPrice(24);
        System.out.println(v3.getDetails());

        Church v4 = new Church();
        v4.setName("Church A");
        v4.setClosingTime(LocalTime.of(18, 0));
        v4.setOpeningTime(LocalTime.of(7, 0));
        System.out.println(v4.getDetails());

        Church v5 = new Church();
        v5.setName("Church B");
        v5.setClosingTime(LocalTime.of(20, 0));
        v5.setOpeningTime(LocalTime.of(6, 0));
        System.out.println(v5.getDetails());

        Restaurant v6 = new Restaurant();
        v6.setName("Restaurant");
        v6.setClosingTime(LocalTime.of(2, 0));
        v6.setOpeningTime(LocalTime.of(8, 0));
        v6.setRank(4.7);
        System.out.println(v6.getDetails());

        v1.setCost(v2, 10);
        v1.setCost(v3, 50);
        v2.setCost(v3, 20);
        v2.setCost(v4, 20);
        v2.setCost(v5, 10);
        v3.setCost(v4, 20);
        v4.setCost(v5, 30);
        v4.setCost(v6, 10);
        v5.setCost(v6, 20);

        System.out.println();
        System.out.println(v1.toString());

        City city = new City();
        city.addLocation(v1);
        city.addLocation(v2);
        city.addLocation(v3);
        city.addLocation(v4);
        city.addLocation(v5);
        city.addLocation(v6);

        System.out.println("\n");
        System.out.println(city.toString());
        city.displayVisitableNotPayable();

        TravelPlan x = new TravelPlan(city, Arrays.asList(LocationType.Hotel, LocationType.Restaurant, LocationType.Museum));
        System.out.println();
        System.out.println(x.toString());
    }
}
