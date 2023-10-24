package com.kh.MVC.shopping;

import java.util.List;

public class ShoppingController {
	private ShoppingDAO dao;
	public ShoppingController(ShoppingDAO dao) {
		this.dao = dao;
	}
	
	//�� ���� ����ϴ� �޼���
	public double calculateTotalPrice(List<ShoppingDTO> products) {
		double totalPrice = 0;
		//��� �� for���� ����Ͽ� ������ ������
		for(ShoppingDTO totalP : products) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;
	}
	
	//��� ��ǰ�� ����Ʈ
	public List<ShoppingDTO> getAllProducts(){
		return dao.getAllProducts();
	}
}