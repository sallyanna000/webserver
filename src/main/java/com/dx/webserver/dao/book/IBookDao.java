package com.dx.webserver.dao.book;

import com.dx.webserver.entity.model.book.Book;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description book数据处理层接口
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 15:19
 */
@Repository
public interface IBookDao {

    List<Book> getAll();

    Book getById(int id);

    List<Book> getByName(String name);

    int insert(Book book);

    int update(Book book);

    int delete(int id);

}
