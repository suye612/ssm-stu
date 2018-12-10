package com.ytj.ssm.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.ytj.ssm.model.Nodes;
import com.ytj.ssm.model.PyramidModel;
import com.ytj.ssm.service.IPyramidService;
import com.ytj.ssm.util.NumUtil;
import com.ytj.ssm.util.Status;
import com.ytj.ssm.util.ToolUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.tools.Tool;
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
    /*@RequestMapping("/")
    public String index() {
        return "index1";
    }*/

    @RequestMapping("/selectAllPyramide")
    @ResponseBody
    public List<Nodes> SelectAllPyramide(){

        List<Nodes> nodesTree = pyramidService.selectTree();
        for (Nodes nodes : nodesTree) {
            //为当前对象找孩子们
            findChildren(nodes);
        }
        return  nodesTree;
    }
    private void findChildren(Nodes nodes){
        String cids = nodes.getCids();
        if (ToolUtil.isNotEmpty(cids)) {
            String [] cidss = cids.split(",");
            List<Nodes> children = new ArrayList<>();
            for (int i=0; i<cidss.length;i++){
                if (ToolUtil.isNotEmpty(cidss[i])) {
                    cids = cidss[i].substring(1,cidss[i].length()-1);
                    Nodes child = pyramidService.selectNodesById(Integer.parseInt(cids));
                    children.add(child);
                    findChildren(child);
                }
            }
            nodes.setChildren(children);
        }
    }
    @RequestMapping("/insertPyramid")
    @ResponseBody
    public String insertPyramid(PyramidModel pyramidModel){
        pyramidModel.setMembership(10000.00);
        pyramidModel.setStatus(Status.ENABLE);
        pyramidService.insert(pyramidModel);
        //把他父亲查到
        PyramidModel parentPyramid =  pyramidService.selectById(pyramidModel.getPid());
        //给让父亲知道自己的孩子们
        if (ToolUtil.isEmpty(parentPyramid.getCids())) {
            parentPyramid.setCids("[" + pyramidModel.getId() + "],");
        } else {
            parentPyramid.setCids(parentPyramid.getCids() + "[" + pyramidModel.getId() + "],");
        }
        pyramidService.updateById(parentPyramid);
        //查看自己的兄弟姐妹
        Wrapper eq = new EntityWrapper<PyramidModel>().eq("pid", pyramidModel.getPid()).eq("status",Status.ENABLE);
        List<PyramidModel> list = pyramidService.selectList(eq);
        if (list.size() < 5) {
            //不计算提成
            return "新增成功!为达到提成标准";
        } else if (list.size() == 5) {
            //开始第一次计算提成
            return updateCommission(pyramidModel,5,true);
        } else {
            //仅给计算当前对象
            return updateCommission(pyramidModel,1,true);
        }
    }
    @RequestMapping("/deletePyramid")
    @ResponseBody
    public void deletePyramid(PyramidModel pyramidModel){
        pyramidModel.setStatus(Status.DISABLED);
        pyramidService.updateById(pyramidModel);
        pyramidModel = pyramidService.selectById(pyramidModel.getId());
        //把他父亲查到
        PyramidModel parentPyramid =  pyramidService.selectById(pyramidModel.getPid());
        //给让父亲知道自己的孩子们
        //如果父亲为空 则为顶级
        if (ToolUtil.isEmpty(parentPyramid)) {
            //ParentPyramid.setCids("[" + pyramidModel.getId() + "]");
        }else {
            String cids =  parentPyramid.getCids();
            //将删除的id从 父亲的孩子中 去除
                String str = "[" + pyramidModel.getId() + "],";
                String cid = cids.replace(str, "");
                parentPyramid.setCids(cid);
                pyramidService.updateById(parentPyramid);
        }
        //去除后查看自己的兄弟姐妹
        Wrapper eq = new EntityWrapper<PyramidModel>().eq("pid", pyramidModel.getPid()).eq("status",Status.ENABLE);
        List<PyramidModel> list = pyramidService.selectList(eq);
        if (list.size() == 4) {
            // 退出一个人后 不满足提成条件 重新计算分成 减去5个人的分成
            updateCommission(pyramidModel,5,false);
        } else if (list.size() > 4){
            //// 退出一个人后 仍然满足提成条件 重新计算分成 仅减去一个人的分成
            updateCommission(pyramidModel,1,false);
        }
    }
    /**
     * @Description //TODO
     * @Param pyramidModel 新入或退出的对象 number 参与计算提成的个数 flag ture 为 新入会 false为退出
     * @return
     **/
    private String updateCommission(PyramidModel pyramidModel,Integer number,Boolean flag){
        //yeye 拿会费的 7%
        PyramidModel baba = pyramidService.selectById(pyramidModel.getPid());
        if (ToolUtil.isEmpty(baba)) {
            return "新增成功! 该级别没有父级";
        }
        PyramidModel yeye = pyramidService.selectById(baba.getPid());
        if (ToolUtil.isEmpty(yeye)) {
            return "新增成功! 没有人达到分成条件";
        }
        Double yongjin_7  ;
        if (flag) {
            double val = pyramidModel.getMembership() * 0.07*number;
            yongjin_7 = new Double(NumUtil.keep2PointZero(val)) + yeye.getCommission();
        } else {
            yongjin_7 =yeye.getCommission() - new Double(NumUtil.keep2PointZero(pyramidModel.getMembership() * 0.07*number)) ;
        }
        yeye.setCommission(yongjin_7);
        pyramidService.updateById(yeye);

        //yeyeye 拿会费的 14%
        PyramidModel yeyeye = pyramidService.selectById(yeye.getPid());
        if (ToolUtil.isEmpty(yeyeye)) {
            return "新增成功! 没有人达到14%的分成条件";
        }
        Double yongjin_14 ;
        if (flag) {
            yongjin_14 = new Double(NumUtil.keep2PointZero(pyramidModel.getMembership() * 0.14*number)) + yeyeye.getCommission();
        } else {
            yongjin_14 =yeyeye.getCommission() - new Double(NumUtil.keep2PointZero(pyramidModel.getMembership() * 0.14*number)) ;
        }
        yeyeye.setCommission(yongjin_14);
        pyramidService.updateById(yeyeye);
        //yeyeyeye 拿会费的 21%
        PyramidModel yeyeyeye = pyramidService.selectById(yeyeye.getPid());
        if (ToolUtil.isEmpty(yeyeyeye)) {
            return "新增成功! 没有人达到21%的分成条件";
        }
        Double yongjin_21 ;
        if (flag) {
            yongjin_21 = new Double(NumUtil.keep2PointZero(pyramidModel.getMembership() * 0.21 * number)) + yeyeyeye.getCommission();
        } else {
            yongjin_21 =yeyeyeye.getCommission() - new Double(NumUtil.keep2PointZero(pyramidModel.getMembership() * 0.21 * number)) ;
        }
        yeyeyeye.setCommission(yongjin_21);
        pyramidService.updateById(yeyeyeye);

        return "新增成功! 分成已更新成功!";
    }
}
