package com.kh.MVC.ProductsAdd;

import java.util.List;

public class ProductController {
	private ProductDAO dao;
	
	public ProductController(ProductDAO dao) {
		this.dao = dao;
	}
	
	//총 가격 계산하는 메서드
	public double calculateTotalPrice(List<ProductDTO> products) {
		double totalPrice = 0;
		//향상 된 for문을 사용하여 가격을 더해줌.
		for(ProductDTO totalP : products) {
			totalPrice += totalP.getPrice();
		}
		return totalPrice;
	}
	
	//모든 제품의 리스트
	public List<ProductDTO> getAllProducts(){
		return dao.getAllProducts();
	}
}
