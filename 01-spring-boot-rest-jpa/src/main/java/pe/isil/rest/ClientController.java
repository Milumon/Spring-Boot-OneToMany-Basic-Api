package pe.isil.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.isil.domain.dto.Client;
import pe.isil.domain.service.ClientService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/api/clients")
public class ClientController {

    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Client>> getAll(){
        return new ResponseEntity<>(clientService.getAll(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<Client> save(@RequestBody Client client){
        return new ResponseEntity<Client>(clientService.save(client), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> getClientById(@PathVariable Integer id){

        return clientService.getClient(id)
                .map(ResponseEntity::ok)
                .orElse(new ResponseEntity<Client>(NOT_FOUND));

        /* Optional<Client> opt = clientService.getClient(id);
        Optional<Client> opt =  clientService.getClient(id);
        System.out.println("ENTRÓ");
        return opt.map(ResponseEntity::ok); */

        // opt.map(ResponseEntity::ok).get().getBody()
        // return opt.map(ResponseEntity::ok);
        // <ResponseEntity<Client>>(clientService.getClient(id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id){
        clientService.delete(id);
        return new ResponseEntity<>("Se borró", HttpStatus.CREATED);
    }


}