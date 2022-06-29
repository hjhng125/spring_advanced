package me.hjhng.tracelog.callback;

import org.junit.jupiter.api.Test;

import lombok.extern.slf4j.Slf4j;
import me.hjhng.tracelog.strategy.Context1;
import me.hjhng.tracelog.strategy.Context2;
import me.hjhng.tracelog.strategy.StrategyLogic1;
import me.hjhng.tracelog.strategy.StrategyLogic2;

@Slf4j
public class TemplateCallbackTest {

  @Test
  void templateCallbackTest() {
    TimeLogTemplate template = new TimeLogTemplate();
    template.execute(() -> log.info("비즈니스 로직 3 실행"));
    template.execute(() -> log.info("비즈니스 로직 4 실행"));
  }
}
