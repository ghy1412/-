package com.bit.itemslist.controller;

import com.bit.itemslist.po.Items;
import com.bit.itemslist.service.ItemsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class ItemsController  {

  @Autowired
    private  ItemsServiceImpl itemsService;
    @ResponseBody
    @RequestMapping("/queryItems")
    public void queryItmes(HttpServletRequest request,
                           HttpServletResponse response) throws ServletException, IOException {
        List<Items> items = itemsService.queryItemsList();

        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemsList",items);
        modelAndView.setViewName("showitems.jsp");

    }

}
