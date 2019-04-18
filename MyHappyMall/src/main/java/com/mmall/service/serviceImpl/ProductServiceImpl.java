package com.mmall.service.serviceImpl;

import com.mmall.commons.Const;
import com.mmall.commons.ResponseCode;
import com.mmall.commons.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.dao.ProductMapper;
import com.mmall.pojo.Category;
import com.mmall.pojo.Product;
import com.mmall.service.IProductService;
import com.mmall.utils.DateTimeUtil;
import com.mmall.utils.PropertiesUtil;
import com.mmall.vo.ProductDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("iProductService")
public class ProductServiceImpl implements IProductService {

    @Autowired
    public ProductMapper productMapper;
    @Autowired
    public CategoryMapper categoryMapper;

    @Override
    public ServerResponse <ProductDetailVo> getDetailInfo ( Integer productId ) {
        if (productId == null)
            return ServerResponse.createByErrorCodeMessage(ResponseCode.ILLEGAL_ARGUMENT.getCode(), ResponseCode.ILLEGAL_ARGUMENT.getDesc());
        Product product = productMapper.selectByPrimaryKey(productId);

        if (product == null) return ServerResponse.createByErrorMessage("产品已下架或删除");

        if (product.getStatus() != Const.ProductStatusEnum.ON_SALE.getCode())
            return ServerResponse.createByErrorMessage("产品已下架或者删除");

        ProductDetailVo productDetailVo = assembleProductDetailVo(product);
        return ServerResponse.createBySuccess(productDetailVo);

    }





    /**
     * 包装产品类
     *
     * 为什么我们需要包装类：
     * 因为直接从数据库返回出来的pojo类某些时候并不能提供我们所有功能的需求
     *
     * 比如我们在前台看到某个查询的结果，可能比普通的pojo类具备更多的属性或者更少的属性
     * 为了符合前台数据展示需求，所以封装一个新的vo类
     * @param product
     * @return
     */
    private ProductDetailVo assembleProductDetailVo ( Product product ) {
        ProductDetailVo productDetailVo = new ProductDetailVo();
        productDetailVo.setId(product.getId());
        productDetailVo.setSubtitle(product.getSubtitle());
        productDetailVo.setPrice(product.getPrice());
        productDetailVo.setMainImage(product.getMainImage());
        productDetailVo.setSubImages(product.getSubImages());
        productDetailVo.setCategoryId(product.getCategoryId());
        productDetailVo.setDetail(product.getDetail());
        productDetailVo.setName(product.getName());
        productDetailVo.setStatus(product.getStatus());
        productDetailVo.setStock(product.getStock());

        productDetailVo.setImageHost(PropertiesUtil.getProperty("ftp.server.http.prefix", "http://img.happymmall.com/"));

        Category category = categoryMapper.selectByPrimaryKey(product.getCategoryId());
        if (category == null) {
            productDetailVo.setParentCategoryId(0);//默认根节点
        } else {
            productDetailVo.setParentCategoryId(category.getParentId());
        }

        productDetailVo.setCreateTime(DateTimeUtil.dateToStr(product.getCreateTime()));
        productDetailVo.setUpdateTime(DateTimeUtil.dateToStr(product.getUpdateTime()));
        return productDetailVo;
    }
}
