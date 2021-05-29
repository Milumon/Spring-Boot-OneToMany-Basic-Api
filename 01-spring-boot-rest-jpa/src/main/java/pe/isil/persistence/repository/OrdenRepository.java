package pe.isil.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pe.isil.domain.dto.Order;
import pe.isil.domain.repository.OrderRepository;
import pe.isil.persistence.crud.OrdenCrudRepository;
import pe.isil.persistence.entity.Orden;
import pe.isil.persistence.mapper.OrderMapper;

import java.util.List;
import java.util.Optional;

@Repository
public class OrdenRepository implements OrderRepository {

    @Autowired
    private OrdenCrudRepository ordenCrudRepository;

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> getAll() {
        List<Orden> ordenList = (List<Orden>) ordenCrudRepository.findAll();
        return orderMapper.toOrders(ordenList);
    }

    @Override
    public Optional<Order> getOrder(int orderId) {
        return ordenCrudRepository.findById(orderId)
                .map(orderMapper::toOrder);
    }

    @Override
    public Optional<List<Order>> getByClient(int clientId) {
        List<Orden> orders = ordenCrudRepository.findByIdClienteOrderByCantidadAsc(clientId);
        return Optional.of(orderMapper.toOrders(orders));
    }

    @Override
    public Order save(Order order) {
        Orden orden = orderMapper.toOrden(order);
        return orderMapper.toOrder(ordenCrudRepository.save(orden));
    }

    @Override
    public void delete(int orderId) {
        ordenCrudRepository.deleteById(orderId);
    }

}
