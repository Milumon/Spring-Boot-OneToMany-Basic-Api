package pe.isil.domain.repository;

import pe.isil.domain.dto.Client;

import java.util.List;
import java.util.Optional;

public interface ClientRepository {

    List<Client> getAll();
    Optional<Client> getClient(int clientId);
    Client save(Client client);
    void delete(int clientId);
    
}
