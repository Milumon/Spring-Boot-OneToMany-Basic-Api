package pe.isil.domain.repository;

import pe.isil.domain.dto.Order;

import java.util.List;
import java.util.Optional;

public interface OrderRepository {

    List<Order> getAll();
    Optional<Order> getOrder(int orderId);
    Optional<List<Order>> getByClient(int clientId);
    Order save(Order order);
    void delete(int orderId);
    
}
