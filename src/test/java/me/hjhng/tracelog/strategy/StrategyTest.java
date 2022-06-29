package me.hjhng.tracelog.strategy;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import me.hjhng.tracelog.template.AbstractTemplate;
import me.hjhng.tracelog.template.Logic1;
import me.hjhng.tracelog.template.Logic2;

@Slf4j
public class StrategyTest {

  @Test
  void StrategyLogicV1() {
    Context1 context1 = new Context1(new StrategyLogic1());
    context1.execute();

    Context1 context2 = new Context1(new StrategyLogic2());
    context2.execute();
  }

  @Test
  void StrategyLogicV2() {
    Context1 context1 = new Context1(() -> log.info("비즈니스 로직 3 실행"));
    context1.execute();

    Context1 context2 = new Context1(() -> log.info("비즈니스 로직 4 실행"));
    context2.execute();
  }

  @Test
  void StrategyLogicV3() {
    Context2 context1 = new Context2();
    context1.execute(() -> log.info("비즈니스 로직 3 실행"));
    context1.execute(() -> log.info("비즈니스 로직 4 실행"));
  }
}
