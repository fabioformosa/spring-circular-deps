package it.fabioformosa.test.springcirculardeps.constrinj;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.fabioformosa.test.springcirculardeps.constrinj.services.BarService;
import it.fabioformosa.test.springcirculardeps.constrinj.services.FooService;

@Component
public class ServiceManager {

  private static final Logger log = LoggerFactory.getLogger(ServiceManager.class);

  private FooService fooService;

  private BarService barService;

  @Autowired
  public ServiceManager(FooService fooService, BarService barService) {
    super();
    this.fooService = fooService;
    this.barService = barService;
  }

  public void doIt() {
    log.info("SERVICE MANAGER> ** I'm calling foo service... **");
    fooService.doIt();

    log.info("SERVICE MANAGER> ** I'm calling bar service... **");
    barService.doIt();
  }

  @PostConstruct
  public void sayHello() {
    log.debug("SERVICE MANAGER> Hi, I'm ServiceManager");
  }

}
