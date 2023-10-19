package chap02_MVC;

public class Main {
	public static void main(String[] args) {
		//Ä«Æä¸ðµ¨°ú Ä«Æäºä¸¦ °¡Áö°í ¿È.
		cafeModel model = new cafeModel();
		cafeView view = new cafeView(model);
		
		//controller¸¦ ¸¸µé¾î ÁÜ.
		cafeController controller = new cafeController(model, view);
		
		//view.addCafeName();
		//view.updateMenu();
		//view.updateCafe();
		//view.deleteCafe();
		//view.deleteMenu();
		//view.deleteOrders();
		controller.run();
	}
}