package com.kh.MVC.shopping;

import java.util.List;

public class ShoppingView {
	public void showCartContents(List<ShoppingDTO> products) {
		for (ShoppingDTO s : products) {
			System.out.println("��ǰ��: " + s.getProductName() + "    ����: " + s.getPrice());
			System.out.println("==========================");
		}
	}
	
	//��ǰ ���� ���� �޼���
	public void showTotalPrice(double totalPrice) {
		System.out.println("�� ���� : " + totalPrice);
	}
}