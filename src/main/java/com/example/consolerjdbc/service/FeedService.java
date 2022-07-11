package com.example.consolerjdbc.service;

import com.example.consolerjdbc.model.Feed;
import com.example.consolerjdbc.repository.FeedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FeedService {

    private final FeedRepository feedRepository;

    @Autowired
    public FeedService(FeedRepository feedRepository) {
        this.feedRepository = feedRepository;
    }

    public Optional<Feed> getFeed(int id) {
        return feedRepository.findById(id);
    }

    public Feed saveFeed(Feed feed) {
        return feedRepository.save(feed);
    }

    public void removeFeed(int id) {
        feedRepository.deleteById(id);
    }

}
