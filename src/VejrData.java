public class VejrData {

    String date;
    String location;
    Double maxTemp_c;
    Double minTemp_c;
    String sunrise;
    String sunset;
    String conditions;

    public VejrData(String date, String location, Double maxTemp_c, Double minTemp_c, String sunrise, String sunset, String conditions) {
        this.date = date;
        this.location = location;
        this.maxTemp_c = maxTemp_c;
        this.minTemp_c = minTemp_c;
        this.sunrise = sunrise;
        this.sunset = sunset;
        this.conditions = conditions;
    }

    public VejrData() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getMaxTemp_c() {
        return maxTemp_c;
    }

    public void setMaxTemp_c(Double maxTemp_c) {
        this.maxTemp_c = maxTemp_c;
    }

    public Double getMinTemp_c() {
        return minTemp_c;
    }

    public void setMinTemp_c(Double minTemp_c) {
        this.minTemp_c = minTemp_c;
    }

    public String getSunrise() {
        return sunrise;
    }

    public void setSunrise(String sunrise) {
        this.sunrise = sunrise;
    }

    public String getSunset() {
        return sunset;
    }

    public void setSunset(String sunset) {
        this.sunset = sunset;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return "VejrData{" +
                "date='" + date + '\'' +
                ", location='" + location + '\'' +
                ", maxTemp_c=" + maxTemp_c +
                ", minTemp_c=" + minTemp_c +
                ", sunrise='" + sunrise + '\'' +
                ", sunset='" + sunset + '\'' +
                ", conditions='" + conditions + '\'' +
                '}';
    }
}
