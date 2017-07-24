package com.dx.webserver.service.book.impl;

import com.dx.webserver.dao.book.IBookDao;
import com.dx.webserver.entity.model.book.Book;
import com.dx.webserver.service.book.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description 书本业务层接口实现类
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 15:42
 */
@Service("bookService")
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookDao bookDao;

    @Override
    public List<Book> getAll() {
        return bookDao.getAll();
    }

    @Override
    public Book getById(int id) {
        return bookDao.getById(id);
    }

    @Override
    public List<Book> getByName(String name) {
        return bookDao.getByName(name);
    }

    @Override
    public int insert(Book book) {
        return bookDao.insert(book);
    }

    @Override
    public int update(Book book) {
        return bookDao.update(book);
    }

    @Override
    public int delete(int id) {
        return bookDao.delete(id);
    }
}
