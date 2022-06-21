package me.hjhng.tracelog.trace;

import org.junit.jupiter.api.Test;

class TraceTest {

  @Test
  void begin_end() {
    Trace trace = new Trace();
    TraceStatus start = trace.begin("Start");
    trace.end(start);
  }

  @Test
  void begin_exception() {
    Trace trace = new Trace();
    TraceStatus start = trace.begin("Start");
    trace.exception(start, new IllegalArgumentException());
  }

}