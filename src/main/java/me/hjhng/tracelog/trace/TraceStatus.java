package me.hjhng.tracelog.trace;

import lombok.Builder;
import me.hjhng.tracelog.trace.TraceId;

public class TraceStatus {

  private final TraceId traceId;

  private final Long startTimeMillis;

  private final String message;

  @Builder
  public TraceStatus(TraceId traceId, Long startTimeMillis, String message) {
    this.traceId = traceId;
    this.startTimeMillis = startTimeMillis;
    this.message = message;
  }

  public TraceId traceId() {
    return this.traceId;
  }

  public Long startTimeMillis() {
    return this.startTimeMillis;
  }

  public String message() {
    return this.message;
  }
}
