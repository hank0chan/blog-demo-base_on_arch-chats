package cn.hankchan.webchats.api.root;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hankchan.data.root.entity.Root;
import cn.hankchan.root.service.RootDataServiceImpl;
import cn.hankchan.webchats.api.result.APIResult;

@Controller
public class RootAPIs {

	@Autowired
	RootDataServiceImpl rootDataService;
	
	@RequestMapping("/root/login.json")
	public @ResponseBody APIResult login(HttpServletRequest req, HttpServletResponse rsp, 
			@RequestParam("username") String root, 
			@RequestParam("password") String password, 
			@RequestParam("phone") String phone) {
		APIResult result = APIResult.prepare();
		Root dbRoot = rootDataService.count(root, password, phone);
		if(dbRoot != null) { 
			// 三者匹配说明用户校验通过
			// TODO 绑定session
			
		} else { 
			// TODO 校验失败
			
		}
		return result;
	}
}
