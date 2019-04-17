package com.mmall.controller.backend;


import com.mmall.commons.Const;
import com.mmall.commons.ServerResponse;
import com.mmall.pojo.Category;
import com.mmall.pojo.User;
import com.mmall.service.ICategoryService;
import com.mmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/manage/category")
public class CategoryManageController {


    //在执行操作前要验证是否登陆等信息
    @Autowired
    public IUserService iUserService;

    @Autowired
    public ICategoryService iCategoryService;


    //在这里requestMapping就不需要那么严格地考虑数值的传递方式了，不论是post或者get都可以。
    //之前在user里面之所以大多数用post是因为get方式会在url里面传递数值，是明文的，而user信息显然属于比较私密的信息
    @RequestMapping(value = "/add_category.do")
    @ResponseBody
    //这里实际传入的category的有效信息也就只有parentId和name两个字段有需求，所以可以直接在参数段里面写明，等到多参数传递的时候再封装成对象
    public ServerResponse <String> addCategory ( HttpSession session, Category category ) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) return ServerResponse.createByErrorMessage("请先登录");
        if (user.getRole() != 1) return ServerResponse.createByErrorMessage("非管理员用户不能完成此操作");
        return iCategoryService.addCategory(category);
    }

    @RequestMapping(value = "/delete_category.do")
    @ResponseBody
    public ServerResponse <String> deleteCategory ( HttpSession session, Integer categoryId ) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) return ServerResponse.createByErrorMessage("请先登录");
        if (user.getRole() != 1) return ServerResponse.createByErrorMessage("非管理员用户不能完成此操作");
        return iCategoryService.deleteCategoryById(categoryId);
    }

    @RequestMapping(value = "/set_category.do")
    @ResponseBody
    public ServerResponse <String> set_category ( HttpSession session, Integer categoryId, String categoryName, Integer parentId ) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) return ServerResponse.createByErrorMessage("请先登录");
        if (user.getRole() != 1) return ServerResponse.createByErrorMessage("非管理员用户不能完成此操作");
        return iCategoryService.serCategory(categoryId, parentId, categoryName);
    }


    @RequestMapping(value = "/get_category.do")
    @ResponseBody
    public ServerResponse get_category ( HttpSession session, Integer categoryId ) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) return ServerResponse.createByErrorMessage("请先登录");
        if (user.getRole() != 1) return ServerResponse.createByErrorMessage("非管理员用户不能完成此操作");
        return iCategoryService.getChildrenParallelCategory(categoryId);

    }


    @RequestMapping("get_deep_category.do")
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory ( HttpSession session, @RequestParam(value = "categoryId", defaultValue = "0") Integer categoryId ) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) return ServerResponse.createByErrorMessage("请先登录");
        if (user.getRole() != 1) return ServerResponse.createByErrorMessage("非管理员用户不能完成此操作");
        //查询当前节点的id和递归子节点的id
//            0->10000->100000
        return iCategoryService.selectCategoryAndChildrenById(categoryId);

    }
}
