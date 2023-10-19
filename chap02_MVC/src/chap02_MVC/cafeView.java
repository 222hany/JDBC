package chap02_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel�̶�� Ŭ������ ������ ���� ���� ��������� ī����� �߰�.
	public cafeModel model;
	
	//model �Ű������� ���� �� �ִ� �����ڸ� �������� ��.
	public cafeView(cafeModel model) {
		this.model = model;
	}
	
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ������ �Է��ϼ���.");
		System.out.println("��ȣ�� : ");
		String name = sc.nextLine();
		System.out.println("ī���ּ� : ");
		String address = sc.nextLine();
		System.out.println("��ȭ��ȣ : ");
		String phoneNumber = sc.nextLine();
		System.out.println("��ð� : ");
		String operatingHours = sc.nextLine();
		
		//ī��𵨿��� insertCafe ��� �޼��带 ������ �;� ��. = ������� �߰�.
		model.insertCafe(name, address, phoneNumber, operatingHours);
		System.out.println("ī�䰡 ���������� �߰��Ǿ����ϴ�.");
	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ������ ������Ʈ �ϼ���.");
		System.out.print("���� �� �޴����� : ");
		String menuDescription = sc.nextLine();
		System.out.print("�޴�ID : ");
		int menuId = sc.nextInt();
		System.out.print("ī��ID : ");
		int cafeId = sc.nextInt();
		
		model.updateMenu(menuDescription, menuId, cafeId);
		System.out.println("�޴� ������ ���������� ���� �Ǿ����ϴ�.");
	}
	
	public void updateCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�� ��ð��� ������Ʈ �ϼ���.");
		System.out.print("��ð� ���� ������ �ۼ��� �ּ���.");
		String operatingHours = sc.nextLine();
		System.out.print("������Ʈ �� ī���� ID : ");
		int cafeId = sc.nextInt();
		sc.close();
		
		model.updateCafe(operatingHours, cafeId);
		System.out.println("��ð��� ���������� ���� �Ǿ����ϴ�.");
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("ī�並 �����մϴ�.");
		System.out.println("���� �� ī��ID�� �Է��ϼ���.");
		int cafeId = Integer.parseInt(sc.nextLine()); // ��ȣ�� 0���� ���� �� ���, 0�� ���� ���Ұ�츦 ����ؼ� ��Ʈ������ �о��.
		sc.close();
		
		model.deleteCafe(cafeId);
		
		System.out.println("ī�䰡 ���� �Ǿ����ϴ�.");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴��� �����մϴ�.");
		System.out.println("������ �޴�ID�� �Է����ּ���.");
		int menuId = Integer.parseInt(sc.nextLine());
		System.out.println("������ ī��ID�� �Է����ּ���.");
		int cafeId = Integer.parseInt(sc.nextLine());
		sc.close();
		
		model.deleteMenu(menuId, cafeId);
		
		System.out.println("�޴��� ���������� �����Ǿ����ϴ�.");
	}
	
	public void deleteOrders() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�ֹ��� ����մϴ�.");
		System.out.println("��� �� �ֹ���ȣ�� �Է����ּ���");
		int orderId = sc.nextInt();
		sc.close();
		
		model.deleteOrders(orderId);
		System.out.println("�ֹ��� ���������� ��ҵǾ����ϴ�.");
	}
	
	public void selectMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("�޴� ID�� �Է����ּ���.");
		int menuId = sc.nextInt();
		
		model.selectMenu(menuId);
	}
	
}