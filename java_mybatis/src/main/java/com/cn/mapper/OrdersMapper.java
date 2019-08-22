package com.cn.mapper;

import com.cn.po.Orders;

import java.util.List;

public interface OrdersMapper {
  List<Orders> lazyLoadUser();
}
