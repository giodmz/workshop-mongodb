package com.giodmz.workshopmongo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.giodmz.workshopmongo.domain.Post;
import com.giodmz.workshopmongo.domain.User;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Builder
public class CommentDTO implements Serializable {

    private String id;
    private String text;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
    private LocalDateTime date;
    private AuthorDTO author;


}
