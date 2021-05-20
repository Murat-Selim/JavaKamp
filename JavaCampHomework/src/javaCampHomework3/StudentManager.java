package javaCampHomework3;

public class StudentManager extends UserManager {
		
		public void addComment() {
			System.out.println("yorum eklendi");
		}
		public void addAddress(Student student,String address) {
			student.setAddress(address);
			System.out.println("Öðrenci adresi deðiþtirildi:"+student.getAddress());
			
		}
		public void uploadHomework() {
			System.out.println("ödev sisteme yüklendi");
		}
		
}
