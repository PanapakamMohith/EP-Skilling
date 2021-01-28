package com.ep.bean;

public class Bean {

	private int itemid;
	private String itemname;
	private int cost;
	public Bean(int item_id,String item_name,int cost_of_item) {
		if(item_id >= 0 && item_name !=null && cost_of_item >= 0) {
			this.setItemid(item_id);
			this.setItemname(item_name);
			this.setCost(cost_of_item);
		}
	}
	public int getItemid() {
		return itemid;
	}
	public void setItemid(int itemid) {
		this.itemid = itemid;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	
}
