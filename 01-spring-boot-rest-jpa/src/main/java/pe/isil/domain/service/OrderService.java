package pe.isil.domain.service;

import org.springframework.stereotype.Service;
import pe.isil.domain.dto.Order;
import pe.isil.domain.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAll(){
        return orderRepository.getAll();
    }

    public Optional<List<Order>> getByClient(int clientId){
        return orderRepository.getByClient(clientId);
    }


    public Optional<Order> getOrder(int orderId){
        return orderRepository.getOrder(orderId);
    }

    public Order save(Order order){
        return orderRepository.save(order);
    }

    public boolean delete(int orderId){
        return getOrder(orderId)
                .map( order -> {
                    orderRepository.delete(orderId);
                    return true;
                }).orElse(false);
    }
    
}
