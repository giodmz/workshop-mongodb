package com.giodmz.workshopmongo.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.giodmz.workshopmongo.dto.AuthorDTO;
import com.giodmz.workshopmongo.dto.CommentDTO;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Document
public class Post implements Serializable {

    @Id
    private String id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;

    private String title;
    private String body;
    private AuthorDTO author;

    @Builder
    public Post(AuthorDTO author, String body, LocalDateTime date, String id, String title) {
        this.author = author;
        this.body = body;
        this.date = date;
        this.id = id;
        this.title = title;
    }

    private List<CommentDTO> comments = new ArrayList<>();

}
