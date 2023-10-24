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
		//����īƮ �ν��Ͻ� ����
		ShoppingCart cart = new ShoppingCart();
		int choice = sc.nextInt();
		switch(choice) {
			case 1 : //��� ��ǰ ����Ʈ ��������
				view.showCartContents(products);
				break;
			
			case 2 : //�������� ��� ��������
				double totalPrice = controller.calculateTotalPrice(products);
				view.showTotalPrice(totalPrice);
				break;
				
			case 3 : //��ٱ��� �߰�
				System.out.println("��ٱ��Ͽ� �߰� �� ��ǰ ID�� �Է��ϼ���.");
				//��ǰ ID �Է¹ޱ�
				int productId = sc.nextInt();
				//���� for���� if���� Ȱ���Ͽ� ��ǰ ���
				for(ShoppingDTO s : products) {
					if(s.getProductId() == productId) {
						//īƮ�� �߰�
						cart.addCart(s);
						System.out.println(s.getProductName() + "�� ��ٱ��Ͽ� ��ҽ��ϴ�.");
						break;
					}
				}
			case 4 : //��ٱ��� ����
				System.out.println("��ٱ��Ͽ��� ���� �� ��ǰ�� ID�� �Է��ϼ���.");
				int removeProductId = sc.nextInt();
				for(ShoppingDTO r : cart.getCartList()) {
					if(r.getProductId() == removeProductId) {
						//īƮ���� ����
						cart.removeGoods(r);
						break;
					}
				}
			case 5 : //����
				UserPay pay = new UserPay(cart);
				boolean payResult = pay.payment();
				if(payResult) {
					//īƮ ����
				}
				break;
			default :
				System.out.println("�߸��� �����Դϴ�.");
		}
	}
}