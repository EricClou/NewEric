package com.mmall.controller.portal;

import com.mmall.commons.ServerResponse;
import com.mmall.service.IProductService;
import com.mmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "productController")
public class ProductController {

    @Autowired
    public IProductService iProductService;


    /**
     * 这里不需要验证是否登陆了，因为按照习惯，游客也应该能看到产品的信息
     * 这个方法是查看某个产品具体的数据
     *
     * @param productId
     * @return
     */
    @RequestMapping("/detail")
    @ResponseBody
    public ServerResponse <ProductDetailVo> detail ( Integer productId ) {
        return iProductService.getDetailInfo(productId);
    }





}
