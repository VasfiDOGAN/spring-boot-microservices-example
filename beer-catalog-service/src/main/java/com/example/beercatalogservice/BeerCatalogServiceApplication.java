package com.example.beercatalogservice;

import lombok.Data;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.stream.Stream;

@EnableDiscoveryClient
@SpringBootApplication
public class BeerCatalogServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerCatalogServiceApplication.class, args);
    }
}

@Data
@Entity
class Beer {

    // JPA requires a no-argument constructor
    public Beer() {
    }

    // Constructor with the name field
    public Beer(String name) {
        this.name = name;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Added generation strategy
    private Long id;

    private String name;
}

@RepositoryRestResource
interface BeerRepository extends JpaRepository<Beer, Long> {
}

@Component
class BeerInitializer implements CommandLineRunner {

    private final BeerRepository beerRepository;

    BeerInitializer(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    @Override
    public void run(String... args) {
        Stream.of("Kentucky Brunch Brand Stout", "Good Morning", "Very Hazy", "King Julius",
                        "Budweiser", "Coors Light", "PBR")
                .forEach(beer -> beerRepository.save(new Beer(beer)));

        beerRepository.findAll().forEach(System.out::println);
    }
}
