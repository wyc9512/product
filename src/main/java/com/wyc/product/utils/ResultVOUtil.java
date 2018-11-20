package com.wyc.product.utils;

import com.wyc.product.ObjectView.ResultVO;

/**
 * @author 文永川
 * @data 2018/10/12 19:30
 */
public class ResultVOUtil {
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMsg("成功");
        return  resultVO;
    }
    public static  ResultVO success(){
        return success(null);
    }
    public  static  ResultVO error(Integer code,String msg){
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        return  resultVO;
    }
}
