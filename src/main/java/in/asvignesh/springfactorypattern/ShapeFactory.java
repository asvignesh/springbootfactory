package in.asvignesh.springfactorypattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author vignesh
 */
@Component
public class ShapeFactory {
  private static final Map<ShapesType, Shape> myServiceCache = new HashMap<>();

  private final List<Shape> handlers;

  @Autowired
  private ShapeFactory(List<Shape> handlers) {
    this.handlers = handlers;
  }

  public static Shape getShapeImplementation(ShapesType shapesType) {

    Shape service = myServiceCache.get(shapesType);
    if (null == service) {
      throw new RuntimeException("Unknown shape type: " + shapesType);
    }
    return FactoryUtil.getBean(service.getClass());
  }

  @PostConstruct
  public void initMyServiceCache() {
    handlers.forEach(service -> {
      RequestHandler annotation = service.getClass().getAnnotation(RequestHandler.class);
      ShapesType[] commands = annotation.command();
      for (ShapesType command : commands) {
        myServiceCache.put(command, service);
      }
    });
  }
}
