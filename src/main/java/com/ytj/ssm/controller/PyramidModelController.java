package com.ytj.ssm.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ytj.ssm.model.PyramidModel;
import com.ytj.ssm.service.IPyramidService;
import com.ytj.ssm.util.NumUtil;
import com.ytj.ssm.util.Status;
import com.ytj.ssm.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: supengfei
 * @Date: 2018/12/9 20:37
 * @Description:
 */
@Controller
public class PyramidModelController {

    @Autowired
    private IPyramidService pyramidService;

    /**
     * 跳转到登录页面
     **/
    @RequestMapping("/")
    public String index() {
        return "index1";
    }

    @RequestMapping("/selectAllPyramide")
    @ResponseBody
    public List<PyramidModel> SelectAllPyramide(){
        List<PyramidModel> list =  pyramidService.selectList(null);
        for (PyramidModel pyramidModel : list) {
            Integer pid = pyramidModel.getPid();
            if (ToolUtil.isEmpty(pid)) {

            }
            //为当前对象找到父亲
            pyramidModel.setParentPyramid(pyramidService.selectById(pid));
            String cids = pyramidModel.getCids();
            if (ToolUtil.isEmpty(cids)) {

            }
            String [] cidss = cids.split(",");
            if (ToolUtil.isEmpty(cidss)) {

            }
            List<PyramidModel> childrenPyramid = new ArrayList<>();
            for (int i=0; i<=cidss.length;i++){
                cids = cids.substring(1,cidss[i].length());
                childrenPyramid.add(pyramidService.selectById(Integer.parseInt(cids)));
            }
            //为当前对象找孩子们
            pyramidModel.setChildrenPyramids(childrenPyramid);

        }
        return  list;
    }

    @RequestMapping("/insertPyramid")
    public void insertPyramid(PyramidModel pyramidModel,Integer pid){
        //为该对象设置父亲
        pyramidModel.setPid(pid);
        pyramidModel.setStatus(Status.ENABLE);
        pyramidService.insert(pyramidModel);
        //把他父亲查到
        PyramidModel ParentPyramid =  pyramidService.selectById(pid);
        //给让父亲知道自己的孩子们
        if (ToolUtil.isEmpty(ParentPyramid.getCids())) {
            ParentPyramid.setCids("[" + pyramidModel.getId() + "]");
        }else {
            ParentPyramid.setCids(ParentPyramid.getCids() + ",[" + pyramidModel.getId() + "]");
        }
        //查看自己的兄弟姐妹
        Wrapper eq = new EntityWrapper<PyramidModel>().eq("pid", pid);
        List<PyramidModel> list = pyramidService.selectList(eq);
        if (list.size() < 5) {
            //不计算提出
        } else if (list.size() == 5) {
            //开始第一次计算提成
            //yeye 拿会费的 7%
            PyramidModel yeye = pyramidModel.getParentPyramid().getParentPyramid();
            if (ToolUtil.isNotEmpty(yeye)) {
                Double yongjin_7 = new Double(NumUtil.keep2PointZero(1000 * 0.07)) + yeye.getCommission();
                yeye.setCommission(yongjin_7*5);
            }
            //yeyeye 拿会费的 14%
            PyramidModel yeyeye = pyramidModel.getParentPyramid().getParentPyramid().getParentPyramid();
            if (ToolUtil.isNotEmpty(yeyeye)) {
                Double yongjin_14 = new Double(NumUtil.keep2PointZero(1000 * 0.14)) + yeyeye.getCommission();
                yeyeye.setCommission(yongjin_14*5);
            }
            //yeyeyeye 拿会费的 21%
            PyramidModel yeyeyeye = pyramidModel.getParentPyramid().getParentPyramid().getParentPyramid().getParentPyramid();
            if (ToolUtil.isNotEmpty(yeyeyeye)) {
                Double yongjin_21 = new Double(NumUtil.keep2PointZero(1000 * 0.14)) + yeyeyeye.getCommission();
                yeyeyeye.setCommission(yongjin_21*5);
            }
        } else {
            //仅给计算当前对象
            //yeye 拿会费的 7%
            PyramidModel yeye = pyramidModel.getParentPyramid().getParentPyramid();
            if (ToolUtil.isNotEmpty(yeye)) {
                Double yongjin_7 = new Double(NumUtil.keep2PointZero(1000 * 0.07)) + yeye.getCommission();
                yeye.setCommission(yongjin_7);
            }
            //yeyeye 拿会费的 14%
            PyramidModel yeyeye = pyramidModel.getParentPyramid().getParentPyramid().getParentPyramid();
            if (ToolUtil.isNotEmpty(yeyeye)) {
                Double yongjin_14 = new Double(NumUtil.keep2PointZero(1000 * 0.14)) + yeyeye.getCommission();
                yeyeye.setCommission(yongjin_14);
            }
            //yeyeyeye 拿会费的 21%
            PyramidModel yeyeyeye = pyramidModel.getParentPyramid().getParentPyramid().getParentPyramid().getParentPyramid();
            if (ToolUtil.isNotEmpty(yeyeyeye)) {
                Double yongjin_21 = new Double(NumUtil.keep2PointZero(1000 * 0.14)) + yeyeyeye.getCommission();
                yeyeyeye.setCommission(yongjin_21);
            }
        }

    }
    @RequestMapping("/deletePyramid")
    public void deletePyramid(PyramidModel pyramidModel){
        pyramidModel.setStatus(Status.DISABLED);
        pyramidService.updateById(pyramidModel);
        //把他父亲查到
        PyramidModel ParentPyramid =  pyramidService.selectById(pyramidModel.getPid());
        //给让父亲知道自己的孩子们
        //如果父亲为空 则为顶级
        if (ToolUtil.isEmpty(ParentPyramid)) {
            //ParentPyramid.setCids("[" + pyramidModel.getId() + "]");
        }else {
            String cids =  ParentPyramid.getCids();
            //将删除的id从 父亲的孩子中 去除
        }
        //去除后查看自己的兄弟姐妹
        Wrapper eq = new EntityWrapper<PyramidModel>().eq("pid", pyramidModel.getPid());
        List<PyramidModel> list = pyramidService.selectList(eq);
        if (list.size() < 5) {
            // 退出一个人后 不满足提成条件 重新计算分成 减去5个人的分成
        } else {
            //// 退出一个人后 仍然满足提成条件 重新计算分成 仅减去一个人的分成
        }
    }
}
