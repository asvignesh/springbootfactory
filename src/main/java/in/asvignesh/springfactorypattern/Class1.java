package in.asvignesh.springfactorypattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static in.asvignesh.springfactorypattern.ApplicationCommands.CLASS1;

/**
 * @author vignesh
 */
@RequestHandler(command = CLASS1)
@Service
@Scope(value = "prototype")
public class Class1 implements Executor {
  @Override
  public String execute() {
    return Integer.toHexString(System.identityHashCode(this));
  }
}
