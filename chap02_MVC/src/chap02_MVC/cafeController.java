package chap02_MVC;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//모델과 뷰를 가지고 올 생성자
	public cafeController(cafeModel model, cafeView view) {
		this.model = model;
		this.view = view;
	}
	
	//run
	public void run() {
		boolean isTrue = true;
		while(isTrue) {
			Scanner sc = new Scanner(System.in);
			//선택할 번호 출력 메서드로 입력
			System.out.println("1.카페 정보 추가");
			System.out.println("2.메뉴 설명 수정");
			System.out.println("3.메뉴 선택");
			System.out.println("4.프로그램 종료");
			System.out.println("원하는 작업을 선택해주세요.");
			int choice = sc.nextInt();
			
			switch(choice) {
			case 1 :
				view.addCafeName();
				break;
			case 2 :
				view.updateMenu();
				break;
			case 3 :
				view.selectMenu();
				break;
			case 4 :
				System.out.println("프로그램을 종료합니다.");
				isTrue = !isTrue;
				break;
			default :
				System.out.println("잘못된 번호입니다.");
			}
		}
	}
	
}