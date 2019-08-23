package com.bit.itemslist.service;

import com.bit.itemslist.dao.ItemsDao;
import com.bit.itemslist.po.Items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ItemsServiceImpl implements ItemsService {
    @Autowired
    private ItemsDao itemsDao;

    @Override
    public List<Items> queryItemsList() {
        return  itemsDao.queryItems();
    }
}
