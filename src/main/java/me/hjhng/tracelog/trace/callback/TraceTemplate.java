package me.hjhng.tracelog.trace.callback;

import lombok.extern.slf4j.Slf4j;
import me.hjhng.tracelog.trace.LogTrace;
import me.hjhng.tracelog.trace.TraceStatus;

@Slf4j
public class TraceTemplate {

  private final LogTrace logTrace;

  public TraceTemplate(LogTrace logTrace) {
    this.logTrace = logTrace;
  }

  public <T> T execute(String message, TraceCallback<T> callback) {
    TraceStatus status = null;
    try {
      status = logTrace.begin(message);
      T result = callback.call();
      logTrace.end(status);
      return result;
    } catch (Exception e) {
      logTrace.exception(status, e);
      throw e;
    }
  }
}
