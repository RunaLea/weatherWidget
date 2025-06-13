package nl.nimbus.backend.service;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.nimbus.backend.dto.WeatherResponseDto;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class WeatherService {

  @Getter private WeatherResponseDto weather;

  @NonNull ApiService apiService;

  @Scheduled(cron = "${app.cron.weather}")
  public void updateWeather() {
    log.info("running scheduled update call to api for weather");
    weather = apiService.getWeather();
  }
}
