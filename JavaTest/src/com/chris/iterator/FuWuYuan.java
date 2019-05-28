package com.chris.iterator;

public class FuWuYuan extends Employee implements VIP{
	public FuWuYuan() {
		super();
		
	}
	public FuWuYuan(String name, String id) {
		super(name, id);
		
	}
	
	public void work(){
		System.out.println("我是服务员");
	}
	


	public void services(){
		System.out.println("我提供上菜服务");
	}
}
