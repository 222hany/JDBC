package com.kh.MVC.shopping;

import java.util.List;

public class ShoppingView {
	public void showCartContents(List<ShoppingDTO> products) {
		for (ShoppingDTO s : products) {
			System.out.println("제품명: " + s.getProductName() + "    가격: " + s.getPrice());
			System.out.println("==========================");
		}
	}
	
	//제품 최종 가격 메서드
	public void showTotalPrice(double totalPrice) {
		System.out.println("총 가격 : " + totalPrice);
	}
}