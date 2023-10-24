package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	//ArrayList
	private List<ShoppingDTO> cartList;
	//����īƮ ������
	public ShoppingCart() {
		cartList = new ArrayList<>();
	}
	//��ٱ��� ��� �������� �ٸ޼��� ����
	public List<ShoppingDTO> getCartList(){
		return cartList;
	}
	//���� ���� �ݾ� �޼��� ����
	public double cartTotalPrice() {
		double totalPrice = 0;
		//���� for���� �̿��Ͽ� ���� �߰�
		for(ShoppingDTO c : cartList) {
			totalPrice += c.getPrice();
		}
		return totalPrice;
	}
	//��ٱ��Ͽ� �߰� �� �޼��� ����
	public void addCart(ShoppingDTO product) {
		cartList.add(product);
		System.out.println(product.getProductName() + "�� ��ٱ��Ͽ� �߰��߽��ϴ�.");
	}
	//��ٱ��Ͽ� ���� �� �޼��� ����
	public void removeGoods(ShoppingDTO product) {
		if(cartList.remove(product)) {
			System.out.println("��ٱ��Ͽ��� �����߽��ϴ�.");
		}else {
			System.out.println("��ٱ��Ͽ� �ش� ��ǰ�� �����ϴ�.");
		}
	}
}
