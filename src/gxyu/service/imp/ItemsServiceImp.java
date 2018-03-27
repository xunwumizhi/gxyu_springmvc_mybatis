package gxyu.service.imp;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import gxyu.exception.CustomException;
import gxyu.mapper.ItemsMapper;
import gxyu.mapper.ItemsMapperCustom;
import gxyu.po.Items;
import gxyu.po.ItemsCustom;
import gxyu.po.ItemsQueryVo;
import gxyu.service.ItemsService;

public class ItemsServiceImp implements ItemsService{
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		// TODO Auto-generated method stub
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Items items = itemsMapper.selectByPrimaryKey(id);
		if(items==null){
			throw new CustomException("not exist！");
		}
		ItemsCustom itemsCustom = new ItemsCustom();
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom)
			throws Exception {
		// TODO Auto-generated method stub
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
	}
	
}
