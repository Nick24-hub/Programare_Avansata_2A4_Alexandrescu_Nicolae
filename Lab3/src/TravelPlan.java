import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class TravelPlan {
    private City city;
    private List<LocationType> preferences = new ArrayList<>();

    public TravelPlan(City city, List<LocationType> preferences) {
        this.city = city;
        this.preferences = preferences;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public List<LocationType> getPreferences() {
        return preferences;
    }

    public void setPreferences(List<LocationType> preferences) {
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "TravelPlan{" +
                "city=" + city +
                ", preferences=" + preferences +
                '}';
    }
}
