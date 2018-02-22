package it.fabioformosa.test.springcirculardeps.constrinj.services.impl;


import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.fabioformosa.test.springcirculardeps.constrinj.services.BarService;
import it.fabioformosa.test.springcirculardeps.constrinj.services.FooService;

@Service
public class FooServiceImpl implements FooService {

  private static final Logger log = LoggerFactory.getLogger(FooServiceImpl.class);

  @Resource
  private BarService barService;

  @Autowired
  public FooServiceImpl(BarService barService) {
    super();
    this.barService = barService;
  }

  public void doIt() {
    log.info("FOO SERVICE> I'm doing it...");
    barService.doItForFoo();
    log.info("FOO SERVICE> I've just did it!");
  }

  public void doItForBar() {
    log.info("FOO SERVICE> I did it for Bar Service");
  }

  @PostConstruct
  void introduceMySelf() {
    log.debug("FOO SERVICE> Hi, I'm FooService");
  }

}
