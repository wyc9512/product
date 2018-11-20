package com.wyc.product.dao;

import com.wyc.product.bean.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 文永川
 * @data 2018/10/12 16:20
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail,String > {
    List<OrderDetail> findByOrderId(String orderId);
}
