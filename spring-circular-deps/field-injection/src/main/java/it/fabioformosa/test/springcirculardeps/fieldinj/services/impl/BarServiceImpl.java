package it.fabioformosa.test.springcirculardeps.fieldinj.services.impl;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import it.fabioformosa.test.springcirculardeps.fieldinj.services.BarService;
import it.fabioformosa.test.springcirculardeps.fieldinj.services.BazService;
import it.fabioformosa.test.springcirculardeps.fieldinj.services.FooService;

@Service
public class BarServiceImpl implements BarService {

  private static final Logger log = LoggerFactory.getLogger(BarServiceImpl.class);

  @Resource
  private FooService fooService;

  @Resource
  private BazService bazService;

  public void doIt() {
    log.info("BAR SERVICE> I'm doing it...");
    fooService.doItForBar();
    log.info("BAR SERVICE> I've just did it!");
  }

  public void doItForFoo() {
    log.info("BAR SERVICE> I did it for Foo Service");
  }

  @PostConstruct
  void introduceMySelf() {
    log.debug("BAR SERVICE> Hi, I'm BarService");
  }

}
