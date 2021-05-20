package javaCampHomework3;

public class Student extends User {
		private String address;
		
		public Student(int id,String firstName,String lastName,String email,String password,String address) {
			super(id,firstName,lastName,email,password);
			this.setAddress(address);
		}
		
		public String getAddress() {
			return this.address;
		}
		public void setAddress(String address) {
			this.address=address;
		}
		
		
}
