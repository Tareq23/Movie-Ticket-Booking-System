package com.tareq23.movieticket.document;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "movie")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDocument {

    @Id
    private String id;

    private String title;

    private String description;

    private String genre;

}
