package pe.isil.rest;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.domain.dto.Client;
import pe.isil.domain.dto.Order;
import pe.isil.domain.service.OrderService;
import pe.isil.persistence.entity.Orden;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/orders")
public class OrderController {


    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Order>> getAll(){
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Order> save(@RequestBody Order order){
        return new ResponseEntity<Order>(orderService.save(order), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getClientById(@PathVariable Integer id){

        return orderService.getOrder(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<Order>(NOT_FOUND));
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id){
        orderService.delete(id);
        return new ResponseEntity<>("Se borró", HttpStatus.CREATED);
    }

    @GetMapping("/client/{id}")
    public ResponseEntity<List<Order>> getOrderByClient(@PathVariable Integer id){
        System.out.println("GAAAAAAAAAAAAAAAAAAAAAAAAAA"+ id);
        return orderService.getByClient(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<>(NOT_FOUND));
    }



}