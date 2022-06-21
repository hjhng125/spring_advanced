package me.hjhng.tracelog.trace;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class Trace {

  private static final String START_PREFIX = "-->";
  private static final String END_PREFIX = "<--";
  private static final String EXCEPTION_PREFIX = "<x-";

  public TraceStatus begin(String message) {
    TraceId traceId = TraceId.create();
    long startTimeMillis = System.currentTimeMillis();

    log.info("[{}] {}{}", traceId.id(), this.addSpace(START_PREFIX, traceId.level()), message);
    return TraceStatus.builder()
        .traceId(traceId)
        .startTimeMillis(startTimeMillis)
        .message(message)
        .build();
  }

  public void end(TraceStatus traceStatus) {
    this.complete(traceStatus, null);
  }

  public void exception(TraceStatus traceStatus, Exception e) {
    this.complete(traceStatus, e);
  }

  private void complete(TraceStatus traceStatus, Exception e) {
    Long stopTimeMillis = System.currentTimeMillis();
    long resultTimeMillis = stopTimeMillis - traceStatus.startTimeMillis();
    TraceId traceId = traceStatus.traceId();

    if (e == null) {
      log.info("[{}] {}{} time={}ms", traceId.id(), addSpace(END_PREFIX, traceId.level()), traceStatus.message(), resultTimeMillis);
    } else {
      log.info("[{}] {}{} time={}ms ex={}", traceId.id(), addSpace(EXCEPTION_PREFIX, traceId.level()), traceStatus.message(), resultTimeMillis, e.toString());
    }
  }

  private String addSpace(String prefix, int level) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < level; i++) {
      sb.append((i == level - 1) ? "|" + prefix : "|   ");
    }
    return sb.toString();
  }
}
