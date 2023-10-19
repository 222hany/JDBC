package chap02_MVC;

import java.util.Scanner;

public class cafeController {
	public cafeModel model;
	public cafeView view;
	
	//�𵨰� �並 ������ �� ������
	public cafeController(cafeModel model, cafeView view) {
		this.model = model;
		this.view = view;
	}
	
	//run
	public void run() {
		boolean isTrue = true;
		while(isTrue) {
			Scanner sc = new Scanner(System.in);
			//������ ��ȣ ��� �޼���� �Է�
			System.out.println("1.ī�� ���� �߰�");
			System.out.println("2.�޴� ���� ����");
			System.out.println("3.�޴� ����");
			System.out.println("4.���α׷� ����");
			System.out.println("���ϴ� �۾��� �������ּ���.");
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
				System.out.println("���α׷��� �����մϴ�.");
				isTrue = !isTrue;
				break;
			default :
				System.out.println("�߸��� ��ȣ�Դϴ�.");
			}
		}
	}
	
}