package com.myshop.controller.admin;

import com.github.pagehelper.PageInfo;
import com.myshop.pojo.Category;
import com.myshop.service.CategoryService;
import com.myshop.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("admin/category")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @RequestMapping("view/{viewname}")
    public String index(@PathVariable(name = "viewname") String viewname) {
        return "admin/category_"+viewname;
    }

    //@RequestMapping("/toadd")
    //public String toadd() {
    //    return "admin/category_toadd";
    //
    //}

    @RequestMapping("/toedit/{id}")
    public String toedit(HttpServletRequest request, @PathVariable(name="id") Integer id) {
        Category category = service.getCategoryById(id);
        request.setAttribute("category",category);
        return "admin/category_toedit";

    }
    @RequestMapping("/manager")
    public String manager() {
        return "admin/category_manager";

    }
    @RequestMapping("/doadd")
    @ResponseBody
    public JsonResult doadd(Category category) {
        System.out.println(category);
        int result = service.addCategory(category);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(result);
        if (result == 1) {
            jsonResult.setStatusCode(0);
            jsonResult.setMsg("添加成功");
        } else if (result == 0) {
            jsonResult.setStatusCode(500);
            jsonResult.setMsg("添加失败");
        } else {
            jsonResult.setStatusCode(500);
            jsonResult.setMsg("添加失败，类名重复");
        }
        return jsonResult;
    }

    @RequestMapping("/doedit")
    @ResponseBody
    public JsonResult doedit(Category category) {
        System.out.println(category);
        int result = service.editCategory(category);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(result);
        if (result == 1) {
            jsonResult.setStatusCode(0);
            jsonResult.setMsg("修改成功");
        } else if (result == 0) {
            jsonResult.setStatusCode(500);
            jsonResult.setMsg("修改失败");
        } else {
            jsonResult.setStatusCode(500);
            jsonResult.setMsg("修改失败");
        }
        return jsonResult;
    }
    @RequestMapping("/del/{categoryid}")
    @ResponseBody
    public JsonResult dodel(@PathVariable Integer categoryid) {

        int result = service.delCategory(categoryid);
        System.out.println(result);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(result);
        if (result == 1) {
            jsonResult.setStatusCode(0);
            jsonResult.setMsg("删除成功");
        } else if (result == 0) {
            jsonResult.setStatusCode(500);
            jsonResult.setMsg("删除失败");
        } else {
            jsonResult.setStatusCode(500);
            jsonResult.setMsg("修改失败，该类别下还有商品");
        }
        return jsonResult;
    }


    @RequestMapping("/search")
    @ResponseBody
    public JsonResult search(Category category, @RequestParam(name = "pageindex",defaultValue = "1") Integer pageindex, @RequestParam(name = "pagesize",defaultValue = "3") Integer pagesize) {
        System.out.println(category);
        PageInfo<Category> pageInfo = service.search(category, pageindex, pagesize);

        JsonResult jsonResult = new JsonResult();
        jsonResult.setData(pageInfo);
        System.out.println(jsonResult);
        return jsonResult;
    }

}
