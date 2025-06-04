package nl.nimbus.backend.service;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.nimbus.backend.dto.DailyResponseDto;
import nl.nimbus.backend.dto.HourlyResponseDto;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {

  @Getter private HourlyResponseDto weatherHourly;
  @Getter private DailyResponseDto weatherDaily;

  @NonNull ApiService apiService;

  @Scheduled(cron = "${app.cron.hourly}")
  public void updateWeatherHourly() {
    log.info("running scheduled update call to api for hourly weather");
    weatherHourly = apiService.getWeatherHourly();
  }

  @Scheduled(cron = "${app.cron.daily}")
  public void updateWeatherDaily() {
    log.info("running scheduled update call to api for daily weather");
    weatherDaily = apiService.getWeatherDaily();
  }
}
