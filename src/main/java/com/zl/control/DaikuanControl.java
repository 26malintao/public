package com.zl.control;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import com.zl.pojo.Daikuan;
import com.zl.pojo.FenYe;
import com.zl.pojo.State;
import com.zl.pojo.Type;

import com.zl.service.IDaikuanService;
import com.zl.service.IStateService;
import com.zl.service.ITypeService;
@Controller
@RequestMapping("/dc")
public class DaikuanControl {
			@Autowired
			private IDaikuanService ds;
			@Autowired
			private ITypeService ts;
			@Autowired
			private IStateService ss;
			@RequestMapping("/fy")
		
		public ModelAndView  GoFenYe(FenYe fy) {
			
			ModelAndView  model=new ModelAndView ();	
			List<Daikuan> dkList=ds.findSQByFy(fy);
			//System.out.println("11111111111"+dkList);
			List<Type> tpList=ts.findAllType();
			model.addObject("dkList", dkList);
			model.addObject("tpList",tpList);

			model.addObject("fy", fy);
			model.setViewName("main");//…Ë÷√ ”Õº√˚≥∆
			return model;	
		}
			//…æ≥˝
			@RequestMapping(value="delete",method=RequestMethod.GET)
			public String deleteJump(Integer sqid,Model model){
				//boolean flag=wuziServiceImpl.deletewuzi(wuziid);
				boolean flag=ds.deleteDaikuan(sqid);
				if(flag==true){
					return "redirect:fy";
				}else{
					model.addAttribute("msg", "…æ≥˝ ß∞‹");
					return "redirect:fy";
				}				
			}
		/*	@RequestMapping("delete")
			public String deleteIndo(String str) {
				String[] strs=str.trim().split(",");
				for (int i = 0; i < strs.length; i++) {
					if(strs[i]!=null&& strs[i]!="") {
						int sqid=Integer.parseInt(strs[i]);
						ds.deleteDaikuan(sqid);
					}
				}
				return "redirect:/wc/qaw.do";
			}*/

			//–ﬁ∏ƒ
			@RequestMapping(value="update",method=RequestMethod.GET)
			public String updateJump(Integer sqid,Model model){
				Daikuan daikuan=ds.findById(sqid);
				//WuZi wuzi=wuziServiceImpl.findById(wuziid);
				List<Type> typelist=ts.findAllType();
				List<State> statelist=ss.findAllState();
				//List<Changshang> changshanglist=changshangServiceImpl.findAllChangshang();
				model.addAttribute("daikuan", daikuan);
				model.addAttribute("typelist", typelist);
				model.addAttribute("statelist", statelist);
				
				return "update";
			
			}
			@RequestMapping(value="update",method=RequestMethod.POST)
			public String updateJump(Daikuan daikuan,Model model){
					boolean flag=ds.updateSQ(daikuan);
					//boolean flag=wuziServiceImpl.updatewuzi(wuzi);
					
					if(flag==true){
						return "redirect:fy";
					}else{
						model.addAttribute("msg", "–ﬁ∏ƒ ß∞‹");
						return "update";
					}			
			}
	/*		@RequestMapping("dt")
			public String deleteIndo(String str) {
				String[] strs=str.trim().split(",");
				for (int i = 0; i < strs.length; i++) {
					if(strs[i]!=null&& strs[i]!="") {
						int sqid=Integer.parseInt(strs[i]);
						ds.deleteDaikuan(sqid);
					}
				}
				return "redirect:fy";
			}*/
		/*	// …æ≥˝»´≤ø
			@RequestMapping("dt")
			public String deleteAllJump(int[] box,Model model){
				System.out.println(box+"00");
				boolean flag=ds.deleteAll(box);
				if(flag==true){
					return "redirect:fy";
				}else{
					model.addAttribute("msg", "…æ≥˝ ß∞‹");
					return "redirect:fy";
				}		
			}*/
			// …æ≥˝»´≤ø
			@RequestMapping("dt")
			public String deleteAllJump(int[] box,Model model){
				
				boolean flag=ds.deleteAll(box);
				if(flag==true&&box!=null){
					return "redirect:fy";
				}else{
					model.addAttribute("msg", "…æ≥˝ ß∞‹");
					return "redirect:fy";
				}		
			}
			
}
