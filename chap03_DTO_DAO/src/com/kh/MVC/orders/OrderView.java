package com.kh.MVC.orders;

import java.util.List;

public class OrderView {
	public void showOrderList(List<OrderDTO> orders) {
		for(OrderDTO o : orders) {
			System.out.println("==쇼핑카트에 추가 된 품목==");
			System.out.println("제품명 : " + o.getProductName());
			System.out.println("가격 : " + o.getPrice());
			System.out.println("====================");
		}
	}
	
	public void showTotalPrice(double totalPrice) {
		System.out.println("총 주문 금액 : " + totalPrice);
	}
}
