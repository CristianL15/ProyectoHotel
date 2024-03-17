package Hotel;

public class Chef extends Employees{
	private Lectura input = new Lectura();
	private int ordenNo;
	private double priceOrder;
	private double overPrice = 1;
	
	public Chef(String name, int id, int phoneNo, String location, int salary, String role) {
		super(name, id, phoneNo, location, salary, role);
	}

	public double takeOrders(String name, int ordenNo){
		if ("french".equals(this.getLocation().toLowerCase())) {
			this.overPrice = 1.15;
		}

		switch (this.ordenNo) {
				case 1:
						this.priceOrder = 12000 * this.overPrice;
						break;
				case 2:
						this.priceOrder = 16000 * this.overPrice;
						break;
				case 3:
						this.priceOrder = 20000 * this.overPrice;
						break;
				case 4:
						this.priceOrder = 10000 * this.overPrice;
						break;
				default:
						break;
		}
	
		return this.priceOrder;
	}

	public void alterMenu(Menu menu) {
		System.out.println("[1] Agregar nuevo item al menú");
		System.out.println("[2] Remover item del menú");
		int option;
		do {
			option = input.repeatIntValidity(getLocation());
		} while (1 < option || option > 2);

		if (option == 1) {
			String name = input.readLongString("Ingrese el nombre del platillo");
			int id = input.repeatIntValidity("Ingrese el id o código para registrar el platillo");
			double price = input.repeatDoubleValidity("Ingrese el precio del platillo");
			menu.addFoodItem(new FoodItem(name, id, price));
		} else {
			int id = input.repeatIntValidity("Ingrese el id o código del platillo");
			menu.removeFoodItem(id);
		}
	}

}