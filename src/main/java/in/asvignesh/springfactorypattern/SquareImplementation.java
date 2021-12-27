package in.asvignesh.springfactorypattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static in.asvignesh.springfactorypattern.ShapesType.SQUARE;

/**
 * @author vignesh
 */
@Shapes(command = SQUARE)
@Service
@Scope(value = "prototype")
public class SquareImplementation implements Shape {
  @Override
  public String draw() {
    return Integer.toHexString(System.identityHashCode(this));
  }
}
