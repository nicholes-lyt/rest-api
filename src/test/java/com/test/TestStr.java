package com.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TestStr {
	public static void main(String[] args) {
		List<TestData> list = new ArrayList<>();
		for(int i=0;i<4;i++) {
			TestData d = new TestData();
			d.setK("2018-01-09");
			d.setV("d"+i);
			list.add(d);
		}
		TestData d2 = new TestData();
		d2.setK("2018-01-10");
		d2.setV("d10");
		list.add(d2);
		System.out.println(list);
		
		
		List<String> date = new ArrayList<>();
		date.addAll(list.stream().map(p->{return p.getK();}).distinct().collect(Collectors.toList()));
		System.out.println(date);
		Map<String, List<String>> map = new HashMap<>();
		List<String> d = new ArrayList<>();
		for(String s : date) {
			for(TestData t : list) {
				if(t.getK().equals(s)) {
					d.add(t.getV());
				}
			}
		}
		System.out.println(d);
		System.out.println(map);
		
		System.out.println(groupData(list));
		
		Map<String, List<TestData>> map2 = list.stream().collect(Collectors.groupingBy(TestData::getK));
		System.out.println(map2);
	}
	
	
	private static Map<String,List<TestData>> groupData(List<TestData> list){
		Map<String,List<TestData>> map = new HashMap<>();
		for(TestData s : list) {
			if(map.containsKey(s.getK())) {
				map.get(s.getK()).add(s);
			}else{
				 List<TestData> tmpList = new ArrayList<>();  
	             tmpList.add(s);  
	             map.put(s.getK(), tmpList);  
			}
		}
		return map;
	}
	
}	

class TestData{
	private String k;
	private String v;
	public String getK() {
		return k;
	}
	public void setK(String k) {
		this.k = k;
	}
	public String getV() {
		return v;
	}
	public void setV(String v) {
		this.v = v;
	}
	@Override
	public String toString() {
		return "TestData [k=" + k + ", v=" + v + "]";
	}
	
	
	
}