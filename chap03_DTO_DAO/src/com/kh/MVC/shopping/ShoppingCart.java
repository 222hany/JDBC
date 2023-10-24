package com.kh.MVC.shopping;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
	//ArrayList
	private List<ShoppingDTO> cartList;
	//쇼핑카트 생성자
	public ShoppingCart() {
		cartList = new ArrayList<>();
	}
	//장바구니 목록 전달해줄 겟메서드 생성
	public List<ShoppingDTO> getCartList(){
		return cartList;
	}
	//최종 결제 금액 메서드 생성
	public double cartTotalPrice() {
		double totalPrice = 0;
		//향상된 for문을 이용하여 가격 추가
		for(ShoppingDTO c : cartList) {
			totalPrice += c.getPrice();
		}
		return totalPrice;
	}
	//장바구니에 추가 할 메서드 생성
	public void addCart(ShoppingDTO product) {
		cartList.add(product);
		System.out.println(product.getProductName() + "을 장바구니에 추가했습니다.");
	}
	//장바구니에 제거 할 메서드 생성
	public void removeGoods(ShoppingDTO product) {
		if(cartList.remove(product)) {
			System.out.println("장바구니에서 제거했습니다.");
		}else {
			System.out.println("장바구니에 해당 제품이 없습니다.");
		}
	}
}
