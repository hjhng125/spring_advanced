package me.hjhng.tracelog.template;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

  public void execute() {
    long startTime = System.currentTimeMillis();

    this.call();

    long endTime = System.currentTimeMillis();
    long resultTime = endTime - startTime;
    log.info("resultTime = {}", resultTime);
  }

  protected abstract void call();
}
