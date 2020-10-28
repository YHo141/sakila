package sakila.query;

public class CustomerListQuery {
	public final static String SELECT_CUSTOMER_LIST = "SELECT c.ID, c.name, c.phone, c.notes FROM customer_list AS c";
}
