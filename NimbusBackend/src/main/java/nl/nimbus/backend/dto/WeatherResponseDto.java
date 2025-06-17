package nl.nimbus.backend.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

public class WeatherResponseDto {

  public class Timelines {
    public ArrayList<Minutely> minutely;
    public ArrayList<Hourly> hourly;
    public ArrayList<Daily> daily;

    public static class Minutely {
      public Instant  time;
      public Values values;

      public static class Values {
        public Double cloudBase;
        public Double cloudCeiling;
        public Integer cloudCover;
        public Double dewPoint;
        public Integer freezingRainIntensity;
        public Integer humidity;
        public Integer precipitationProbability;
        public Double pressureSeaLevel;
        public Double pressureSurfaceLevel;
        public Double rainIntensity;
        public Integer sleetIntensity;
        public Integer snowIntensity;
        public Double temperature;
        public Double temperatureApparent;
        public Integer uvHealthConcern;
        public Integer uvIndex;
        public Integer visibility;
        public Integer weatherCode;
        public Integer windDirection;
        public Double windGust;
        public Double windSpeed;
      }
    }

    public static class Hourly {
      public Instant time;
      public Values values;

      public static class Values {
        public Double cloudBase;
        public Double cloudCeiling;
        public Integer cloudCover;
        public Double dewPoint;
        public Integer freezingRainIntensity;
        public Integer humidity;
        public Integer iceAccumulation;
        public Integer iceAccumulationLwe;
        public Integer precipitationProbability;
        public Double pressureSeaLevel;
        public Double pressureSurfaceLevel;
        public Double rainAccumulation;
        public Double rainIntensity;
        public Integer sleetAccumulation;
        public Integer sleetAccumulationLwe;
        public Integer sleetIntensity;
        public Integer snowAccumulation;
        public Integer snowAccumulationLwe;
        public Integer snowIntensity;
        public Double temperature;
        public Double temperatureApparent;
        public Integer uvHealthConcern;
        public Integer uvIndex;
        public Double visibility;
        public Integer weatherCode;
        public Integer windDirection;
        public Double windGust;
        public Double windSpeed;
      }
    }

    public static class Daily {
      public Instant  time;
      public Values values;

      public static class Values {
        public Double cloudBaseAvg;
        public Double cloudBaseMax;
        public Double cloudBaseMin;
        public Double cloudCeilingAvg;
        public Double cloudCeilingMax;
        public Integer cloudCeilingMin;
        public Integer cloudCoverAvg;
        public Integer cloudCoverMax;
        public Integer cloudCoverMin;
        public Double dewPointAvg;
        public Double dewPointMax;
        public Double dewPointMin;
        public Integer freezingRainIntensityAvg;
        public Integer freezingRainIntensityMax;
        public Integer freezingRainIntensityMin;
        public Integer humidityAvg;
        public Integer humidityMax;
        public Integer humidityMin;
        public Integer iceAccumulationAvg;
        public Integer iceAccumulationLweAvg;
        public Integer iceAccumulationLweMax;
        public Integer iceAccumulationLweMin;
        public Integer iceAccumulationLweSum;
        public Integer iceAccumulationMax;
        public Integer iceAccumulationMin;
        public Integer iceAccumulationSum;
        public Date moonriseTime;
        public Date moonsetTime;
        public Integer precipitationProbabilityAvg;
        public Integer precipitationProbabilityMax;
        public Integer precipitationProbabilityMin;
        public Double pressureSeaLevelAvg;
        public Double pressureSeaLevelMax;
        public Double pressureSeaLevelMin;
        public Double pressureSurfaceLevelAvg;
        public Double pressureSurfaceLevelMax;
        public Double pressureSurfaceLevelMin;
        public Integer rainAccumulationAvg;
        public Integer rainAccumulationMax;
        public Integer rainAccumulationMin;
        public Integer rainAccumulationSum;
        public Double rainIntensityAvg;
        public Double rainIntensityMax;
        public Integer rainIntensityMin;
        public Integer sleetAccumulationAvg;
        public Integer sleetAccumulationLweAvg;
        public Integer sleetAccumulationLweMax;
        public Integer sleetAccumulationLweMin;
        public Integer sleetAccumulationLweSum;
        public Integer sleetAccumulationMax;
        public Integer sleetAccumulationMin;
        public Integer sleetIntensityAvg;
        public Integer sleetIntensityMax;
        public Integer sleetIntensityMin;
        public Integer snowAccumulationAvg;
        public Integer snowAccumulationLweAvg;
        public Integer snowAccumulationLweMax;
        public Integer snowAccumulationLweMin;
        public Integer snowAccumulationLweSum;
        public Integer snowAccumulationMax;
        public Integer snowAccumulationMin;
        public Integer snowAccumulationSum;
        public Integer snowIntensityAvg;
        public Integer snowIntensityMax;
        public Integer snowIntensityMin;
        public Date sunriseTime;
        public Date sunsetTime;
        public Double temperatureApparentAvg;
        public Double temperatureApparentMax;
        public Double temperatureApparentMin;
        public Double temperatureAvg;
        public Double temperatureMax;
        public Double temperatureMin;
        public Integer uvHealthConcernAvg;
        public Integer uvHealthConcernMax;
        public Integer uvHealthConcernMin;
        public Integer uvIndexAvg;
        public Integer uvIndexMax;
        public Integer uvIndexMin;
        public Double visibilityAvg;
        public Integer visibilityMax;
        public Double visibilityMin;
        public Integer weatherCodeMax;
        public Integer weatherCodeMin;
        public Integer windDirectionAvg;
        public Double windGustAvg;
        public Double windGustMax;
        public Double windGustMin;
        public Double windSpeedAvg;
        public Double windSpeedMax;
        public Double windSpeedMin;
      }
    }
  }

  public Timelines timelines;
  public Location location;

  public static class Location {
    public Double lat;
    public Double lon;
  }
}
