package com.govern.webservie.service.impl;

import com.govern.webservie.entity.SensorData;
import com.govern.webservie.mapper.DataMapper;
import com.govern.webservie.service.DataService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Nanf_bunan
 * @since 2021-12-30
 */
@Service
public class DataServiceImpl extends ServiceImpl<DataMapper, SensorData> implements DataService {

}
