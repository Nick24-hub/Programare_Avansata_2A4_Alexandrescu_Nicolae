import java.time.LocalTime;

public class Restaurant extends Location implements Visitable, Classifiable {
    private LocalTime openingTime, closingTime;
    private double rank;

    @Override
    public LocalTime getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(LocalTime openingTime) {
        this.openingTime = openingTime;
    }

    @Override
    public LocalTime getClosingTime() {
        return closingTime;
    }

    public void setClosingTime(LocalTime closingTime) {
        this.closingTime = closingTime;
    }

    @Override
    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public String getDetails() {
        return "Restaurant{ name='" + super.getName() + "', openingTime="
                + openingTime +
                ", closingTime=" + closingTime +
                ", rank=" + rank +
                '}';
    }
}
