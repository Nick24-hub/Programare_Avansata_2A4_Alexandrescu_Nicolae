import java.time.LocalTime;

public class Church extends Location implements Visitable {
    private LocalTime openingTime, closingTime;

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
    public void setCost(Location node, int value) {
        super.setCost(node, value);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getDetails() {
        return "Church{ name='" + super.getName() + "', openingTime="
                + openingTime +
                ", closingTime=" + closingTime +
                '}';
    }
}
