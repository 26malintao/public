/*package com.zl.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.zl.pojo.Changshang;
import com.zl.pojo.FenYe;
import com.zl.pojo.Query;
import com.zl.pojo.WuZi;
import com.zl.service.IChangshangService;
import com.zl.service.IWuZiService;




@Controller
@RequestMapping("/wzc")
public class WuZiControl {
	@Autowired
	private IWuZiService wuziServiceImpl;
	@Autowired
	private IChangshangService changshangServiceImpl;
	@RequestMapping(value="fy")
	public ModelAndView  GoFenYe(FenYe fy,HttpServletRequest request) {
		
			String qwuziname = request.getParameter("qwuziname");
			String lowprice = request.getParameter("lowprice");
			String highprice = request.getParameter("highprice");
			String getId = request.getParameter("query.qchangshangid");
			
			Integer id = null;
			if(getId!=null&&getId!="") {
				id=Integer.parseInt(getId);
			}		
			ModelAndView  model=new ModelAndView ();	
			
			if(fy.getQuery()!=null&&lowprice!=null&& !lowprice.equals("")&&!highprice.equals("")&&highprice!=null&&qwuziname!=null) {
				fy.getQuery().setLowprice(Integer.parseInt(lowprice));
				fy.getQuery().setLowprice(Integer.parseInt(highprice));
				fy.getQuery().setQwuziname(qwuziname);	
				fy.getQuery().setQchangshangid(id);
			}	
			
			List<WuZi> wuziList=wuziServiceImpl.findWuZiByFy(fy);
			List<Changshang> csList=changshangServiceImpl.findAllChangshang();

			model.addObject("wuziList", wuziList);
			model.addObject("csList",csList);

			model.addObject("fy", fy);
			model.setViewName("main");//ÉèÖÃÊÓÍ¼Ãû³Æ
			return model;	
		}
		
			
	
	//É¾³ý
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteJump(Integer wuziid,Model model){
		boolean flag=wuziServiceImpl.deletewuzi(wuziid);
		
		if(flag==true){
			return "redirect:fy";
		}else{
			model.addAttribute("msg", "É¾³ýÊ§°Ü");
			return "redirect:fy";
		}
			
	}

	//ÐÞ¸Ä
	@RequestMapping(value="update",method=RequestMethod.GET)
	public String updateJump(Integer wuziid,Model model){
		WuZi wuzi=wuziServiceImpl.findById(wuziid);
		List<Changshang> changshanglist=changshangServiceImpl.findAllChangshang();
		model.addAttribute("wuzi", wuzi);
		model.addAttribute("changshanglist", changshanglist);
		return "update";			
	}
	@RequestMapping(value="update",method=RequestMethod.POST)
	public String updateJump(WuZi wuzi,Model model){
			
			boolean flag=wuziServiceImpl.updatewuzi(wuzi);
			
			if(flag==true){
				return "redirect:fy";
			}else{
				model.addAttribute("msg", "ÐÞ¸ÄÊ§°Ü");
				return "update";
			}			
	}
	// É¾³ýÈ«²¿
	@RequestMapping("dt")
	public String deleteAllJump(int[] box,Model model){
		System.out.println(box+"00");
		boolean flag=wuziServiceImpl.deleteAll(box);
		if(flag==true){
			return "redirect:fy";
		}else{
			model.addAttribute("msg", "É¾³ýÊ§°Ü");
			return "redirect:fy";
		}		
	}
	
	
}
*/