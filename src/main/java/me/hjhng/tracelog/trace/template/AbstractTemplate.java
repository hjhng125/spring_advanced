package me.hjhng.tracelog.trace.template;

import me.hjhng.tracelog.trace.LogTrace;
import me.hjhng.tracelog.trace.TraceStatus;

public abstract class AbstractTemplate<T> {

  private final LogTrace logTrace;

  protected AbstractTemplate(LogTrace logTrace) {
    this.logTrace = logTrace;
  }

  public T execute(String message) {
    TraceStatus status = null;
    try {
      status = logTrace.begin(message);
      T result = call();
      logTrace.end(status);

      return result;
    } catch (Exception e) {
      logTrace.exception(status, e);
      throw e;
    }
  }

  protected abstract T call();
}
