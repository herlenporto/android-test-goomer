import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		double total = 0;
		String adicionarMaisItem = "1";
		List<Item> pedidos = new ArrayList<Item>();
		Cardapio cardapio = criarItensECardapio();
		String confirmarPedido = "";

		while (adicionarMaisItem.equals("1")) {
			mostrarItens(cardapio);

			System.out.println("Selecione o codigo do Item.");
			String codigo = sc.next();
			Item item = cardapio.retornarItemPorCodigo(codigo);

			if (Objects.nonNull(item)) {
				System.out.println("Informe a quantidade de Itens:");
				int quantidade = sc.nextInt();
				item.setQuantidade(quantidade);

				pedidos.add(item);
			} else {
				System.out.println("Código de produto invalido");
			}

			System.out.println("Deseja mais algum Item? 1 - SIM, Qualquer outro valor - NAO");
			adicionarMaisItem = sc.next();

		}

		for (Item item : pedidos) {
			System.out.println(item.toString() + ", Quantidade: " + item.getQuantidade());
		}

		System.out.println("Confirma o pedido no valor total de: R$ " + calcularTotalPedido(pedidos)
				+ " (1 - SIM, Qualquer outro valor - NAO)");
		confirmarPedido = sc.next();

		if (confirmarPedido.equals("1")) {
			System.out.println("Pedido enviado para a cozinha com sucesso!");
		} else
			System.out.println("Pedido cancelado.");

	}

	private static double calcularTotalPedido(List<Item> pedidos) {
		double total = 0;

		for (Item item : pedidos) {
			total += item.getQuantidade() * item.getPreco();
		}

		return total;
	}

	private static void mostrarItens(Cardapio cardapio) {
		System.out.println("Cardapio:");

		for (Item item : cardapio.retonarItens()) {
			System.out.println(item.toString());
		}
	}

	private static Cardapio criarItensECardapio() {
		Item hamburguer = new Item("001", "xBurguer", 10.50);
		Item pizza = new Item("002", "calabresa", 15.00);
		Item refrigerante = new Item("003", "guarana", 5.50);

		Cardapio cardapio = new Cardapio();

		cardapio.adicionarItem(hamburguer);
		cardapio.adicionarItem(pizza);
		cardapio.adicionarItem(refrigerante);

		return cardapio;
	}

}
