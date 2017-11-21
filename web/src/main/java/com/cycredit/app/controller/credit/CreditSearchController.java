package com.cycredit.app.controller.credit;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by qiyubin on 2017/11/20 0020.
 *
 * @author qiyubin
 */
@RestController
@RequestMapping(value = "credit")
@ResponseBody
@Api(value = "credit", description = "信用主体搜索接口")
public class CreditSearchController {

    /**
     * 联合个人备忘录处理
     *
     * @param pid
     * @param dealType
     * @param description
     * @return
     */
    @RequestMapping("/personSearch")
    @ApiOperation(notes = "personSearch", httpMethod = "GET", value = "")
    public String personSearch(String pid, String dealType, String description) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return map.toString();
    }

    /**
     * 联合企业备忘录处理
     *
     * @param pid
     * @param dealType
     * @param description
     * @return
     */
    @RequestMapping("/enterpriseSearch")
    @ApiOperation(notes = "enterpriseSearch", httpMethod = "GET", value = "")
    public String enterpriseSearch(String pid, String dealType, String description) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return map.toString();
    }


}
