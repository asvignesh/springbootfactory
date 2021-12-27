package in.asvignesh.springfactorypattern;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import static in.asvignesh.springfactorypattern.ApplicationCommands.CLASS2;

/**
 * @author vignesh
 */
@Service
@RequestHandler(command = CLASS2)
@Scope(value = "prototype")
public class Class2 implements Executor {
  @Override
  public String execute() {
    return Integer.toHexString(System.identityHashCode(this));
  }
}
