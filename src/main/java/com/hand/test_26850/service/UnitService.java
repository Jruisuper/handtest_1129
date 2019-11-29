package com.hand.test_26850.service;

import com.hand.test_26850.mapper.UnitMapper;
import com.hand.test_26850.pojo.Employee;
import com.hand.test_26850.pojo.Unit;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UnitService {

    @Autowired
    private UnitMapper unitMapper;

    public List<Unit> selectUnits(Unit unit){
        Example example = new Example(Unit.class);
        Example.Criteria criteria = example.createCriteria();
        if (StringUtils.isNotEmpty(unit.getUnit_name())){
            criteria.andLike("unit_name","%"+unit.getUnit_name()+"%");
        }
        List<Unit> units = unitMapper.selectByExample(example);
        return units;
    }

    public Unit selectUnitByUintId(Integer unit_id){
        return this.unitMapper.selectByPrimaryKey(unit_id);
    }

    public Unit selectUnit(String unit_name){
        Unit unit=new Unit();
        unit.setUnit_name(unit_name);
        return this.unitMapper.selectOne(unit);
    }

    public void addUnit(Unit unit){
        this.unitMapper.insertSelective(unit);
    }

    public void updateUnit(Unit unit){
        this.unitMapper.updateByPrimaryKeySelective(unit);
    }
}
