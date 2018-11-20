package com.wyc.product.dao;

import com.wyc.product.bean.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author 文永川
 * @data 2018/10/12 16:15
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster,String > {
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
