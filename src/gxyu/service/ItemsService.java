package gxyu.service;

import java.util.List;

import gxyu.po.ItemsCustom;
import gxyu.po.ItemsQueryVo;

public interface ItemsService {
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
	public ItemsCustom findItemsById(Integer id) throws Exception;
	
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;

}
