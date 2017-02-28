package tgeboers.clearsky.data;


public class AccuWeatherLocation {
    private final String key;
    private final int rank;
    private final String localizedName;
    private final AccuWeatherCountry country;

    public AccuWeatherLocation(AccuWeatherCountry country, String localizedName, int rank, String key) {
        this.country = country;
        this.localizedName = localizedName;
        this.rank = rank;
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public int getRank() {
        return rank;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public AccuWeatherCountry getCountry() {
        return country;
    }
}
