package in.asvignesh.springfactorypattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vignesh
 */
@RestController
public class SampleController {

  final Factory factory;

  public SampleController(Factory factory) {
    this.factory = factory;
  }

  @GetMapping("/test")
  String all() {
    Executor service = Factory.getService(ApplicationCommands.CLASS1);
    return service.execute();
  }
}
