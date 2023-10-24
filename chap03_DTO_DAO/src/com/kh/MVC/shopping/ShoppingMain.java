package com.kh.MVC.shopping;

import java.util.List;
import java.util.Scanner;

import com.kh.MVC.ProductsAdd.ProductDTO;

public class ShoppingMain {
	public static void main(String[] args) {
		ShoppingDAO dao = new ShoppingDAO();
		ShoppingController controller = new ShoppingController(dao);
		ShoppingView view = new ShoppingView();
		List<ShoppingDTO> products = controller.getAllProducts();
		
		Scanner sc = new Scanner(System.in);
		//쇼핑카트 인스턴스 생성
		ShoppingCart cart = new ShoppingCart();
		int choice = sc.nextInt();
		switch(choice) {
			case 1 : //모든 제품 리스트 가져오기
				view.showCartContents(products);
				break;
			
			case 2 : //최종가격 계산 가져오기
				double totalPrice = controller.calculateTotalPrice(products);
				view.showTotalPrice(totalPrice);
				break;
				
			case 3 : //장바구니 추가
				System.out.println("장바구니에 추가 할 상품 ID를 입력하세요.");
				//제품 ID 입력받기
				int productId = sc.nextInt();
				//향상된 for문과 if문을 활용하여 제품 담기
				for(ShoppingDTO s : products) {
					if(s.getProductId() == productId) {
						//카트에 추가
						cart.addCart(s);
						System.out.println(s.getProductName() + "을 장바구니에 담았습니다.");
						break;
					}
				}
			case 4 : //장바구니 제거
				System.out.println("장바구니에서 제거 할 제품의 ID를 입력하세요.");
				int removeProductId = sc.nextInt();
				for(ShoppingDTO r : cart.getCartList()) {
					if(r.getProductId() == removeProductId) {
						//카트에서 삭제
						cart.removeGoods(r);
						break;
					}
				}
			case 5 : //결제
				UserPay pay = new UserPay(cart);
				boolean payResult = pay.payment();
				if(payResult) {
					//카트 비우기
				}
				break;
			default :
				System.out.println("잘못된 선택입니다.");
		}
	}
}