package tgeboers.clearsky.data;


import com.google.gson.annotations.SerializedName;

public class AccuWeatherLocation {
    @SerializedName("Key")
    private String key;
    @SerializedName("Rank")
    private int rank;
    @SerializedName("LocalizedName")
    private String localizedName;
    @SerializedName("Country")
    private AccuWeatherCountry country;

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

    public void setKey(String key) {
        this.key = key;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }

    public void setCountry(AccuWeatherCountry country) {
        this.country = country;
    }
}
