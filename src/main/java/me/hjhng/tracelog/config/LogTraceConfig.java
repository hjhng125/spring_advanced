package me.hjhng.tracelog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import me.hjhng.tracelog.trace.FieldLogTrace;
import me.hjhng.tracelog.trace.LogTrace;

@Configuration
public class LogTraceConfig {

  @Bean
  public LogTrace logTrace() {
    return new FieldLogTrace();
  }
}