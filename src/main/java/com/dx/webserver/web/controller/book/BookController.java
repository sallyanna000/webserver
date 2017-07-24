package com.dx.webserver.web.controller.book;

import com.dx.webserver.common.log.BaseLogger;
import com.dx.webserver.entity.model.book.Book;
import com.dx.webserver.service.book.IBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @Description 书本处理Controller
 * @Project webserver
 * @Author duxiang
 * @Time 2017/7/16 15:48
 */
@Api(value = "bookAPI", description = "书籍相关接口")
@RestController
@RequestMapping("/book")
public class BookController extends BaseLogger {

    @Autowired
    private IBookService bookService;

    @ApiOperation(notes = "查询所有的书本信息", value = "find all books", httpMethod = "GET")
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public PageInfo<Book> getAll(@RequestParam(value = "pageNum", required = false, defaultValue = "1") Integer pageNum,
                                 @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        if (null != pageNum && null != pageSize) {
            PageHelper.startPage(pageNum, pageSize);
        }
        return new PageInfo<>(bookService.getAll());
    }

    @ApiOperation(notes = "根据ID查询书本信息", value = "find by id", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Book getById(@PathVariable Integer id) {
        return bookService.getById(id);
    }

    @ApiOperation(notes = "增加书本信息", value = "add a book", httpMethod = "POST")
    @RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity add(@RequestBody Book book) {
        bookService.insert(book);
        return new ResponseEntity("Book added successfully", HttpStatus.OK);
    }

    @ApiOperation(notes = "删除书本信息", value = "delete a book", httpMethod = "DELETE")
    @RequestMapping(value="/delete/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity delete(@PathVariable Integer id){
        bookService.delete(id);
        return new ResponseEntity("BookType deleted successfully", HttpStatus.OK);
    }

    @ApiOperation(notes = "修改书本信息", value = "update a book", httpMethod = "PUT")
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateProduct(@PathVariable Integer id, @RequestBody Book book){
        Book oldBook = bookService.getById(id);
        oldBook.setName(book.getName());
        oldBook.setAuthor(book.getAuthor());
        oldBook.setPrice(book.getPrice());
        bookService.update(oldBook);
        return new ResponseEntity("Book updated successfully", HttpStatus.OK);
    }

}
