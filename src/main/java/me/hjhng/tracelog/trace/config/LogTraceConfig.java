package me.hjhng.tracelog.trace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.hjhng.tracelog.trace.FieldLogTrace;
import me.hjhng.tracelog.trace.LogTrace;
import me.hjhng.tracelog.trace.ThreadLocalLogTrace;

@Configuration
public class LogTraceConfig {

  @Bean
  public LogTrace logTrace() {
    return new ThreadLocalLogTrace();
  }
}
