package com.wyc.product.controller;

import com.wyc.product.ObjectView.ResultVO;
import com.wyc.product.converter.OrderFormOrderDTOconverter;
import com.wyc.product.dto.OrderDTO;
import com.wyc.product.enums.ResultEnum;
import com.wyc.product.exception.SellException;
import com.wyc.product.form.OrderForm;
import com.wyc.product.service.BuyerService;
import com.wyc.product.service.OrderService;
import com.wyc.product.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 文永川
 * @data 2018/10/15 23:47
 */
@RestController
@RequestMapping("/buyer/order")
@Slf4j
public class BuyerOrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private BuyerService buyerService;
    //创建订单
    @PostMapping ("/create")
    public ResultVO<Map<String,String>> create(@Valid OrderForm orderForm,
                                               BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            log.error("【创建订单】参数不正确，orderForm={}",orderForm);
            throw new SellException(ResultEnum.PARAM_ERROR.getCode(),
                    bindingResult.getFieldError().getDefaultMessage());
        }
        OrderDTO orderDTO = OrderFormOrderDTOconverter.convert(orderForm);
        if(CollectionUtils.isEmpty(orderDTO.getOrderDetailList())){
            log.error("【穿件订单】购物车不能为空");
            throw new SellException(ResultEnum.CART_EMPTY);
        }
        OrderDTO createResult = orderService.create(orderDTO);
        Map<String ,String > map = new HashMap<>();
        map.put("orderId",createResult.getOrderId());
        return ResultVOUtil.success(map);
    }
    //订单列表
    @GetMapping("/list")
    public ResultVO<List<OrderDTO>>  list(@RequestParam("openid")String openid,
                                          @RequestParam(value="page",defaultValue = "0")Integer page,
                                          @RequestParam(value = "size",defaultValue = "10")Integer size){
        if (StringUtils.isEmpty(openid)){
            log.error("【查询订单列表】openid为空");
            throw  new SellException(ResultEnum.PARAM_ERROR);
        }
        PageRequest request = PageRequest.of(page,size);
        Page<OrderDTO> orderDTOPage = orderService.findList(openid,request);
        return ResultVOUtil.success(orderDTOPage.getContent());
    }
    //订单详情
    @GetMapping("/detail")
    public ResultVO<OrderDTO> detail(@RequestParam("openid")String openid,
                                     @RequestParam("orderid")String orderid){
       OrderDTO orderDTO = buyerService.findOrderOne(openid, orderid);
        return  ResultVOUtil.success(orderDTO);
    }
    //取消订单
    @PostMapping("/cancel")
    public ResultVO cancel(@RequestParam("openid")String openid,
                           @RequestParam("orderid")String orderid){
        buyerService.cancelOrderOne(openid, orderid);
        return  ResultVOUtil.success();
    }
}
