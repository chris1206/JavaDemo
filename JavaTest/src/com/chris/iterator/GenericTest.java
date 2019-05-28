package com.chris.iterator;

import java.util.ArrayList;
import java.util.Iterator;
public class GenericTest {
	public static void main(String[] args) {
		ArrayList<ChuShi> cs = new ArrayList<ChuShi>();
		ArrayList<FuWuYuan> fwy = new ArrayList<FuWuYuan>();
		ArrayList<JingLi> jl = new ArrayList<JingLi>();
		
		cs.add(new ChuShi("张三", "厨师001"));
		cs.add(new ChuShi("李四", "厨师002"));
		
		fwy.add(new FuWuYuan("服务王五", "FW001"));
		fwy.add(new FuWuYuan("服务赵六", "FW002"));
		
		jl.add(new JingLi("秦王", "JL001", 123456789.32));
		jl.add(new JingLi("康熙", "JL002", 123456789.33));
		
//		ArrayList<String> arrayString = new ArrayList<String>();
		iterator(jl);
		iterator(fwy);
		iterator(cs);
	
	}

	/**
	 * <? extends Employee>上限限定
	 * <? super Employee>下限限定
	 * @param array
	 */
	public static void iterator(ArrayList<? extends Employee> array){
		
		 Iterator<? extends Employee> it = array.iterator();
		 while(it.hasNext()){
			 Employee e = it.next();
			 e.work();
		 }
	}
}
