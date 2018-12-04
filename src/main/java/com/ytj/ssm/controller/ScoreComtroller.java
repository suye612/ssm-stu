package com.ytj.ssm.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ytj.ssm.model.ScoreModel;
import com.ytj.ssm.service.IScoreService;
import com.ytj.ssm.util.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: amin
 * @Date: 2018/12/4 19:46
 * @Description: 成绩控制器
 */
@Controller
public class ScoreComtroller {

    @Autowired
    private IScoreService scoreService;
    /**
     * @Description 查询学生成绩 根据id
     * @Param 
     * @return 
     **/
    @RequestMapping("/selectScoreByStudentId")
    @ResponseBody
    public Object selectScoreByStudentId(Integer id){
        Wrapper<ScoreModel> eq = new EntityWrapper<ScoreModel>().eq("", id)
                                       .and().eq("status", Status.ENABLE);
        List<ScoreModel> list = scoreService.selectList(eq);
        return  list;
    }
}
