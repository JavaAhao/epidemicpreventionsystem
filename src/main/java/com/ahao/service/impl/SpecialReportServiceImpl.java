package com.ahao.service.impl;

import com.ahao.common.Result;
import com.ahao.entity.Admin;
import com.ahao.entity.SpecialReport;
import com.ahao.mapper.SpeciaReportMapper;
import com.ahao.service.SpecialReportService;
import com.ahao.vo.SpecialReportVO;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
public class SpecialReportServiceImpl extends ServiceImpl<SpeciaReportMapper, SpecialReport> implements SpecialReportService {

    @Autowired
    SpeciaReportMapper speciaReportMapper;


    //提交健康表
    @Override
    public int addHealthForm(SpecialReport report) {
        if("1".equals(report.getRiskArea())){
            if(report.getTemp()>=37.3){
                report.setReson("途径高风险且体温大于37.3℃");
            }else {
                report.setReson("途径中高风险地区");
            }
        }else {
            report.setReson("体温大于37.3℃");
        }
        return speciaReportMapper.insert(report);
    }

    //查询所有健康表
    @Override
    public List<SpecialReportVO> getAll(String search) {
        return speciaReportMapper.getAll(search);
    }

    //删除异常用户
    @Override
    public void delete(Integer id) {
        speciaReportMapper.delete(Wrappers.<SpecialReport>lambdaQuery().eq(SpecialReport::getUid,id));
    }

    //隔离成功后移除异常用户
    @Override
    public void deleteByuid(Integer uid) {
        speciaReportMapper.deleteByuid(uid);
    }

    @Override
    public Result<?> getTotal() {
        List<SpecialReport> specialReports = speciaReportMapper.selectList(null);
        return Result.success(specialReports);
    }
}
