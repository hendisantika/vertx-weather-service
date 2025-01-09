package id.my.hendisantika.weather_service;

/**
 * Created by IntelliJ IDEA.
 * Project : weather-service
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 09/01/25
 * Time: 07.33
 * To change this template use File | Settings | File Templates.
 */
public class Weather {
  public static class Location {
    private String code;
    private String name;
    private String timezone;
    private Coordinates coordinates;

    // Getters and setters
    public String getCode() {
      return code;
    }

    public void setCode(String code) {
      this.code = code;
    }

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getTimezone() {
      return timezone;
    }

    public void setTimezone(String timezone) {
      this.timezone = timezone;
    }

    public Coordinates getCoordinates() {
      return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
      this.coordinates = coordinates;
    }
  }

  public static class Coordinates {
    private double latitude;
    private double longitude;

    // Getters and setters
    public double getLatitude() {
      return latitude;
    }

    public void setLatitude(double latitude) {
      this.latitude = latitude;
    }

    public double getLongitude() {
      return longitude;
    }

    public void setLongitude(double longitude) {
      this.longitude = longitude;
    }
  }
}
