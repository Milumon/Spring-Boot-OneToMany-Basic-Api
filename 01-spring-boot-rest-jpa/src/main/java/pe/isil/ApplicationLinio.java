package pe.isil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.isil.persistence.crud.ClienteCrudRepository;
import pe.isil.persistence.entity.Cliente;

@SpringBootApplication
public class ApplicationLinio  implements CommandLineRunner {

    @Autowired
    private ClienteCrudRepository clienteCrudRepository;


    public static void main(String[] args) {
        SpringApplication.run(ApplicationLinio.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Cliente cliente = new Cliente();
        cliente.setDni("70604256");
        cliente.setNombres("Miluska");
        cliente.setApellidos("Romero");
        cliente.setEmail("Milumon@outlook.com");
        clienteCrudRepository.save(cliente);

    }

}
