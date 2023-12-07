package imdb;

public class Address {
    String countyName;
    String provienceName;
    String cityName;
    String street;
    int plaque;

    @Override
    public String toString() {
        return "Address{" +
                "country='"+countyName+'\''+
                "provienceName='" + provienceName + '\'' +
                ", cityName='" + cityName + '\'' +
                ", street='" + street + '\'' +
                ", plaque=" + plaque +
                '}';
    }

    public String getProvienceName() {
        return provienceName;
    }

    public void setProvienceName(String provienceName) {
        this.provienceName = provienceName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getPlaque() {
        return plaque;
    }

    public void setPlaque(int plaque) {
        this.plaque = plaque;
    }

    public Address(String countyName,String provienceName, String cityName, String street, int plaque) {
        this.provienceName = provienceName;
        this.countyName = countyName;
        this.cityName = cityName;
        this.street = street;
        this.plaque = plaque;
    }
}
