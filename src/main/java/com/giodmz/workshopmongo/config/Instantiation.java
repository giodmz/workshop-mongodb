package com.giodmz.workshopmongo.config;

import com.giodmz.workshopmongo.domain.User;
import com.giodmz.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Instantiation implements CommandLineRunner {

    // instanciando objetos e salvando no db
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        // limpar a collection
        userRepository.deleteAll();

        User makoto = User.builder().name("Makoto Yuki").email("yukimakoto@gmail.com").build();
        User snake = User.builder().name("Solid Snake").email("invisible@gmail.com").build();
        User decau = User.builder().name("Decau Imenso").email("16toneladas@gmail.com").build();

        userRepository.save(makoto);
        userRepository.save(decau);
        userRepository.save(snake);
    }
}
