package in.asvignesh.springfactorypattern;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author vignesh
 */
@RestController
public class SampleController {

  final ShapeFactory factory;

  public SampleController(ShapeFactory factory) {
    this.factory = factory;
  }

  @GetMapping("/test")
  String all() {
    Shape service = ShapeFactory.getShapeImplementation(ShapesType.SQUARE);
    return service.draw();
  }
}
