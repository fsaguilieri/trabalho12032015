package br.unicesumar.restserver;

import br.unicesumar.restserver.disciplina.DisciplinaRepositoryInMemory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;



@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public DisciplinaRepositoryInMemory criaRepositorio(){
        return new DisciplinaRepositoryInMemory();
    }
}
