package com.qu.ServiceImpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.google.code.kaptcha.Producer;
import com.qu.Dto.CaptchaDto;
import com.qu.Service.CaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by 96283 on 2018/11/16.
 */
@Component
@Service(interfaceClass = CaptchaService.class)
public class CaptchaServiceImpl implements CaptchaService {

    @Autowired
    Producer cProducer;

    @Override
    public CaptchaDto getCaptcha() {
        CaptchaDto captchaDto = new CaptchaDto();
        String text = cProducer.createText();
        captchaDto.setText(text);
        BufferedImage bi = cProducer.createImage(text);
        byte[] bytes = new byte[0];
        try {
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ImageIO.write(bi,"gif",out);
             bytes = out.toByteArray();
            captchaDto.setBytes(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }

       return  captchaDto;

    }
}
