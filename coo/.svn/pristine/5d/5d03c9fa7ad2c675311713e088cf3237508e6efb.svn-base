package com.hidm.coo.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hidm.coo.entity.Currency;
import com.hidm.coo.entity.OPBase;
import com.hidm.coo.vo.OPBaseSearchVo;
import com.hidm.coo.vo.OPBaseVo;
import com.hidm.coo.vo.PaginationVo;
@Controller
public class CurrencyController {

    /**
     * currency跳转到列表页面
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("currency/manage")
    public String index(Model model, HttpSession session) {
        return "/currency/manage";
    }
    
    @RequestMapping("currency/search")
    @ResponseBody
    public Map<String, Object> search(Currency currency) {
        List<Currency> list = new ArrayList<Currency>();
        Currency currency1 = new Currency();
        currency1.setId((long) 1);
        currency1.setItem("CNY");
        currency1.setUnit("CNY");
        currency1.setValue("1");
        Currency currency2 = new Currency();
        currency2.setId((long) 2);
        currency2.setItem("USD");
        currency2.setUnit("CNY");
        currency2.setValue("6.92");
        Currency currency3 = new Currency();
        currency3.setId((long) 3);
        currency3.setItem("JPY");
        currency3.setUnit("CNY");
        currency3.setValue("16.20746");
        Currency currency4 = new Currency();
        currency4.setId((long) 4);
        currency4.setItem("HKD");
        currency4.setUnit("CNY");
        currency4.setValue("0.88");
        list.add(currency1);
        list.add(currency2);
        list.add(currency3);
        list.add(currency4);
        
        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", 4);
        result.put("rows", list);
        return result;
    }
}