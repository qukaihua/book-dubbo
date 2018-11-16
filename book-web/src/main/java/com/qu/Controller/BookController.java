package com.qu.Controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qu.Dto.BookDto;
import com.qu.Dto.BookSearchDto;
import com.qu.Dto.CaptchaDto;
import com.qu.Dto.Result;
import com.qu.Service.BookService;
import com.qu.Service.CaptchaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Pageable;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * Created by 96283 on 2018/11/9.
 */
@RestController
@RequestMapping("/book")
@Api(tags={"图书管理接口"})
public class BookController {

    @Reference(interfaceClass = BookService.class)
    BookService bookService;
    @Reference(interfaceClass = CaptchaService.class)
    CaptchaService captchaService;

    @ApiOperation(value = "新增图书",notes = "新增图书")
    @RequestMapping(value ="/insert",method = RequestMethod.POST)
    public Result insert(@ApiParam("图书dto")@RequestBody BookDto bookDto){
       bookService.insertBook(bookDto);
       return Result.success();
    }

    @ApiOperation(value = "删除图书",notes = "删除图书")
    @RequestMapping(value ="/delete",method = RequestMethod.GET)
    public Result delete(@ApiParam("图书id") @RequestParam("id")int id){
        bookService.deleteBook(id);
        return Result.success();
    }

    @ApiOperation(value = "更新图书",notes = "更新图书")
    @RequestMapping(value ="/update",method = RequestMethod.POST)
    public Result update(@ApiParam("图书Dto") BookDto bookDto){
        bookService.updateBook(bookDto);
        return Result.success();
    }

    @ApiOperation(value = "获取图书",notes = "获取图书")
    @RequestMapping(value ="/getbooks",method = RequestMethod.POST)
    public Result getBooks(@ApiParam("图书查询")BookSearchDto bookSearchDto,int page,int rows,String orderby,String seq){
        List<BookDto> bookDtoList = bookService.getBooks(bookSearchDto,page,rows,orderby,seq);
        /*List<BookDto> bookDtoList = bookService.getBooks(bookSearchDto,pageable);*/
        return Result.success(bookDtoList);
    }

    @RequestMapping(value = "/getCaptchaCode",method =RequestMethod.GET)
    public void getCaptchaCode(HttpServletRequest request, HttpServletResponse response){
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/gif");
        CaptchaDto captchaDto = captchaService.getCaptcha();
        request.getSession().setAttribute("cap",captchaDto.getText());
        byte[] bytes = captchaDto.getBytes();
        try {
            ServletOutputStream out = response.getOutputStream();
            out.write(bytes);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
