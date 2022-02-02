package com.ahao.service.impl;

import com.ahao.entity.IsolatedInfo;
import com.ahao.entity.SpecialReport;
import com.ahao.mapper.IsolatedInfoMapper;
import com.ahao.mapper.SpeciaReportMapper;
import com.ahao.service.IsolatedInfoService;
import com.ahao.vo.IsolatedInfoVO;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Ahao
 * @since 2021-11-08
 */
@Service
public class IsolatedInfoServiceImpl extends ServiceImpl<IsolatedInfoMapper, IsolatedInfo> implements IsolatedInfoService {

    @Resource
    IsolatedInfoMapper isolatedInfoMapper;

    @Autowired
    SpeciaReportMapper speciaReportMapper;

    //用户查询个人个隔离信息
    @Override
    public IsolatedInfo getIsolatedInfo(Integer id) {
        IsolatedInfoVO isolatedInfo = isolatedInfoMapper.selectByUid(id);
        return isolatedInfo;
    }

    @Override   
    public List<IsolatedInfoVO> getAllisolatedPerson(String search) {
        List<IsolatedInfoVO> allisolatedPerson = isolatedInfoMapper.getAllisolatedPerson(search);
        /*for (int i = 0; i < allisolatedPerson.size(); i++) {
            allisolatedPerson.get(i).getStartTime();
        }*/
        return allisolatedPerson;
    }

    //删除隔离人员
    @Override
    public int deleteIsolation(Integer uid) {
        return isolatedInfoMapper.deleteByUid(uid);
    }

    //添加隔离人员
    @Override
    public int addIsolation(Integer uid) {
        SpecialReport report = speciaReportMapper.selectByUid(uid);
        Date date = new Date();
        String reson = report.getReson();
        return isolatedInfoMapper.addIsolation(uid,date,reson);
    }
}
