package Src;

public class Chef extends Employees{
	private Lectura input = new Lectura();
	private int ordenNo;
	private double priceOrder;
	private double overPrice = 1;

	public Chef(String name, String id, String phoneNo, String location, double salary, Hotel hotel) {
		super(name, id, phoneNo, location, salary, hotel);
	}

	//HISTORIA DE USUARIO 4
	public void takeOrder(){

	}

	//DIFERENTES MENUS -> BUSCAR COMO PASAR UN MENU AL CHEF
	public void alterMenu(Menu menu) {
		System.out.println("[1] Agregar nuevo item al menú");
		System.out.println("[2] Remover item del menú");
		int option;
		do {
			option = input.repeatIntValidity(getLocation());
		} while (option > 2);

		if (option == 1) {
			String name = input.readString("Ingrese el nombre del platillo");
			int id = input.repeatIntValidity("Ingrese el id o código para registrar el platillo");
			double price = input.repeatDoubleValidity("Ingrese el precio del platillo");
			menu.addFoodItem(new FoodItem(name, id, price));
		} else {
			int id = input.repeatIntValidity("Ingrese el id o código del platillo");
			menu.removeFoodItem(id);
		}
	}

}