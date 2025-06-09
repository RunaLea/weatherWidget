package nl.nimbus.backend.dto;

import java.util.ArrayList;
import java.util.Date;

public class WeatherResponseDto {

  public class Timelines{
    public ArrayList<Minutely> minutely;
    public ArrayList<Hourly> hourly;
    public ArrayList<Daily> daily;

    public static class Minutely{
      public Date time;
      public Values values;
    }

      public static class Hourly{
        public Date time;
        public Values values;
      }

      public static class Daily{
        public Date time;
        public Values values;
      }

    public static class Values{
      public double cloudBase;
      public double cloudCeiling;
      public int cloudCover;
      public double dewPoint;
      public int freezingRainIntensity;
      public int humidity;
      public int precipitationProbability;
      public double pressureSeaLevel;
      public double pressureSurfaceLevel;
      public int rainIntensity;
      public int sleetIntensity;
      public int snowIntensity;
      public double temperature;
      public double temperatureApparent;
      public int uvHealthConcern;
      public int uvIndex;
      public double visibility;
      public int weatherCode;
      public int windDirection;
      public double windGust;
      public double windSpeed;
      public int iceAccumulation;
      public int iceAccumulationLwe;
      public int rainAccumulation;
      public int sleetAccumulation;
      public int sleetAccumulationLwe;
      public int snowAccumulation;
      public int snowAccumulationLwe;
      public double cloudBaseAvg;
      public double cloudBaseMax;
      public double cloudBaseMin;
      public double cloudCeilingAvg;
      public double cloudCeilingMax;
      public int cloudCeilingMin;
      public int cloudCoverAvg;
      public int cloudCoverMax;
      public int cloudCoverMin;
      public double dewPointAvg;
      public double dewPointMax;
      public double dewPointMin;
      public int freezingRainIntensityAvg;
      public int freezingRainIntensityMax;
      public int freezingRainIntensityMin;
      public int humidityAvg;
      public int humidityMax;
      public int humidityMin;
      public int iceAccumulationAvg;
      public int iceAccumulationLweAvg;
      public int iceAccumulationLweMax;
      public int iceAccumulationLweMin;
      public int iceAccumulationLweSum;
      public int iceAccumulationMax;
      public int iceAccumulationMin;
      public int iceAccumulationSum;
      public Date moonriseTime;
      public Date moonsetTime;
      public double precipitationProbabilityAvg;
      public int precipitationProbabilityMax;
      public int precipitationProbabilityMin;
      public double pressureSeaLevelAvg;
      public double pressureSeaLevelMax;
      public double pressureSeaLevelMin;
      public double pressureSurfaceLevelAvg;
      public double pressureSurfaceLevelMax;
      public double pressureSurfaceLevelMin;
      public double rainAccumulationAvg;
      public double rainAccumulationMax;
      public int rainAccumulationMin;
      public double rainAccumulationSum;
      public double rainIntensityAvg;
      public double rainIntensityMax;
      public int rainIntensityMin;
      public int sleetAccumulationAvg;
      public int sleetAccumulationLweAvg;
      public int sleetAccumulationLweMax;
      public int sleetAccumulationLweMin;
      public int sleetAccumulationLweSum;
      public int sleetAccumulationMax;
      public int sleetAccumulationMin;
      public int sleetIntensityAvg;
      public int sleetIntensityMax;
      public int sleetIntensityMin;
      public int snowAccumulationAvg;
      public int snowAccumulationLweAvg;
      public int snowAccumulationLweMax;
      public int snowAccumulationLweMin;
      public int snowAccumulationLweSum;
      public int snowAccumulationMax;
      public int snowAccumulationMin;
      public int snowAccumulationSum;
      public int snowIntensityAvg;
      public int snowIntensityMax;
      public int snowIntensityMin;
      public Date sunriseTime;
      public Date sunsetTime;
      public double temperatureApparentAvg;
      public double temperatureApparentMax;
      public double temperatureApparentMin;
      public double temperatureAvg;
      public double temperatureMax;
      public double temperatureMin;
      public int uvHealthConcernAvg;
      public int uvHealthConcernMax;
      public int uvHealthConcernMin;
      public int uvIndexAvg;
      public int uvIndexMax;
      public int uvIndexMin;
      public double visibilityAvg;
      public int visibilityMax;
      public double visibilityMin;
      public int weatherCodeMax;
      public int weatherCodeMin;
      public int windDirectionAvg;
      public double windGustAvg;
      public double windGustMax;
      public double windGustMin;
      public double windSpeedAvg;
      public double windSpeedMax;
      public double windSpeedMin;
    }


  }



  public Timelines timelines;
  public Location location;

  public static class Location{
    public double lat;
    public double lon;
  }

}




