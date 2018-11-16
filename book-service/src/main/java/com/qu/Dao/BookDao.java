package com.qu.Dao;

import com.qu.Dto.BookDto;
import com.qu.Dto.BookSearchDto;
import com.qu.Entity.Book;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import team.sidc.sttp.common.mybatis.dao.BasicCrudDao;
import java.util.List;

/**
 * Created by 96283 on 2018/11/12.
 */
@Mapper
public interface BookDao extends BasicCrudDao<Book>{
    public void insertBook(@Param("bookDto")BookDto bookDto);
    public void deleteBook(@Param("id")int id);
    public List<Book> getBooks(@Param("booksearchDto") BookSearchDto bookSearchDto);
    public void update(@Param("bookDto")BookDto bookDto);
}
