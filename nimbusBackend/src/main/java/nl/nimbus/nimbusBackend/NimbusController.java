package nl.nimbus.nimbusBackend;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NimbusController {


  @NonNull
  ApiService apiService;


}
