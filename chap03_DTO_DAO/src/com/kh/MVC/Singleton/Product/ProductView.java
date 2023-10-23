package com.kh.MVC.Singleton.Product;

import java.sql.SQLException;
import java.util.Scanner;

public class ProductView {
	public void addProduct() {
		Scanner sc = new Scanner(System.in);
		
		/*
		System.out.println("새 제품 정보를 입력하세요.");
		
		System.out.println("제품 ID : ");
		int productID = sc.nextInt();
		System.out.println("제품 이름 : ");
		String productName = sc.next();
		System.out.println("카테고리 : ");
		String category = sc.next();
		System.out.println("가격 : ");
		double price = sc.nextDouble();
		System.out.println("재고 : ");
		int quantity = sc.nextInt();
		*/
		
		System.out.println("업데이트 할 제품의 정보를 입력하세요.");
		System.out.println("변경하고 싶은 카테고리명 : ");
		String category = sc.next();
		System.out.println("제품 ID : ");
		int productID = sc.nextInt();
		
		
		// 스캐너로 받은 제품 내용을 새로 추가하기
		
		ProductDTO newProduct = new ProductDTO(category, productID); // INSERT는 (productID, productName, category, price, quantity)
		ProductModel productModel;
		boolean success = false; // 제품을 성공적으로 추가했는지 아닌지 확인하기 위한 success.
		
		try {
			productModel = ProductModel.getInstance();
			success = productModel.insertProduct(newProduct); // success는 없어도 되지만 제품이 잘 들어갔는지 확인하기 위해서 붙인 것!
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(success) {
			System.out.println("제품이 성공적으로 업데이트되었습니다.");
		} else {
			System.out.println("제품 추가 중 오류가 발생했습니다.");
		}
		
		// 스캐너 닫기
		sc.close();
		
	}
}