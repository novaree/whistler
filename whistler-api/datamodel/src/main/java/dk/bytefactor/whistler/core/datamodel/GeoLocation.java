package dk.bytefactor.whistler.core.datamodel;

import java.math.BigDecimal;

/**
 * Created by casper on 31/08/14.
 */
class GeoLocation {
    private BigDecimal longitude;
    private BigDecimal latitude;

    public GeoLocation() {}

    GeoLocation(BigDecimal longitude, BigDecimal latitude) {
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    @Override
    public String toString() {
        return "GeoLocation{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}';
    }
}
