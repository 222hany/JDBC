package com.kh.MVC.orders;

import java.util.List;

public class OrderView {
	public void showOrderList(List<OrderDTO> orders) {
		for(OrderDTO o : orders) {
			System.out.println("==����īƮ�� �߰� �� ǰ��==");
			System.out.println("��ǰ�� : " + o.getProductName());
			System.out.println("���� : " + o.getPrice());
			System.out.println("====================");
		}
	}
	
	public void showTotalPrice(double totalPrice) {
		System.out.println("�� �ֹ� �ݾ� : " + totalPrice);
	}
}
