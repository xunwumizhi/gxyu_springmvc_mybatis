package gxyu.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import gxyu.controller.validation.ValidGroup1;
import gxyu.controller.validation.ValidGroup2;
import gxyu.po.ItemsCustom;
import gxyu.po.ItemsQueryVo;
import gxyu.service.ItemsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	
	@ModelAttribute("itemtypes")
	public Map<String, String> getItemTypes() {

		Map<String, String> itemTypes = new HashMap<String, String>();
		itemTypes.put("101", "数码");
		itemTypes.put("102", "母婴");

		return itemTypes;
	}
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
	//页面【查询】，参数和形参包装的pojo进行参数绑定，可用来实现条件查询	
		System.out.println(request.getParameter("id"));
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("items/itemsList");
		return modelAndView;
	}
	
	@RequestMapping(value="/editItems",method={RequestMethod.POST,RequestMethod.GET})
	public String editItems(Model model,@RequestParam(value="id",required=true) int items_id) throws Exception{
		ItemsCustom itemsCustom = itemsService.findItemsById(items_id);
		model.addAttribute("items", itemsCustom);
		
		return "items/editItems";
	}
	
	//加了分组校验功能，则只校验此规则组中的字段，不属于这些规则组的不校验
	@RequestMapping("/editItemsSubmit")
	public String editItemsSubmit(Model model,HttpServletRequest request, int id,
			@Validated(value={ValidGroup1.class,ValidGroup2.class}) ItemsCustom itemsCustom,
			BindingResult bindingResult,
			MultipartFile items_pic) throws Exception{
		
		if(bindingResult.hasErrors()){
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError objectError : allErrors){
				System.out.println(objectError.getDefaultMessage());
			}
			model.addAttribute("allErrors",allErrors);
			//出错回显数据
			model.addAttribute("items", itemsCustom);
			
			return "items/editItems";
		}
		
		String originalFilename = items_pic.getOriginalFilename();
		if(items_pic != null && originalFilename != null && originalFilename.length()>0){
			String pic_path = "D:\\eclipseSSM\\upload\\temp\\";
			String newFileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));
			File newFile = new File(pic_path+newFileName);
			
			items_pic.transferTo(newFile);
			itemsCustom.setPic(newFileName);
		}
		
		itemsService.updateItems(id, itemsCustom);
		//重定向到商品查询列表
//		return "redirect:items/queryItems.action";
		//页面转发
		//return "forward:items/queryItems.action";
		return "success";
	}
	
	@RequestMapping("/deleteItems")
	public String deleteItems(int[] items_id) throws Exception{
//		return "redirect:items/queryItems.action";
		return "success";
	}
	
	
	
	
	@RequestMapping("/editItemsQuery")
	public ModelAndView editItemsQuery(HttpServletRequest request,
			ItemsQueryVo itemsQueryVo) throws Exception {
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("itemsList", itemsList);
		modelAndView.setViewName("items/editItemsQuery");

		return modelAndView;
	}
	
	
	@RequestMapping("/editItemsAllSubmit")
	public String editItemsAllSubmit(ItemsQueryVo itemsQueryVo)
			throws Exception {

		return "success";
	}
	
	//restFull,URI查询商品信息，输出json
	///itemsView/{id}里边的{id}表示占位符，通过@PathVariable获取占位符中的参数，
	//如果占位符中的名称和形参名一致，在@PathVariable可以不指定名称
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id)throws Exception{
		
		//调用service查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		
		return itemsCustom;
		
	}
	
	
}
