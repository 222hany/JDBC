package com.kh.MVC.orders;

import java.util.List;

public class OrderController {
	//DAO, View 연결
	private OrderDAO dao;
	public OrderController(OrderDAO dao) {
		this.dao = dao;
	}
	//장바구니 메서드
	public List<OrderDTO> shoppingCart(){
		return dao.shoppingCart();
	}
	
	//총 주문 금액 메서드
	public double caculateTotalPrice(List<OrderDTO> orders) {
		double totalPrice = 0;
		for(OrderDTO totalP : orders) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;
	}
}
