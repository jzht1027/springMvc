package com.util;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

public class MyConverter implements Converter<String, Date> {

    public Date convert(String source) {
        try {
            if (Pattern.matches("^\\d{4}[-]\\d{1,2}[-]\\d{1,2}$", source)) {
                //匹配yyyy-MM-dd
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                return dateFormat.parse(source);
            } else if (Pattern.matches("^\\d{4}[/]\\d{1,2}[/]\\d{1,2}$", source)) {
                //匹配yyyy/MM/dd
                DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
                return dateFormat.parse(source);
            } else {
                System.out.println("不支持此类型:" + source);
            }
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return null;
    }
}
