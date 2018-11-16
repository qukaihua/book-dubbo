package com.qu.Service;

import com.qu.Dto.BookDto;
import com.qu.Dto.BookSearchDto;

import java.util.List;
import org.springframework.data.domain.Pageable;

/**
 * Created by 96283 on 2018/11/9.
 */

public interface BookService {
    public void insertBook(BookDto book);
    public void deleteBook(int id);
    public void updateBook(BookDto book);
    public List<BookDto> getBooks(BookSearchDto bookSearchDto,int page,int rows,String orderby,String seq);
}
