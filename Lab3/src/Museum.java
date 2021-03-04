import java.time.LocalTime;

public class Museum extends Location implements Visitable, Payable {
    private LocalTime openingTime, closingTime;
    private double ticketPrice;


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
    public double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
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
        return "Museum{ name='" + super.getName() + "', openingTime=" + openingTime +
                ", closingTime=" + closingTime +
                ", ticketPrice=" + ticketPrice +
                '}';
    }
}