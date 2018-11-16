package com.qu.Util;

import com.qu.Dto.BookDto;
import com.qu.Entity.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 96283 on 2018/11/12.
 */
public class ConvertUtil {

    public static List<BookDto> convertBookDto(List<Book> bookList){
        List<BookDto> bookDtoList = new ArrayList<BookDto>();
        for(Book book:bookList){
            BookDto bookDto = new BookDto();
            bookDto.setId(book.getId());
            bookDto.setName(book.getName());
            bookDto.setDescription(book.getDescription());
            bookDto.setKc(book.getKc());
            bookDto.setStatus(book.getStatus());
            bookDtoList.add(bookDto);
        }
        return  bookDtoList;
    }
}
