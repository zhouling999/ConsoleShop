package com.qst.shop;

import java.math.BigDecimal;

public class Good implements Cloneable{
	   private int id;
	   private String name;
	   private BigDecimal price;
	   private int num;
	   
	   
	   @Override
	   public Good clone(){
		   Good g1 = new Good();
		   try {
			   g1 = (Good)super.clone();
		   }catch(CloneNotSupportedException e){
			   e.printStackTrace();
		   }
		   return g1;
	   }
	   
	   public Good(){
		   
	   }
	   public Good(int id,String name,BigDecimal price,int num){
		   this.id = id;
		   this.name = name;
		   this.price = price;
		   this.num = num;
	   }
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString(){
		return "id="+id+",name="+name+",price="+price+",num="+num;
	}
}
