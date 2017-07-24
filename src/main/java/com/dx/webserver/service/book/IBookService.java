package com.dx.webserver.service.book;

import com.dx.webserver.entity.model.book.Book;

import java.util.List;

/**
 * @Description
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 15:41
 */
public interface IBookService {

    List<Book> getAll();

    Book getById(int id);

    List<Book> getByName(String name);

    int insert(Book book);

    int update(Book book);

    int delete(int id);
}
