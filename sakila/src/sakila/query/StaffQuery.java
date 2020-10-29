package sakila.query;

public class StaffQuery {

	public final static String SELECT_STAFF_BY_KEY = "SELECT staff_id, store_id, email, username FROM staff WHERE email = ? AND password = PASSWORD(?)";
	public final static String SELECT_STAFF = "SELECT sl.name, sl.phone, sl.address, s.email, s.username, s.picture FROM staff_list AS sl LEFT JOIN staff AS s ON sl.ID = s.staff_id WHERE s.staff_id = ?";

}
