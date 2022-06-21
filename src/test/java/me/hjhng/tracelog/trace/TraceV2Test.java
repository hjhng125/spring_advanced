package me.hjhng.tracelog.trace;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TraceV2Test {

  @Test
  void begin_end() {
    TraceV2 trace = new TraceV2();
    TraceStatus start = trace.begin("Start");
    TraceStatus status = trace.beginSync(start.traceId(), "beginSync");
    trace.end(status);
    trace.end(start);
  }

  @Test
  void begin_exception() {
    TraceV2 trace = new TraceV2();
    TraceStatus start = trace.begin("Start");
    TraceStatus status = trace.beginSync(start.traceId(), "beginSync");
    trace.exception(status, new IllegalArgumentException());
    trace.exception(start, new IllegalArgumentException());
  }
}