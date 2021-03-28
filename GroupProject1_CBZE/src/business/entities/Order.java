package business.entities;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Order represents the order of a product for the store.
 * 
 * @author Zachary Boling-Green, Brian Le, Ethan Nunn and Colin Bolduc
 *
 */
public class Order implements Serializable {
	private static final long serialVersionUID = 1L;
	private static final String ORDER_STRING = "O";
	private static int idCounter;
	private String id;
	private String productId;
	private int quantity;

	/**
	 * Creates a single order, generating a unique order id.
	 * 
	 * @param productId product id of product to be ordered.
	 * @param quantity  quantity of product to be ordered.
	 */
	public Order(String productId, int quantity) {
		this.id = ORDER_STRING + ++idCounter;
		this.productId = productId;
		this.quantity = quantity;
	}

	/**
	 * Getter for order id
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Getter for product id of ordered product
	 * 
	 * @return product id
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * Getter for quantity of product to be ordered
	 * 
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter for product id
	 * 
	 * @param productId
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * Setter for product quantity
	 * 
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((productId == null) ? 0 : productId.hashCode());
		result = prime * result + quantity;
		return result;
	}

	/**
	 * Checks whether the order is equal to the one supplied
	 * 
	 * @param object the order who should be compared
	 * @return true iff the order ids and product ids respectively match
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		if (quantity != other.quantity)
			return false;
		return true;
	}

	/**
	 * String form of the order
	 * 
	 */
	@Override
	public String toString() {
		return "Order [id=" + id + ", productId=" + productId + ", quantity="
				+ quantity + "]";
	}

	public static void save(ObjectOutputStream output) throws IOException {
		output.writeObject(idCounter);
	}

	public static void retrieve(ObjectInputStream input)
			throws IOException, ClassNotFoundException {
		idCounter = (int) input.readObject();
	}

}
