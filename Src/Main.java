package Src;

public class Main{
	public static void main(String[] args) {
		//Initialize classes
		Hotel hotel = new Init().initialize();
		
		//UPDATE
		System.out.println("Bienvenido(a) al hotel " + hotel.getName() + ". Aquí serás una especie de Dios y podrás actuar como cualquier persona dentro del hotel");
		Update update = new Update(hotel);
		update.start();
	}
}