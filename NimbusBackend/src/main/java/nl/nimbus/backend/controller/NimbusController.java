package nl.nimbus.backend.controller;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import nl.nimbus.backend.dto.DailyResponseDto;
import nl.nimbus.backend.dto.HourlyResponseDto;
import nl.nimbus.backend.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class NimbusController {

  @NonNull WeatherService weatherService;

  @GetMapping("hourly")
  public HourlyResponseDto getHourly() {
    log.info("request made for hourly weather");
    return weatherService.getWeatherHourly();
  }

  @GetMapping("daily")
  public DailyResponseDto getDaily() {
    log.info("request made for daily weather");
    return weatherService.getWeatherDaily();
  }
}
