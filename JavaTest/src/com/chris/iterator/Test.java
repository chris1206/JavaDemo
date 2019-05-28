package com.chris.iterator;


public class Test {
	public static void main(String[] args) {
		JingLi jl = new JingLi("С��", "���»�001", 123456789.32);
		jl.work();
		
		FuWuYuan f1 = new FuWuYuan("�仨", "����001");
		FuWuYuan f2 = new FuWuYuan("���", "����002");
		
		f1.work();
		f1.services();
		
		f2.work();
		f2.services();
		
		ChuShi c1 = new ChuShi("�ϸ���", "���001");
		ChuShi c2 = new ChuShi("�ϸɵ�", "���002");
		
		c1.work();
		c1.services();
		
		c2.work();
		c2.services();
		
	
	}
}
