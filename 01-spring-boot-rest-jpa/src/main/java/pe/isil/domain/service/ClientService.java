package pe.isil.domain.service;

import org.springframework.stereotype.Service;
import pe.isil.domain.dto.Client;
import pe.isil.domain.repository.ClientRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(int clientId){
        return clientRepository.getClient(clientId);
    }


    public Client save(Client client){
        return clientRepository.save(client);
    }

    public boolean delete(int clientId){
        return getClient(clientId)
                .map( client -> {
                    clientRepository.delete(clientId);
                    return true;
                }).orElse(false);
    }

    
}
