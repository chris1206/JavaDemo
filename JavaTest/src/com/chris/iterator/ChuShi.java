package com.chris.iterator;

public class ChuShi extends Employee implements VIP{
	public ChuShi(){}
	
	public ChuShi(String name,String id){
		super(name,id);
	}
	
	public void work(){
		System.out.println("我是厨师");
	}

	public void services(){
		System.out.println("我提供炒菜服务");
	}
}
