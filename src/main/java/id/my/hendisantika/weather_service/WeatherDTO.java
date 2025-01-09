package id.my.hendisantika.weather_service;

import java.util.List;

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
public class WeatherDTO {
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

  public static class Forecast {
    private List<ForecastItem> items;

    // Getters and setters
    public List<ForecastItem> getItems() {
      return items;
    }

    public void setItems(List<ForecastItem> items) {
      this.items = items;
    }
  }

  public static class ForecastItem {
    private String date;
    private String dateWithTimezone;
    private double freshSnow;
    private Object snowHeight;
    private Weather weather;
    private Precipitation prec;
    private double sunHours;
    private Object rainHours;
    private Temperature temperature;
    private Wind wind;
    private Windchill windchill;
    private SnowLine snowLine;
    private Astronomy astronomy;

    public String getDate() {
      return date;
    }

    public void setDate(String date) {
      this.date = date;
    }

    public String getDateWithTimezone() {
      return dateWithTimezone;
    }

    public void setDateWithTimezone(String dateWithTimezone) {
      this.dateWithTimezone = dateWithTimezone;
    }

    public double getFreshSnow() {
      return freshSnow;
    }

    public void setFreshSnow(double freshSnow) {
      this.freshSnow = freshSnow;
    }

    public Object getSnowHeight() {
      return snowHeight;
    }

    public void setSnowHeight(Object snowHeight) {
      this.snowHeight = snowHeight;
    }

    public Weather getWeather() {
      return weather;
    }

    public void setWeather(Weather weather) {
      this.weather = weather;
    }

    public Precipitation getPrec() {
      return prec;
    }

    public void setPrec(Precipitation prec) {
      this.prec = prec;
    }

    public double getSunHours() {
      return sunHours;
    }

    public void setSunHours(double sunHours) {
      this.sunHours = sunHours;
    }

    public Object getRainHours() {
      return rainHours;
    }

    public void setRainHours(Object rainHours) {
      this.rainHours = rainHours;
    }

    public Temperature getTemperature() {
      return temperature;
    }

    public void setTemperature(Temperature temperature) {
      this.temperature = temperature;
    }

    public Wind getWind() {
      return wind;
    }

    public void setWind(Wind wind) {
      this.wind = wind;
    }

    public Windchill getWindchill() {
      return windchill;
    }

    public void setWindchill(Windchill windchill) {
      this.windchill = windchill;
    }

    public SnowLine getSnowLine() {
      return snowLine;
    }

    public void setSnowLine(SnowLine snowLine) {
      this.snowLine = snowLine;
    }

    public Astronomy getAstronomy() {
      return astronomy;
    }

    public void setAstronomy(Astronomy astronomy) {
      this.astronomy = astronomy;
    }
  }

  public static class Weather {
    private int state;
    private String text;
    private String icon;

    // Getters and setters
    public int getState() {
      return state;
    }

    public void setState(int state) {
      this.state = state;
    }

    public String getText() {
      return text;
    }

    public void setText(String text) {
      this.text = text;
    }

    public String getIcon() {
      return icon;
    }

    public void setIcon(String icon) {
      this.icon = icon;
    }
  }

  public static class Precipitation {
    private double sum;
    private int probability;
    private Object sumAsRain;
    private int precClass;

    // Getters and setters
    public double getSum() {
      return sum;
    }

    public void setSum(double sum) {
      this.sum = sum;
    }

    public int getProbability() {
      return probability;
    }

    public void setProbability(int probability) {
      this.probability = probability;
    }

    public Object getSumAsRain() {
      return sumAsRain;
    }

    public void setSumAsRain(Object sumAsRain) {
      this.sumAsRain = sumAsRain;
    }

    public int getPrecClass() {
      return precClass;
    }

    public void setPrecClass(int precClass) {
      this.precClass = precClass;
    }
  }

  public static class Temperature {
    private double min;
    private double max;
    private Object avg;

    // Getters and setters
    public double getMin() {
      return min;
    }

    public void setMin(double min) {
      this.min = min;
    }

    public double getMax() {
      return max;
    }

    public void setMax(double max) {
      this.max = max;
    }

    public Object getAvg() {
      return avg;
    }

    public void setAvg(Object avg) {
      this.avg = avg;
    }
  }
}
