package chap02_MVC;

import java.util.Scanner;

public class cafeView {
	//cafeModel이라는 클래스를 가지고 오기 위해 멤버변수로 카페모델을 추가.
	public cafeModel model;
	
	//model 매개변수를 받을 수 있는 생성자를 만들어줘야 함.
	public cafeView(cafeModel model) {
		this.model = model;
	}
	
	public void addCafeName() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 정보를 입력하세요.");
		System.out.println("상호명 : ");
		String name = sc.nextLine();
		System.out.println("카페주소 : ");
		String address = sc.nextLine();
		System.out.println("전화번호 : ");
		String phoneNumber = sc.nextLine();
		System.out.println("운영시간 : ");
		String operatingHours = sc.nextLine();
		
		//카페모델에서 insertCafe 라는 메서드를 가지고 와야 함. = 멤버변수 추가.
		model.insertCafe(name, address, phoneNumber, operatingHours);
		System.out.println("카페가 성공적으로 추가되었습니다.");
	}
	
	public void updateMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 설명을 업데이트 하세요.");
		System.out.print("수정 할 메뉴설명 : ");
		String menuDescription = sc.nextLine();
		System.out.print("메뉴ID : ");
		int menuId = sc.nextInt();
		System.out.print("카페ID : ");
		int cafeId = sc.nextInt();
		
		model.updateMenu(menuDescription, menuId, cafeId);
		System.out.println("메뉴 설명이 성공적으로 수정 되었습니다.");
	}
	
	public void updateCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페 운영시간을 업데이트 하세요.");
		System.out.print("운영시간 변경 내용을 작성해 주세요.");
		String operatingHours = sc.nextLine();
		System.out.print("엽데이트 할 카페의 ID : ");
		int cafeId = sc.nextInt();
		sc.close();
		
		model.updateCafe(operatingHours, cafeId);
		System.out.println("운영시간이 성공적으로 수정 되었습니다.");
	}
	
	public void deleteCafe() {
		Scanner sc = new Scanner(System.in);
		System.out.println("카페를 삭제합니다.");
		System.out.println("삭제 할 카페ID를 입력하세요.");
		int cafeId = Integer.parseInt(sc.nextLine()); // 번호가 0으로 시작 할 경우, 0을 읽지 못할경우를 대비해서 스트링으로 읽어옴.
		sc.close();
		
		model.deleteCafe(cafeId);
		
		System.out.println("카페가 삭제 되었습니다.");
	}
	
	public void deleteMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴를 삭제합니다.");
		System.out.println("삭제할 메뉴ID를 입력해주세요.");
		int menuId = Integer.parseInt(sc.nextLine());
		System.out.println("삭제할 카페ID를 입력해주세요.");
		int cafeId = Integer.parseInt(sc.nextLine());
		sc.close();
		
		model.deleteMenu(menuId, cafeId);
		
		System.out.println("메뉴가 정상적으로 삭제되었습니다.");
	}
	
	public void deleteOrders() {
		Scanner sc = new Scanner(System.in);
		System.out.println("주문을 취소합니다.");
		System.out.println("취소 할 주문번호를 입력해주세요");
		int orderId = sc.nextInt();
		sc.close();
		
		model.deleteOrders(orderId);
		System.out.println("주문이 정상적으로 취소되었습니다.");
	}
	
	public void selectMenu() {
		Scanner sc = new Scanner(System.in);
		System.out.println("메뉴 ID를 입력해주세요.");
		int menuId = sc.nextInt();
		
		model.selectMenu(menuId);
	}
	
}