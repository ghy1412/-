package com.cn.mapper;

import com.cn.po.Orders;
import com.cn.po.OrdersEx;

import java.util.List;

public interface OrdersMapper {

    public List<OrdersEx> queryOrderTOUser();

    public List<Orders> queryOrderToUD();

    public List<Orders> queryOrderToUDI();
}


