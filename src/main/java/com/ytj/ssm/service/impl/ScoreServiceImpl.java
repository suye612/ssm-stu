package com.ytj.ssm.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ytj.ssm.dao.ScoreDao;
import com.ytj.ssm.dao.StudentDao;
import com.ytj.ssm.model.ScoreModel;
import com.ytj.ssm.model.StudentAndScore;
import com.ytj.ssm.model.StudentModel;
import com.ytj.ssm.service.IScoreService;
import com.ytj.ssm.util.Exception.AppException;
import com.ytj.ssm.util.Exception.BizExceptionEnum;
import com.ytj.ssm.util.ToolUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: amin
 * @Date: 2018/12/4 19:50
 * @Description:
 */
@Service
public class ScoreServiceImpl extends ServiceImpl<ScoreDao, ScoreModel> implements IScoreService {
    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ModelMapper modelMapper;
    @Override
    public StudentAndScore selectStudentAndScore(Integer id) {
        Wrapper<ScoreModel> eq = new EntityWrapper<ScoreModel>().eq("student_id", id);
        List<ScoreModel> selectList = baseMapper.selectList(eq);
        if (ToolUtil.isEmpty(selectList)) {
            throw new AppException(BizExceptionEnum.NO_DATA_ERROR);
        }
        ScoreModel scoreModel = selectList.get(0);
        StudentModel studentModel = studentDao.selectById(id);
        StudentAndScore  studentAndScore = modelMapper.map(scoreModel, StudentAndScore.class);
        modelMapper.map(studentModel,studentAndScore);
        return studentAndScore;
    }
}
