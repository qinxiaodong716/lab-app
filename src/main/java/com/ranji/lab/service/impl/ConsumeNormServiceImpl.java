package com.ranji.lab.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ranji.lab.entity.ConsumeNorm;
import com.ranji.lab.mapper.ConsumeNormMapper;
import com.ranji.lab.service.prototype.IConsumeNormService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
public class ConsumeNormServiceImpl implements IConsumeNormService {

    @Resource
    private ConsumeNormMapper consumeNormMapper;

    @Override
    public int insertConsumeNorm(ConsumeNorm consumeNorm) {
        return consumeNormMapper.insertConsumeNorm(consumeNorm);
    }

    @Override
    public int updateConsumeNorm(ConsumeNorm consumeNorm) {
        return consumeNormMapper.updateConsumeNorm(consumeNorm);
    }

    @Override
    public Map<Object, Object> findAll(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        List<ConsumeNorm> allConsumeNorm = consumeNormMapper.findAll();

        PageInfo<ConsumeNorm> allConsumeNormPaging = new PageInfo<>(allConsumeNorm);
        long total = allConsumeNormPaging.getTotal();

        Map<Object,Object> allConsumeNormOnPaging = new HashMap<>();
        allConsumeNormOnPaging.put("data",allConsumeNorm);
        allConsumeNormOnPaging.put("total",total);
        return allConsumeNormOnPaging;
    }

    @Override
    public List<ConsumeNorm> findAll() {
        return consumeNormMapper.findAll();
    }

    @Override
    public ConsumeNorm findById(int id) {
        return consumeNormMapper.findById(id);
    }
}
