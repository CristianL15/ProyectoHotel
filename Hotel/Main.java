package Hotel;

public class Main{
	public static void main(String[] args) {
		Hotel hotel = new Hotel("Casa Blanca", "Londres, Inglaterra, BakerStreet, 221B");
		System.out.println("Bienvenido(a) al hotel " + hotel.getName() + ". Aquí serás una especie de Dios y podrás actuar como cualquier persona dentro del hotel");
		// Update update = new Update();
		// update.start();
		int i = 3;
		while (i > 0){
			hotel.selectRoomType();
		}
	}
}