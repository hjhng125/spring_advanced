package me.hjhng.tracelog.template;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TemplateMethodTest {

  @Test
  void templateMethodLogicV0() {
    logic1();
    logic2();
  }

  private void logic1() {
    long startTime = System.currentTimeMillis();

    log.info("비즈니스 로직1 실행");

    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("resultTime = {}", resultTime);
  }

  private void logic2() {
    long startTime = System.currentTimeMillis();

    log.info("비즈니스 로직2 실행");

    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("resultTime = {}", resultTime);
  }

  @Test
  void templateMethodLogicV1() {
    AbstractTemplate template1 = new Logic1();
    template1.execute();

    AbstractTemplate template2 = new Logic2();
    template2.execute();
  }

  @Test
  void templateMethodLogic2() {
    AbstractTemplate template1 = new AbstractTemplate() {

      @Override
      protected void call() {
        log.info("비즈니스 로직3");
      }
    };
    log.info("클래스 이름 = {}", template1.getClass());
    template1.execute();

    AbstractTemplate template2 = new AbstractTemplate() {

      @Override
      protected void call() {
        log.info("비즈니스 로직4");
      }
    };
    log.info("클래스 이름 = {}", template2.getClass());
    template2.execute();
  }

}
