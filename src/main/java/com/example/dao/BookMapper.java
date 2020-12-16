package com.example.dao;

import com.example.model.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {

    @Select("SELECT * FROM BOOKS")
        //SQL
    List<Book> findAll();

    @Select("SELECT * FROM BOOKS WHERE ISBN = #{isbn}")
    List<Book> findByIsbn(@Param("isbn") String isbn);

    @Select("SELECT * FROM BOOKS WHERE ID = #{id}")
    Book findById(@Param("id") int id);

//    @Insert("INSERT INTO BOOKS (ISBN,TITLE,DESCRIPTION,AUTHOR_FIRST_NAME,AUTHOR_LAST_NAME,GENRE,PRICE) VALUES(#{isbn},#{title},#{description},#{authorFirstName},#{authorLastName},#{genre},#{price})")
//    void insertBook(@Param("isbn") String isbn, @Param("title") String title, @Param("description") String description, @Param("authorFirstName") String authorFirstName, @Param("authorLastName") String authorLastName, @Param("genre") String genre, @Param("price") Double price);

    @Insert("INSERT INTO BOOKS (ISBN,TITLE,DESCRIPTION,AUTHOR_FIRST_NAME,AUTHOR_LAST_NAME,GENRE,PRICE) VALUES(#{isbn},#{title},#{description},#{authorFirstName},#{authorLastName},#{genre},#{price})")
    void insertBook(Book book);

    //    @Update("UPDATE BOOKS SET TITLE=#{title}, DESCRIPTION=#{description}, AUTHOR_FIRST_NAME=#{authorFirstName}, AUTHOR_LAST_NAME=#{authorLastName}, GENRE=#{genre}, PRICE=#{price} where ID=#{id})")
    @Update("UPDATE BOOKS SET DESCRIPTION=#{description} where ID=#{id})")
    void updateBook(@Param("description") String description, @Param("id") int id);

    @Delete("DELETE FROM BOOKS WHERE ID =#{id}")
    void deleteBook(int id);


//  CREATE TABLE IF NOT EXISTS BOOKS (
//      ID                  INT          NOT NULL  AUTO_INCREMENT PRIMARY KEY
//      ,ISBN               VARCHAR(13)  NOT NULL  CONSTRAINT books_isbn_uc UNIQUE
//  ,AUTHOR_FIRST_NAME  VARCHAR(255) NOT NULL
//  ,AUTHOR_LAST_NAME   VARCHAR(255) NOT NULL
//  ,TITLE              VARCHAR(255) NOT NULL
//  ,DESCRIPTION        VARCHAR(750) NOT NULL
//  ,GENRE	            VARCHAR(255) NOT NULL
//  ,PRICE              DOUBLE       NOT NULL
//  ,PUBLISHER          VARCHAR(255)
//  ,PUBLISHED_ON       DATE );

//  public class Book {
//    private Integer id;
//    private String isbn;
//    private String title;
//    private String description;
//    private String authorFirstName;
//    private String authorLastName;
//    private String genre;
//    private double price;
//    ...
}

