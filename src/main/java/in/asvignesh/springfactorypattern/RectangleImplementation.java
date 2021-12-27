package in.asvignesh.springfactorypattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static in.asvignesh.springfactorypattern.ShapesType.RECTANGLE;

/**
 * @author vignesh
 */
@Service
@Shapes(command = RECTANGLE)
@Scope(value = "prototype")
public class RectangleImplementation implements Shape {
  @Override
  public String draw() {
    return Integer.toHexString(System.identityHashCode(this));
  }
}
