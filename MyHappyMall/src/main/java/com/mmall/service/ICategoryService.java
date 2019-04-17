package com.mmall.service;

import com.mmall.commons.ServerResponse;
import com.mmall.pojo.Category;

import java.util.List;

public interface ICategoryService {

    public ServerResponse <String> addCategory ( Category category );

    public ServerResponse <String> deleteCategoryById ( Integer id );

    public ServerResponse <String> serCategory ( Integer categoryId, Integer parentId, String categoryName );

    public ServerResponse<List<Category>> getChildrenParallelCategory( Integer categoryId);

    public ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);


}
