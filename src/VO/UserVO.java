package VO;

import java.util.Objects;

public class UserVO {
	private String name;
	private String phone;
	private String id;
	private String pw;

	public UserVO() {
		
	}

	public UserVO(String name, String phone, String id, String pw) {
		
		this.name = name;
		this.phone = phone;
		this.id = id;
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "UserVO [name=" + name + ", phone=" + phone + ", id=" + id + ", pw=" + pw + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, phone, pw);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserVO other = (UserVO) obj;
		return Objects.equals(id, other.id) && Objects.equals(name, other.name) && Objects.equals(phone, other.phone)
				&& Objects.equals(pw, other.pw);
	}

	
	
}
