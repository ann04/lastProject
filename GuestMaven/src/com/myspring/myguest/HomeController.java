package com.myspring.myguest;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.myspring.domain.GuestVO;
import com.myspring.service.GuestService;
import com.myspring.service.PageAction;

/**
 * Handles requests for the application home page.
 */
@SessionAttributes("loginSession")
@Controller
public class HomeController {
	@Inject
	private GuestService service;
	@Inject
	private PageAction page;
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		/*logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );*/
		
		return "insert";
	}
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public String insert(@ModelAttribute GuestVO vo, HttpServletRequest req){
		try {
			InetAddress inetAddr =  InetAddress.getLocalHost();
			vo.setIpaddr(req.getRemoteAddr());
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} 
		service.insert(vo);
		return "redirect:list";
	}
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String list(Model model,String pageNum, String field, String word){
		pageNum = pageNum==null?"1":pageNum;
		int currentPage = Integer.parseInt(pageNum);
		int pageSize = 5;//한 화면에 보이는 게시물수
		int startRow = (currentPage-1)*pageSize+1;//시작게시물 위치
		int endRow = currentPage*pageSize;
		HashMap<String,Object> hm = new HashMap<String, Object>();
		hm.put("startRow", startRow);
		hm.put("endRow", endRow);
		hm.put("field", field);
		hm.put("word", word);
		int count = service.getCount(hm);
		String pageHtml = page.paging(count,pageSize,currentPage);
		model.addAttribute("lists", service.getList(hm));
		model.addAttribute("count",count);
		model.addAttribute("pageHtml",pageHtml);
		
		return "list";
	}
	
	@RequestMapping(value="/view", method=RequestMethod.GET)
	public String view(int num, Model model){
		model.addAttribute("gb",service.findById(num));
		return "viewResult";
	}
	
	@RequestMapping(value="/delete", method=RequestMethod.GET)
	public String delete(int num){
		service.delete(num);
		return "redirect:list";
	}
	
	@RequestMapping(value="/admin", method=RequestMethod.GET)
	public String adminLogin(){
		return "login";
	}
	@RequestMapping(value="/admin", method=RequestMethod.POST)
	public String adminLogin(@RequestParam("uid")String id, String upw,Model model){
		//HttpSession sess = req.getSession();
		if(id.equals("admin")&&upw.equals("1234")){
			model.addAttribute("loginSession", "true");
			return "insert";
		}else{
			model.addAttribute("errMsg","아이디/비번오류");
			return "login";
		}
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String adminLogout(SessionStatus session){
		session.setComplete();
		return "redirect:/";
	} 
	
}
