package com.hand.test_26850.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hand.test_26850.common.DataGridView;
import com.hand.test_26850.common.ResultObj;
import com.hand.test_26850.pojo.Unit;
import com.hand.test_26850.service.UnitService;
import com.hand.test_26850.vo.UnitVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("unit")
public class UnitController {

    @Autowired
    private UnitService unitService;

    @RequestMapping("showUnits")
    @ResponseBody
    public DataGridView showUnits(UnitVo unitVo){
        PageHelper.startPage(unitVo.getPage(),unitVo.getLimit());
        Unit unit=new Unit();
        unit.setUnit_name(unitVo.getUnit_name());
        List<Unit> units = this.unitService.selectUnits(unit);
        PageInfo<Unit> pageInfo=new PageInfo<>(units);
        return new DataGridView(pageInfo.getTotal(),pageInfo.getList());
    }

    @RequestMapping("addUnit")
    @ResponseBody
    public ResultObj addUnit(UnitVo unitVo){
        try {
            unitVo.setCreation_date(new Date());
            unitVo.setLast_update_date(new Date());
            this.unitService.addUnit(unitVo);
            return ResultObj.ADD_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.ADD_ERROR;
        }
    }

    @RequestMapping("updateUnit")
    @ResponseBody
    public ResultObj updateUnit(UnitVo unitVo){
        try {
            unitVo.setLast_update_date(new Date());
            this.unitService.updateUnit(unitVo);
            return ResultObj.UPDATE_SUCCESS;
        } catch (Exception e) {
            e.printStackTrace();
            return ResultObj.UPDATE_ERROR;
        }
    }

    @RequestMapping("selectUnitByUnitId")
    @ResponseBody
    public Unit selectUnitByUnitId(Integer unit_id){
        return unitService.selectUnitByUintId(unit_id);
    }

}
