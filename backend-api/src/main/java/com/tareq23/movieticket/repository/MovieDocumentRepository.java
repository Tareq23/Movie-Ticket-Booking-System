package com.tareq23.movieticket.repository;

import com.tareq23.movieticket.document.MovieDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MovieDocumentRepository extends ElasticsearchRepository<MovieDocument, String> {
}
