package com.giodmz.workshopmongo.config;

import com.giodmz.workshopmongo.domain.Post;
import com.giodmz.workshopmongo.domain.User;
import com.giodmz.workshopmongo.dto.AuthorDTO;
import com.giodmz.workshopmongo.dto.CommentDTO;
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

        for (User user : Arrays.asList(makoto, decau, snake)) {
            userRepository.save(user);
        }

        Post post1 = Post.builder().title("Tartarus hoje.")
                .body("Na hora da dark hour")
                .date(now)
                .author(new AuthorDTO(makoto))
                .build();
        Post post2 = Post.builder().title("Persona")
                .body("Persona 5 é o melhor jogo que já joguei na vida")
                .date(now)
                .author(new AuthorDTO(makoto))
                .build();



        CommentDTO comment1 = CommentDTO.builder().text("Bora!")
                .date(LocalDateTime.now())
                .author(new AuthorDTO(snake))
                .build();
        CommentDTO comment2 = CommentDTO.builder().text("SMT - Shin Megami Tensei!!")
                .date(LocalDateTime.now())
                .author(new AuthorDTO(decau))
                .build();
        CommentDTO comment3 = CommentDTO.builder().text("INVISIBLE")
                .date(LocalDateTime.now())
                .author(new AuthorDTO(snake))
                .build();

//        for (CommentDTO comment : Arrays.asList(comment1, comment2, comment3)) {
//            postRepository.save(comment);
//        }

        makoto.getPosts().add(post1);
        makoto.getPosts().add(post2);

        post1.getComments().add(comment1);
        post1.getComments().add(comment2);
        post1.getComments().add(comment3);

        // salvando na db
        for (Post post : Arrays.asList(post1, post2)) {
            postRepository.save(post);
        }


        userRepository.save(makoto);

    }
}
