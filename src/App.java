import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		boolean adicionarMaisItem = true;
		List<Item> pedidos = new ArrayList<Item>();

		Item hamburguer = new Item("001", "xBurguer", 10.50);
		Item pizza = new Item("002", "calabresa", 15.00);
		Item refrigerante = new Item("003", "guarana", 5.50);

		Cardapio cardapio = new Cardapio();

		cardapio.adicionarItem(hamburguer);
		cardapio.adicionarItem(pizza);
		cardapio.adicionarItem(refrigerante);

		System.out.println("Cardápio:");
		for (Item item : cardapio.retonarItens()) {
			System.out.println(item.toString());
		}

		while (adicionarMaisItem) {
			System.out.println("Selecione o código do Item.");
			String codigo = sc.next();
			Item item = cardapio.retornarItemPorCodigo(codigo);
			
			
			System.out.println("Informe a quantidade de Itens:");
			int quantidade = sc.nextInt();
			item.setQuantidade(quantidade);

			pedidos.add(item);
			
			System.out.println("Deseja mais algum Item?");
		}

	}

}
