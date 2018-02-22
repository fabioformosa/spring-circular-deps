package it.fabioformosa.test.springcirculardeps.fieldinj;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import it.fabioformosa.test.springcirculardeps.fieldinj.services.BarService;
import it.fabioformosa.test.springcirculardeps.fieldinj.services.FooService;

@Component
public class ServiceManager {

  private static final Logger log = LoggerFactory.getLogger(ServiceManager.class);

  @Resource
  private FooService fooService;

  @Resource
  private BarService barService;

  public void doIt() {
    log.info("SERVICE MANAGER> I'm calling foo service...");
    fooService.doIt();

    log.info("SERVICE MANAGER> I'm calling bar service...");
    barService.doIt();
  }

  @PostConstruct
  public void sayHello() {
    log.debug("SERVICE MANAGER> Hi, I'm ServiceManager");
  }

}
