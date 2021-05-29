package pe.isil.persistence.crud;

import org.springframework.data.repository.CrudRepository;
import pe.isil.persistence.entity.Orden;

import java.util.List;

public interface OrdenCrudRepository extends CrudRepository<Orden, Integer> {

    List<Orden> findByIdClienteOrderByCantidadAsc(Integer idCliente);


}
