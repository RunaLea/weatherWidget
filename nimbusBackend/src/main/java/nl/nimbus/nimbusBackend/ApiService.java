package nl.nimbus.nimbusBackend;

import lombok.NonNull;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class ApiService {

  @NonNull
  private RestTemplate restTemplate;


public String getDailyWeather(){
  return restTemplate.exchange(UriComponentsBuilder.fromUriString())
}

}
