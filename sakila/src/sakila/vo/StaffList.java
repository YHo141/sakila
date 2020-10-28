package sakila.vo;

public class StaffList {
	private String Staffusername;
	private String StaffName;
	private String Staffphone;
	private String StaffAddress;
	private String StaffCity;
	private String StaffCountry;
	private String StaffEmail;
	
	public String getStaffusername() {
		return Staffusername;
	}
	public void setStaffusername(String staffusername) {
		Staffusername = staffusername;
	}
	public String getStaffName() {
		return StaffName;
	}
	public void setStaffName(String staffName) {
		StaffName = staffName;
	}
	public String getStaffphone() {
		return Staffphone;
	}
	public void setStaffphone(String staffphone) {
		Staffphone = staffphone;
	}
	public String getStaffAddress() {
		return StaffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		StaffAddress = staffAddress;
	}
	public String getStaffCity() {
		return StaffCity;
	}
	public void setStaffCity(String staffCity) {
		StaffCity = staffCity;
	}
	public String getStaffCountry() {
		return StaffCountry;
	}
	public void setStaffCountry(String staffCountry) {
		StaffCountry = staffCountry;
	}
	
	public String getStaffEmail() {
		return StaffEmail;
	}
	public void setStaffEmail(String staffEmail) {
		StaffEmail = staffEmail;
	}
	
	@Override
	public String toString() {
		return "StaffList [Staffusername=" + Staffusername + ", StaffName=" + StaffName + ", Staffphone=" + Staffphone
				+ ", StaffAddress=" + StaffAddress + ", StaffCity=" + StaffCity + ", StaffCountry=" + StaffCountry
				+ ", StaffEmail=" + StaffEmail + "]";
	}

}
