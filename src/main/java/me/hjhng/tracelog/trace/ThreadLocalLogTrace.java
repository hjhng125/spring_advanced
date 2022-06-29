package me.hjhng.tracelog.trace;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalLogTrace implements LogTrace {

  private static final String START_PREFIX = "-->";
  private static final String END_PREFIX = "<--";
  private static final String EXCEPTION_PREFIX = "<x-";

  private ThreadLocal<TraceId> traceIdHolder = new ThreadLocal<>(); // traceId 동기화

  @Override
  public TraceStatus begin(String message) {
    this.syncTraceId();
    TraceId traceId = traceIdHolder.get();
    long startTimeMillis = System.currentTimeMillis();

    log.info("[{}] {}{}", traceId.id(), this.addSpace(START_PREFIX, traceId.level()), message);
    return TraceStatus.builder()
        .traceId(traceId)
        .startTimeMillis(startTimeMillis)
        .message(message)
        .build();
  }

  private void syncTraceId() {
    TraceId traceId = traceIdHolder.get();
    if (traceId == null) {
      traceIdHolder.set(TraceId.create());
      return;
    }

    traceIdHolder.set(traceId.createNextId());
  }

  @Override
  public void end(TraceStatus traceStatus) {
    this.complete(traceStatus, null);
  }

  @Override
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

    this.releaseTraceId();
  }

  private void releaseTraceId() {
    TraceId traceId = traceIdHolder.get();
    if (traceId.isFirstLevel()) {
      traceIdHolder.remove();
      return;
    }

    traceIdHolder.set(traceId.createPreviousId());
  }

  private String addSpace(String prefix, int level) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < level; i++) {
      sb.append((i == level - 1) ? "|" + prefix : "|   ");
    }
    return sb.toString();
  }
}
