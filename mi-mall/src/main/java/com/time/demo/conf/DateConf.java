package com.time.demo.conf;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.time.demo.util.DateUtil;

@Component
public class DateConf{
	@Bean
    public Converter<String, Date> dateConverter() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                if (StringUtils.isEmpty(source))
                    return null;
                else
                    return DateUtil.parse(source, "yyyy-MM-dd");
            }
        };
    }


}
