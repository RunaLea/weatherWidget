package nl.nimbus.backend.dto;

import java.util.Date;
import java.util.List;

public class HourlyResponseDto {
  public Timelines timelines;
  public Location location;

  public static class Timelines {

    public List<Hourly> hourly;

    public static class Hourly {

      public Date time;
      public Values values;

      public static class Values {
        public double cloudBase;
        public double cloudCeiling;
        public int cloudCover;
        public double dewPoint;
        public int freezingRainIntensity;
        public int humidity;
        public int iceAccumulation;
        public int iceAccumulationLwe;
        public int precipitationProbability;
        public double pressureSeaLevel;
        public double pressureSurfaceLevel;
        public int rainAccumulation;
        public double rainIntensity;
        public int sleetAccumulation;
        public int sleetAccumulationLwe;
        public int sleetIntensity;
        public int snowAccumulation;
        public int snowAccumulationLwe;
        public int snowIntensity;
        public double temperature;
        public double temperatureApparent;
        public int uvHealthConcern;
        public int uvIndex;
        public int visibility;
        public int weatherCode;
        public int windDirection;
        public double windGust;
        public double windSpeed;
      }
    }
  }

  public static class Location {
    public double lat;
    public double lon;
  }
}
