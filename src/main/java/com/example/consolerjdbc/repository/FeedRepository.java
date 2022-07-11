package com.example.consolerjdbc.repository;

import com.example.consolerjdbc.model.Feed;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface FeedRepository extends CrudRepository<Feed,Integer> {

}
