package com.qu.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.PageHelper;
import com.qu.Dao.BookDao;
import com.qu.Dto.BookDto;
import com.qu.Dto.BookSearchDto;
import com.qu.Entity.Book;
import com.qu.Service.BookService;
import com.qu.Util.ConvertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;


import java.util.List;

/**
 * Created by 96283 on 2018/11/9.
 */
@Component
@Service(interfaceClass = BookService.class)
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;

    @Override
    public void insertBook(BookDto bookDto) {
          bookDao.insertBook(bookDto);
    }

    @Override
    public void deleteBook(int id) {
          bookDao.deleteBook(id);
    }

    @Override
    public void updateBook(BookDto bookDto) {
           bookDao.update(bookDto);
    }

    @Override
    public List<BookDto> getBooks(BookSearchDto bookSearchDto,int page,int rows,String orderby,String seq)
    {
        String orderBy = ""+seq+" "+orderby+"";
        PageHelper.startPage(page,rows,orderBy);
        List<Book> pagebooks = bookDao.getBooks(bookSearchDto);
        List<BookDto> bookDtoList = ConvertUtil.convertBookDto(pagebooks);
        return  bookDtoList;
    }
}
