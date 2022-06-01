import java.util.ArrayList;
import java.util.List;

public class Cardapio {

	private List<Item> itens;

	public Cardapio() {
		this.itens = new ArrayList<Item>();
	}

	public void adicionarItem(Item item) {
		this.itens.add(item);
	}

	public void removerItem(Item item) {
		this.itens.remove(item);
	}

	public List<Item> retonarItens() {
		return this.itens;
	}

	public Item retornarItemPorCodigo(String codigo) {
		for (Item item : itens) {
			if (item.getCodigo().equals(codigo))
				return item;
		}
		return null;
	}

}
