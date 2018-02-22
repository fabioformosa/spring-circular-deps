package it.fabioformosa.test.springcirculardeps.constrinj;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


/**
 * Hello world!
 *
 */
public class App {

  private static final Logger log = LoggerFactory.getLogger(App.class);

  public static void main(String[] args) {
    log.info("###########################################");
    log.info("#      SPRING CIRCULAR DEPENDENCY         #");
    log.info("#    CONSTRUCTOR INJECTION Testing...     #");
    log.info("###########################################");

    AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
    ctx.scan("it.fabioformosa.test.springcirculardeps.constrinj");
    ctx.refresh();

    log.debug("-------------- BEANs CREATED --------------");

    ServiceManager serviceManager = ctx.getBean(ServiceManager.class);
    serviceManager.doIt();

    log.info("Spring Circular Dependency - Tested!");
    log.info("###########################################");
  }
}
