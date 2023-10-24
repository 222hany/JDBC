package com.kh.MVC.shopping;

import java.util.List;

public class ShoppingController {
	private ShoppingDAO dao;
	public ShoppingController(ShoppingDAO dao) {
		this.dao = dao;
	}
	
	//총 가격 계산하는 메서드
	public double calculateTotalPrice(List<ShoppingDTO> products) {
		double totalPrice = 0;
		//향상 된 for문을 사용하여 가격을 더해줌
		for(ShoppingDTO totalP : products) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;
	}
	
	//모든 제품의 리스트
	public List<ShoppingDTO> getAllProducts(){
		return dao.getAllProducts();
	}
}