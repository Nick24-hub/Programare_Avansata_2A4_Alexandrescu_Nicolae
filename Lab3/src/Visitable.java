import java.time.Duration;
import java.time.LocalTime;

public interface Visitable {
    LocalTime getOpeningTime();

    LocalTime getClosingTime();

    default LocalTime setOpeningTime() {
        return LocalTime.of(9,30);
    }

    default LocalTime setClosingTime() {
        return LocalTime.of(20,0);
    }

    static Duration getVisitingDuration(Visitable vis)
    {
        return Duration.between(vis.getOpeningTime(), vis.getClosingTime());
    }


}
