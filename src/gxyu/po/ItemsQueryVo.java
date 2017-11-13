package gxyu.po;

import java.util.List;

import gxyu.po.ItemsCustom;

public class ItemsQueryVo {
	private Items items;
	private ItemsCustom itemsCustom;
	private List<ItemsCustom> itemsList;
	
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}
	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}
}
