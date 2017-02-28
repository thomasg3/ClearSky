package tgeboers.clearsky.data;


import com.google.gson.annotations.SerializedName;

public class AccuWeatherCountry {
    @SerializedName("ID")
    private String id;
    @SerializedName("LocalizedName")
    private String localizedName;

    public String getId() {
        return id;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLocalizedName(String localizedName) {
        this.localizedName = localizedName;
    }
}
