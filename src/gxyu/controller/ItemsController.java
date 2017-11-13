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
		itemTypes.put("101", "����");
		itemTypes.put("102", "ĸӤ");

		return itemTypes;
	}
	
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request,ItemsQueryVo itemsQueryVo) throws Exception{
	//ҳ�桾��ѯ�����������βΰ�װ��pojo���в����󶨣�������ʵ��������ѯ	
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
	
	//���˷���У�鹦�ܣ���ֻУ��˹������е��ֶΣ���������Щ������Ĳ�У��
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
			//�����������
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
		//�ض�����Ʒ��ѯ�б�
//		return "redirect:items/queryItems.action";
		//ҳ��ת��
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
	
	//restFull,URI��ѯ��Ʒ��Ϣ�����json
	///itemsView/{id}��ߵ�{id}��ʾռλ����ͨ��@PathVariable��ȡռλ���еĲ�����
	//���ռλ���е����ƺ��β���һ�£���@PathVariable���Բ�ָ������
	@RequestMapping("/itemsView/{id}")
	public @ResponseBody ItemsCustom itemsView(@PathVariable("id") Integer id)throws Exception{
		
		//����service��ѯ��Ʒ��Ϣ
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		
		return itemsCustom;
		
	}
	
	
}
