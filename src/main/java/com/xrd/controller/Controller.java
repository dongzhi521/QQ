package com.xrd.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xrd.pojo.EdocCategory;
import com.xrd.pojo.EdocEntry;
import com.xrd.pojo.EdocEntryExample;
import com.xrd.service.EdocCategoryService;
import com.xrd.service.EdocEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {


    @Autowired
    private  EdocEntryService es;
    @Autowired
    private EdocCategoryService cs;
    @RequestMapping("init")
    private String init(HttpSession session){
        PageHelper.startPage(1, 2);
        List<EdocEntry> e=es.getall(null);

        PageInfo<EdocEntry> info=new PageInfo<EdocEntry>(e);
        List<EdocCategory> lists= cs.selectByExample(null);


        session.setAttribute("lists", lists);
        session.setAttribute("list", info.getList());
        session.setAttribute("info",info);
        return "index";
    }

    @RequestMapping("/inits/{index}")
    private  String  inits(HttpSession session,@PathVariable("index") Integer index){
        System.out.println(index);
        PageHelper.startPage(index, 2);
        List<EdocEntry> e=es.getall(null);

        PageInfo<EdocEntry> info=new PageInfo<EdocEntry>(e);
        int a=info.getPages();
        System.out.println(a+"789456");
        if (info.isIsLastPage()==true) {
            info.setNextPage(a);

        }
        List<EdocCategory> lists= cs.selectByExample(null);


        session.setAttribute("lists", lists);
        session.setAttribute("list", info.getList());
        session.setAttribute("info",info);
        return "index";
    }


    @RequestMapping("select")
    private String select(HttpSession session,Long lname,String summary){
        PageHelper.startPage(1, 2);
        if (lname==0 && summary==null) {
            session.removeAttribute("lname");
            return "init";
        }


        EdocEntryExample ee=new EdocEntryExample();
        EdocEntryExample.Criteria c=	ee.createCriteria();
        if (lname!=0&&summary==null) {
            c.andCategoryidEqualTo(lname);
        }else if(lname==0&&summary!=null){
            c.andSummaryLike("%"+summary+"%");
        }else if(lname!=0&&summary!=null){
            c.andCategoryidEqualTo(lname);
            c.andSummaryLike("%"+summary+"%");
        }



        List<EdocEntry> e=es.getall(ee);

        PageInfo<EdocEntry> info=new PageInfo<EdocEntry>(e);

        if (info.isHasPreviousPage()==false) {
            info.setNextPage(1);

        }
        session.setAttribute("lname", lname);
        session.setAttribute("list", info.getList());
        session.setAttribute("info",info);
        return "index";
    }


    @RequestMapping("dels/{id}")
    private String dels(HttpSession session, HttpServletResponse response, @PathVariable("id")Long id) {


        int n=es.deleteByPrimaryKey(id);
        if(n>0){
            session.setAttribute("shan", "删除成功");
        }else{
            session.setAttribute("shan", "删除失败");
        }

        return "init";

    }

}
