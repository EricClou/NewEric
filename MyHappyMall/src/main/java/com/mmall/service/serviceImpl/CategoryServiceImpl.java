package com.mmall.service.serviceImpl;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mmall.commons.ServerResponse;
import com.mmall.dao.CategoryMapper;
import com.mmall.pojo.Category;
import com.mmall.service.ICategoryService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service("iCategoryService")
public class CategoryServiceImpl implements ICategoryService {
    private Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);



    @Autowired
    public CategoryMapper categoryMapper;

    @Override
    public ServerResponse <String> addCategory ( Category category ) {

        //输入品类名信息为空
        if (StringUtils.isBlank(category.getName())) return ServerResponse.createByErrorMessage("请输入详细信息");

        //默认父品类是总品类
        if (category.getParentId() == null) category.setParentId(0);

        //默认上货状态是1
        if (category.getStatus() == null) category.setStatus(true);


        int checkValid = 0;
        checkValid = categoryMapper.checkValid(category.getName());
        if (checkValid > 0) return ServerResponse.createByErrorMessage("分类信息不能重复");

        int resultCount = 0;
        resultCount = categoryMapper.insert(category);
        if (resultCount > 0) return ServerResponse.createBySuccess("添加品类成功");


        return ServerResponse.createByErrorMessage("添加品类失败");
    }


    @Override
    public ServerResponse <String> deleteCategoryById ( Integer id ) {
        int resultCount = 0;
        resultCount = categoryMapper.deleteByPrimaryKey(id);
        if (resultCount == 0) return ServerResponse.createByErrorMessage("该品类不存在");
        return ServerResponse.createByErrorMessage("删除成功");
    }


    @Override
    public ServerResponse <String> serCategory ( Integer categoryId, Integer parentId, String categoryName ) {
        Category category = new Category();
        category.setParentId(parentId);
        category.setId(categoryId);
        category.setName(categoryName);
        int resultCount = 0;
        resultCount = categoryMapper.updateByPrimaryKeySelective(category);

        if (resultCount > 0) return ServerResponse.createBySuccessMessage("修改成功");
        return ServerResponse.createByErrorMessage("修改失败");
    }

    public ServerResponse<List<Category>> getChildrenParallelCategory( Integer categoryId){
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        if(CollectionUtils.isEmpty(categoryList)){
            logger.info("未找到当前分类的子分类");
        }
        return ServerResponse.createBySuccess(categoryList);
    }


    /**
     * 递归查询本节点的id及孩子节点的id
     * @param categoryId
     * @return
     */
    public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId){
        Set<Category> categorySet = Sets.newHashSet();
        findChildCategory(categorySet,categoryId);


        List<Integer> categoryIdList = Lists.newArrayList();
        if(categoryId != null){
            for(Category categoryItem : categorySet){
                categoryIdList.add(categoryItem.getId());
            }
        }
        return ServerResponse.createBySuccess(categoryIdList);
    }


    //递归算法,算出子节点
    private Set<Category> findChildCategory( Set<Category> categorySet , Integer categoryId){
        Category category = categoryMapper.selectByPrimaryKey(categoryId);
        if(category != null){
            categorySet.add(category);
        }
        //查找子节点,递归算法一定要有一个退出的条件
        List<Category> categoryList = categoryMapper.selectCategoryChildrenByParentId(categoryId);
        for(Category categoryItem : categoryList){
            findChildCategory(categorySet,categoryItem.getId());
        }
        return categorySet;
    }







}
