package diao.taotao.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
