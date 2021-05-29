package pe.isil.persistence.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import pe.isil.domain.dto.Client;
import pe.isil.persistence.entity.Cliente;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mappings({
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "dni", target = "dni"),
            @Mapping(source = "nombres", target = "firstName"),
            @Mapping(source = "apellidos", target = "lastName"),
            @Mapping(source = "email", target = "email"),
    })

    Client toClient(Cliente cliente);

    List<Client> toClients(List<Cliente> clientes);


    @InheritInverseConfiguration
    @Mapping(target = "ordenList", ignore = true)
    Cliente toCliente (Client client);

}
