package com.giodmz.workshopmongo.config;

import com.giodmz.workshopmongo.domain.Post;
import com.giodmz.workshopmongo.domain.User;
import com.giodmz.workshopmongo.repository.PostRepository;
import com.giodmz.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


@Configuration
public class Instantiation implements CommandLineRunner {

    // instanciando objetos e salvando no db
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        // horario de greenwich

        // limpar a collection
        userRepository.deleteAll();
        postRepository.deleteAll();

        User makoto = User.builder().name("Makoto Yuki").email("yukimakoto@gmail.com").build();
        User snake = User.builder().name("Solid Snake").email("invisible@gmail.com").build();
        User decau = User.builder().name("Decau Imenso").email("16toneladas@gmail.com").build();

        Post post1 = Post.builder().title("Tartarus hoje.")
                .body("Na hora da dark hour")
                .date(now)
                .author(makoto)
                .build();
        Post post2 = Post.builder().title("Persona")
                .body("Persona 5 é o melhor jogo que já joguei na vida")
                .date(now)
                .author(makoto)
                .build();

        // salvando na db
        for (Post post : Arrays.asList(post1, post2)) {
            postRepository.save(post);
        }

        for (User user : Arrays.asList(makoto, decau, snake)) {
            userRepository.save(user);
        }

    }
}
