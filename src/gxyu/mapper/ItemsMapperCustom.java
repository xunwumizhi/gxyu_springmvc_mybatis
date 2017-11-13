package gxyu.mapper;

import gxyu.po.ItemsCustom;
import gxyu.po.ItemsQueryVo;

import java.util.List;

public interface ItemsMapperCustom {
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
