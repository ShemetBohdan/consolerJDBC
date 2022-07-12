package com.example.consolerjdbc.service;

import com.example.consolerjdbc.model.Feed;
import com.example.consolerjdbc.repository.FeedRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

public class FeedServiceTest {

    private FeedRepository feedRepository = Mockito.mock(FeedRepository.class);

    private final FeedRepository spy = Mockito.spy(feedRepository);

    private final FeedService feedService = new FeedService(feedRepository);

    @Test
    public void saveFeedTest() {

        Mockito.when(feedRepository.save(Mockito.any()))
                .thenReturn(Feed.builder().feedName("cat paws").build());

        Assertions.assertEquals("cat paws", feedService
                .saveFeed(Feed.builder().feedName("cat cool").build()).getFeedName());
    }

    @Test
    public void saveFeedParametrTest() {

        Feed catFeed = Feed.builder().feedName("cat paws").build();
        Feed dogFeed = Feed.builder().feedName("dog paws").build();

        Mockito.when(feedRepository.save(Mockito.any())).thenReturn(dogFeed);

        Feed feed = feedService.saveFeed(catFeed);

        Assertions.assertNotEquals(feed, catFeed);
        Assertions.assertEquals(feed, dogFeed);

        Mockito.verify(feedRepository).save(catFeed);
    }

    @Test
    public void getFeedTest() {

        Feed catFeed = Feed.builder().feedName("cat paws").feedId(1).build();

        Mockito.when(feedRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(catFeed));

        Assertions.assertEquals(catFeed, feedService.getFeed(Mockito.anyInt()).orElse(null));
        Assertions.assertNotEquals(Feed.builder().feedName("dogFeed").build(),
                feedService.getFeed(Mockito.anyInt()).orElse(catFeed));
    }

    @Test
    public void removeFeedTest() {

        Feed catFeed = Feed.builder().feedName("cat paws").feedId(1).build();

        Mockito.when(feedRepository.deleteById(Mockito.anyInt())).thenReturn(catFeed);

        Assertions.assertEquals(catFeed, feedService.removeFeed(Mockito.anyInt()));
        Assertions.assertNotEquals(Feed.builder().feedName("cat paws").build(),
                feedService.removeFeed((Mockito.anyInt())));
    }

}
