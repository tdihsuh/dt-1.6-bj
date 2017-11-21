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
@Api(value = "credit", description = "信用主体处理接口")
public class CreditDealController {

    /**
     * 联合个人备忘录处理
     *
     * @param pid
     * @param dealType
     * @param description
     * @return
     */
    @RequestMapping("/personOperation")
    @ApiOperation(notes = "personOperation", httpMethod = "GET", value = "")
    public String personOperation(String pid, String dealType, String description) {
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
    @RequestMapping("/enterpriseOperation")
    @ApiOperation(notes = "enterpriseOperation", httpMethod = "GET", value = "")
    public String enterpriseOperation(String pid, String dealType, String description) {
        Map map = new HashMap();
        map.put("key", 123);
        map.put("value", "你好");
        return map.toString();
    }


}
