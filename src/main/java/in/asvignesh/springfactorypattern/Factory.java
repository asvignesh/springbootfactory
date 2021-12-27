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
public class Factory {
  private static final Map<ApplicationCommands, Executor> myServiceCache = new HashMap<>();

  private final List<Executor> handlers;

  @Autowired
  private Factory(List<Executor> handlers) {
    this.handlers = handlers;
  }

  public static Executor getService(ApplicationCommands applicationCommands) {

    Executor service = myServiceCache.get(applicationCommands);
    if (null == service) {
      throw new RuntimeException("Unknown service type: " + applicationCommands);
    }
    return FactoryUtil.getBean(service.getClass());
  }

  @PostConstruct
  public void initMyServiceCache() {
    handlers.forEach(service -> {
      RequestHandler annotation = service.getClass().getAnnotation(RequestHandler.class);
      ApplicationCommands[] commands = annotation.command();
      for (ApplicationCommands command : commands) {
        myServiceCache.put(command, service);
      }
    });
  }
}
