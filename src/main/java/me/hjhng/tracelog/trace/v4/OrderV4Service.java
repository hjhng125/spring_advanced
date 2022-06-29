package me.hjhng.tracelog.trace.v4;

import org.springframework.stereotype.Service;

import me.hjhng.tracelog.trace.LogTrace;
import me.hjhng.tracelog.trace.template.AbstractTemplate;

@Service
public class OrderV4Service {

  private final OrderV4Repository repository;

  private final LogTrace trace;

  public OrderV4Service(OrderV4Repository repository, LogTrace trace) {
    this.repository = repository;
    this.trace = trace;
  }

  public void orderItem(String itemId) {
    AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {

      @Override
      protected Void call() {
        repository.save(itemId);
        return null;
      }
    };
    template.execute("OrderV4Service.orderItem");
  }
}
