package com.wyc.product.service.impl;

import com.wyc.product.bean.ProductInfo;
import com.wyc.product.dao.ProductInfoRepository;
import com.wyc.product.dto.CartDTO;
import com.wyc.product.enums.ProductStatusEnum;
import com.wyc.product.enums.ResultEnum;
import com.wyc.product.exception.SellException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.wyc.product.service.ProductService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 文永川
 * @data 2018/10/11 18:01
 */
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductInfoRepository productInfoRepository;

    @Override
    public ProductInfo findOne(String productId) {

        return productInfoRepository.getOne(productId);
    }

    @Override
    public List<ProductInfo> findUpAll() {

        return productInfoRepository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public Page<ProductInfo> findAll(Pageable pageable) {
        return productInfoRepository.findAll(pageable);
    }

    @Override
    public ProductInfo save(ProductInfo productInfo) {
        return productInfoRepository.save(productInfo);
    }

    @Override
    @Transactional
    public void increaseStock(List<CartDTO> cartDTOList) {
        for(CartDTO cartDTO : cartDTOList){
            ProductInfo productInfo = productInfoRepository.getOne(cartDTO.getPoductId());
            if(productInfo == null) {
                throw  new SellException(ResultEnum.ORDER_NOT_EXIST);
            }
            Integer result = productInfo.getProductStock() + cartDTO.getProductQuantity();
            productInfo.setProductStock(result);
            productInfoRepository.save(productInfo);
        }
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
        for (CartDTO cartDTO : cartDTOList){
         ProductInfo productInfo = productInfoRepository.getOne(cartDTO.getPoductId());
         if(productInfo == null){
             throw  new SellException(ResultEnum.PRODUCT_NOT_EXIST);
         }
         Integer result = productInfo .getProductStock() - cartDTO.getProductQuantity();
         if(result<0){
             throw  new SellException(ResultEnum.PRODUCT_STOCK_RRROR);
         }
         productInfo.setProductStock(result);
         productInfoRepository.save(productInfo);
        }
    }
}
