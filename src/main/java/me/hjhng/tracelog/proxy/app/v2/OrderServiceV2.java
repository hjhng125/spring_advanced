package me.hjhng.tracelog.proxy.app.v2;

import me.hjhng.tracelog.proxy.app.v1.OrderRepositoryV1;
import me.hjhng.tracelog.proxy.app.v1.OrderServiceV1;

public class OrderServiceV2 {

  private final OrderRepositoryV2 repository;

  public OrderServiceV2(OrderRepositoryV2 repository) {
    this.repository = repository;
  }

  public void orderItem(String itemId) {
    repository.save(itemId);
  }
}
