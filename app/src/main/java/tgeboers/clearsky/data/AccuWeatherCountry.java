package tgeboers.clearsky.data;


public class AccuWeatherCountry {
    private final String id;
    private final String localizedName;

    public AccuWeatherCountry(String id, String localizedName) {
        this.id = id;
        this.localizedName = localizedName;
    }

    public String getId() {
        return id;
    }

    public String getLocalizedName() {
        return localizedName;
    }
}
