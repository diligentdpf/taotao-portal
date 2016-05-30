package diao.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import diao.taotao.portal.service.ContentService;

@Controller
public class IndexController {

    @Autowired
    ContentService contentService;

    /**
     * 打开首页
     */
    @RequestMapping("/index")
    public String index(Model model) {
        String adJson = contentService.getContentList();
        model.addAttribute("ad1", adJson);
        return "index";
    }

    @RequestMapping(value = "/httpclient/post", method = RequestMethod.POST, 
            produces = MediaType.APPLICATION_JSON_VALUE
            + ";charset=utf-8")
    @ResponseBody
    public String httpClientTest(String username, String passwd) {
        System.err.println("username:" + username + ",passwd:" + passwd);
        // return TaotaoResult.ok();
        return "{username:" + username + ",passwd:" + passwd + "}";
    }
}
