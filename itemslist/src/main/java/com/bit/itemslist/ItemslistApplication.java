package com.bit.itemslist;

import com.bit.itemslist.po.Items;
import com.bit.itemslist.service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@SpringBootApplication
public class ItemslistApplication {

    public static void main(String[] args) {
        SpringApplication.run(ItemslistApplication.class, args);
    }

}
