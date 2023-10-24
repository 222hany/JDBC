package com.kh.MVC.orders;

import java.util.List;

public class OrderMain {
	public static void main(String[] args) {
		OrderDAO dao = new OrderDAO();
		OrderController controller = new OrderController(dao);
		OrderView view = new OrderView();
		
		List<OrderDTO> orders = controller.shoppingCart();
		view.showOrderList(orders);
		
		double totalPrice = controller.caculateTotalPrice(orders);
		view.showTotalPrice(totalPrice);
	}
}
