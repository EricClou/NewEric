package com.mmall.service;

import com.mmall.commons.ServerResponse;
import com.mmall.vo.ProductDetailVo;

public interface IProductService {

    public ServerResponse<ProductDetailVo> getDetailInfo(Integer productId);
}
