package com.example.dao;

import com.example.model.Book;
import com.example.model.News;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewsMapper {

    @Select("SELECT * FROM NEWS")
        //SQL
    List<News> findAll();

    @Select("SELECT * FROM NEWS WHERE TITLE like CONCAT('%',#{title},'%')")
    List<News> findByTitle(@Param("title") String title);

    @Select("SELECT * FROM NEWS WHERE ID = #{id}")
    News findById(@Param("id") int id);

    @Insert("INSERT INTO NEWS (TITLE,AUTHOR,PUBLISH_DATE,DESCRIPTION,CONTENT,IMAGE) VALUES(#{title},#{author},#{publishDate},#{description},#{content},#{image})")
    void insertNews(News news);

}
