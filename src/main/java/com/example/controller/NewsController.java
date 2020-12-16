package com.example.controller;

import com.example.dao.NewsMapper;
import com.example.model.Book;
import com.example.model.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class NewsController {
    @Autowired
    private NewsMapper newsMapper;

    @RequestMapping(value = "/news", method = RequestMethod.GET)
    public List<News> getNews() {
        List<News> news = newsMapper.findAll();
        return news;
    }

    @RequestMapping(value = "/news/{title}", method = RequestMethod.GET)
    public List<News> bookByTitle(@PathVariable("title") String title) {
        return newsMapper.findByTitle(title);
    }

    @RequestMapping(value = "/news", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public News addBook(@RequestBody News news) {
        if (news.getTitle() == null || news.getTitle().length() == 0) {
            throw new RuntimeException("Title cannot empty");
        }
        if (news.getContent() == null || news.getContent().length() == 0) {
            throw new RuntimeException("Content cannot empty");
        }
        if (newsMapper.findByTitle(news.getTitle()).size() > 0) {
            throw new RuntimeException("Title already exists");
        }
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        news.setPublishDate(dateFormat.format(date));
        newsMapper.insertNews(news);
        return newsMapper.findByTitle(news.getTitle()).get(0);
    }
}
