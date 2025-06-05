package nl.nimbus.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class NimbusBackendApplication {

  public static void main(String[] args) {
    SpringApplication.run(NimbusBackendApplication.class, args);
  }
}
