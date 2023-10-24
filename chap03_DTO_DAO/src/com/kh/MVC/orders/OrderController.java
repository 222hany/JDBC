package com.kh.MVC.orders;

import java.util.List;

public class OrderController {
	//DAO, View ����
	private OrderDAO dao;
	public OrderController(OrderDAO dao) {
		this.dao = dao;
	}
	//��ٱ��� �޼���
	public List<OrderDTO> shoppingCart(){
		return dao.shoppingCart();
	}
	
	//�� �ֹ� �ݾ� �޼���
	public double caculateTotalPrice(List<OrderDTO> orders) {
		double totalPrice = 0;
		for(OrderDTO totalP : orders) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;
	}
}
