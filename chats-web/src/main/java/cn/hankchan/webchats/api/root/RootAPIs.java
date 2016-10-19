package cn.hankchan.webchats.api.root;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	@RequestMapping("/root/logout.json")
	public @ResponseBody APIResult logout(HttpServletRequest req, HttpServletResponse rsp, 
			HttpSession session) {
		APIResult result = APIResult.prepare();
		// 注销session
		session.invalidate();
		return result;
	}
	
	// 有的文章并不提倡采用HttpSession。。后续再进一步讨论
	@RequestMapping("/root/login.json")
	public @ResponseBody APIResult login(HttpServletRequest req, HttpServletResponse rsp, 
			HttpSession session, 
			@RequestParam("username") String root, 
			@RequestParam("password") String password, 
			@RequestParam("phone") String phone) {
		APIResult result = APIResult.prepare();
		// 校验用户名、密码、手机号
		Root dbRoot = rootDataService.count(root, password, phone);
		if(dbRoot != null) { 
			// 校验通过
			// 绑定session
			session.setAttribute("root", root);
			// TODO 
			result.ok("login success..");
		} else { 
			// 校验失败
			result.error("login failure..");
		}
		return result;
	}
}
