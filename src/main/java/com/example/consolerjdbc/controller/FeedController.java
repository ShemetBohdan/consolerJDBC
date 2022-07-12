package com.example.consolerjdbc.controller;

import com.example.consolerjdbc.model.Feed;
import com.example.consolerjdbc.service.FeedService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@Controller
@RequestMapping("/feed")
public class FeedController {

    private final FeedService feedService;

    public FeedController(FeedService feedService) {
        this.feedService = feedService;
    }

    @GetMapping(value = "/{id}",produces = "application/json")
    public @ResponseBody Feed get(@PathVariable Integer id) {
        System.out.println(id);
        return this.feedService.getFeed(id).orElseThrow(()-> new ResponseStatusException(
                HttpStatus.NOT_FOUND,"feed is not found"));
    }

    @PostMapping(produces = "application/json")
    public @ResponseBody Feed updateFeed(@RequestBody Feed feed) {
        System.out.println(feed);
        return Feed.builder().feedName("update name").build();
    }

    @PutMapping(produces = "aplication/json")
    public @ResponseBody Feed saveFeed(@RequestBody Feed feed) {
        System.out.println(feed);
        return this.feedService.saveFeed(feed);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public Feed deleteFeed(@PathVariable Integer id) {
        if (id == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Not found");
        }
        System.out.println("removing feed number whith id:" + id);
       return this.feedService.removeFeed(id);
    }

    @ExceptionHandler({NullPointerException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public @ResponseBody String handleException() {
        return "not working";
    }
}
