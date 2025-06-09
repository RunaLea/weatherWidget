package nl.nimbus.backend.controller;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import nl.nimbus.backend.dto.WeatherResponseDto;
import nl.nimbus.backend.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@AllArgsConstructor
public class NimbusController {

  @NonNull WeatherService weatherService;

  @GetMapping("weather")
  public WeatherResponseDto getWeather() {
    log.info("request made for weather");
    return weatherService.getWeather();
  }
}
