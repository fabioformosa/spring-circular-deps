package it.fabioformosa.test.springcirculardeps.constrinj.services.impl;


import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fabioformosa.test.springcirculardeps.constrinj.services.BarService;
import it.fabioformosa.test.springcirculardeps.constrinj.services.FooService;

@Service
public class BarServiceImpl implements BarService {

  private static final Logger log = LoggerFactory.getLogger(BarServiceImpl.class);

  final private FooService fooService;

  @Autowired
  public BarServiceImpl(FooService fooService) {
    super();
    this.fooService = fooService;
  }

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
