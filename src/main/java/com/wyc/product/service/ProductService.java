package com.wyc.product.service;

import com.wyc.product.bean.ProductInfo;
import com.wyc.product.dto.CartDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @author 文永川
 * @data 2018/10/11 17:55
 */
public interface ProductService {
    ProductInfo findOne(String productId);

    /**
     * 查询所有的商品列表
     * @return
     */
    List<ProductInfo> findUpAll();

    /*Pageable分页*/
    Page<ProductInfo> findAll(Pageable pageable);

    ProductInfo save(ProductInfo productInfo);

    //加库存
    void increaseStock(List<CartDTO> cartDTOList);

    //减库存
    void decreaseStock(List<CartDTO> cartDTOList);

}
