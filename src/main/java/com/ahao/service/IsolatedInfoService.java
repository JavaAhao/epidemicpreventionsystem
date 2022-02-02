package com.ahao.service;

import com.ahao.entity.IsolatedInfo;
import com.ahao.vo.IsolatedInfoVO;
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
public interface IsolatedInfoService extends IService<IsolatedInfo> {

    IsolatedInfo getIsolatedInfo(Integer uid);

    List<IsolatedInfoVO> getAllisolatedPerson(String search);

    //删除隔离人员
    int deleteIsolation(Integer uid);

    //添加隔离人员
    int addIsolation(Integer uid);
}
