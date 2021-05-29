package pe.isil.persistence.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import pe.isil.domain.dto.Client;
import pe.isil.domain.repository.ClientRepository;
import pe.isil.persistence.crud.ClienteCrudRepository;
import pe.isil.persistence.entity.Cliente;
import pe.isil.persistence.mapper.ClientMapper;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Repository
public class ClienteRepository implements ClientRepository {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;

    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<Client> getAll() {
        List<Cliente> clientes = (List<Cliente>) clienteCrudRepository.findAll();
        return clientMapper.toClients(clientes);
    }

    @Override
    public Optional<Client> getClient(int clientId) {
        return clienteCrudRepository.findById(clientId)
                .map(clientMapper::toClient);
    }

    @Override
    public Client save(Client client) {
        Cliente cliente = clientMapper.toCliente(client);
        return clientMapper.toClient(clienteCrudRepository.save(cliente));
    }

    @Override
    public void delete(int clientId) {
        clienteCrudRepository.deleteById(clientId);
    }

}
