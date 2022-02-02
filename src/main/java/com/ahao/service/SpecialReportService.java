package com.ahao.service;

import com.ahao.common.Result;
import com.ahao.entity.SpecialReport;
import com.ahao.vo.SpecialReportVO;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Ahao
 * @since 2021-11-08
 */
public interface SpecialReportService extends IService<SpecialReport> {

    //提交健康表
    int addHealthForm(SpecialReport report);

    //查询所有异常用户
    List<SpecialReportVO> getAll(String search);

    //删除异常用户
    void delete(Integer id);

    void deleteByuid(Integer uid);

    //获取总数
    Result<?> getTotal();
}
