package me.hjhng.tracelog.trace.v0;

import org.springframework.stereotype.Service;

@Service
public class OrderV0Service {

  private final OrderV0Repository repository;

  public OrderV0Service(OrderV0Repository repository) {
    this.repository = repository;
  }

  public void orderItem(String itemId) {
    repository.save(itemId);
  }
}
