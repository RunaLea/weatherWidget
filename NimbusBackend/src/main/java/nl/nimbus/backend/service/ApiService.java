package nl.nimbus.backend.service;

import lombok.extern.slf4j.Slf4j;
import nl.nimbus.backend.dto.WeatherResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Service
public class ApiService {

  @Value("${nimbus.api.url}")
  private String weatherApiUrl;

  @Value("${nimbus.api.location}")
  private String weatherApiLocation;

  @Value("${nimbus.api.units}")
  private String weatherApiUnits;

  @Value("${nimbus.api.subDirectory}")
  private String weatherApiSub;

  @Value("${nimbus.api.secret}")
  private String weatherApikey;

  private final RestClient restClient;

  public ApiService(RestClient.Builder restClientBuilder) {
    this.restClient = restClientBuilder.build();
  }

  public WeatherResponseDto getWeather() {
    try {
      return restClient
          .get()
          .uri(
              UriComponentsBuilder.fromUriString(weatherApiUrl + weatherApiSub)
                  .queryParam("location", weatherApiLocation)
                  .queryParam("units", weatherApiUnits)
                  .queryParam("apikey", weatherApikey)
                  .toUriString())
          .retrieve()
          .body(WeatherResponseDto.class);
    } catch (Exception e) {
      log.error("Exception during API call", e);
      throw new RuntimeException("API call failed", e);
    }
  }
}
