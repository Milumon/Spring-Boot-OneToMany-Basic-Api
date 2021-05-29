package pe.isil.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pe.isil.domain.dto.Order;
import pe.isil.persistence.entity.Orden;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ClientMapper.class})
public interface OrderMapper {

    @Mappings({

        @Mapping(source= "idOrden", target= "orderId"),
        @Mapping(source= "producto", target= "product"),
        @Mapping(source= "cantidad", target= "quantity"),
        @Mapping(source= "precio", target= "price"),
        @Mapping(source= "idCliente", target= "clientId"),
        @Mapping(source= "cliente", target= "client"),
    })
    Order toOrder(Orden orden);
    List<Order> toOrders(List<Orden> ordenList);

    @InheritInverseConfiguration
    Orden toOrden(Order order);


}
