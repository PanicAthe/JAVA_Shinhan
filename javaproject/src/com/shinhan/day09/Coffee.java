package com.shinhan.day09;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@EqualsAndHashCode(of = ("menuName"))
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString(exclude = "price")
public class Coffee extends Object {
	String menuName;
	int price;

//	@Override
//	public int hashCode() {
//		return menuName.hashCode() + price;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Coffee other = (Coffee) obj;
//		return Objects.equals(menuName, other.menuName) && price == other.price;
//	}

}
