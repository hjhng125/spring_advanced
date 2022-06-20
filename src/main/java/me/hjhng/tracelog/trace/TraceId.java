package me.hjhng.tracelog.trace;

import java.util.UUID;

import lombok.Builder;

public class TraceId {

  private final String id;

  private final int level;

  public static TraceId create() {
    return new TraceId();
  }
  private TraceId() {
    this.id = this.createId();
    this.level = 0;
  }

  @Builder
  public TraceId(String id, int level) {
    this.id = id;
    this.level = level;
  }

  private String createId() {
    return UUID.randomUUID()
        .toString()
        .substring(0, 8);
  }

  public TraceId createNextId() {
    return TraceId.builder()
        .id(id)
        .level(level + 1)
        .build();
  }

  public TraceId createPreviousId() {
    return TraceId.builder()
        .id(id)
        .level(level - 1)
        .build();
  }

  public boolean isFirstLevel() {
    return level == 0;
  }

  public String id() {
    return this.id;
  }

  public int level() {
    return this.level;
  }
}
