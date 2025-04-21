package com.shinhan.day11.t;

import java.util.Comparator;

public class DescendingInteger implements Comparator<Integer>{

	@Override
	public int compare(Integer obj1, Integer obj2) {
		// ascending :  < = >
		//앞에값을 먼저 작성하면 ascending 
		//뒤에값을 먼저작성하면 descending
		return obj2 - obj1;
	}

}
