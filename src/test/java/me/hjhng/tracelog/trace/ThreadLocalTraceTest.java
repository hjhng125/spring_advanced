package me.hjhng.tracelog.trace;

import org.junit.jupiter.api.Test;

class ThreadLocalTraceTest {

  ThreadLocalLogTrace trace = new ThreadLocalLogTrace();

  @Test
  void begin_end_level2() {
    TraceStatus level1 = trace.begin("level1");
    TraceStatus level2 = trace.begin("level2");

    trace.end(level2);
    trace.end(level1);
  }

  @Test
  void begin_exception_level2() {
    TraceStatus level1 = trace.begin("level1");
    TraceStatus level2 = trace.begin("level2");

    trace.exception(level2, new IllegalArgumentException());
    trace.exception(level1, new IllegalArgumentException());
  }
}