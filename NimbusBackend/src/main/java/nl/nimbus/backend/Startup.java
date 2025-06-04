package nl.nimbus.backend;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import nl.nimbus.backend.service.WeatherService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor
public class Startup implements ApplicationRunner {

  private ConfigurableApplicationContext context;
  private Environment environment;
  WeatherService weatherService;

  @Override
  public void run(ApplicationArguments args) {
    log.info("running startup");
    validateRequiredEnvironmentVariables();
    initWeatherService();
  }

  private void validateRequiredEnvironmentVariables() {
    if (environment.getProperty("nimbus.api.secret") == null
        || "".equals(environment.getProperty("nimbus.api.secret"))) {
      log.error("No Api Key");
      SpringApplication.exit(context, () -> 1);
      System.exit(1);
    }
  }

  public void initWeatherService() {
    weatherService.updateWeatherDaily();
    weatherService.updateWeatherHourly();
  }
}
