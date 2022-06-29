package me.hjhng.tracelog.v5;

import org.springframework.stereotype.Service;

import me.hjhng.tracelog.trace.LogTrace;
import me.hjhng.tracelog.trace.callback.TraceTemplate;
import me.hjhng.tracelog.trace.template.AbstractTemplate;

@Service
public class OrderV5Service {

  private final OrderV5Repository repository;

  private final TraceTemplate template;

  public OrderV5Service(OrderV5Repository repository, LogTrace trace) {
    this.repository = repository;
    this.template = new TraceTemplate(trace);
  }

  public void orderItem(String itemId) {
    template.execute("OrderV5Service.orderItem", () -> {
      repository.save(itemId);
      return null;
    });
  }
}
