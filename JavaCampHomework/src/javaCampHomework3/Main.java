package javaCampHomework3;


public class Main {

	public static void main(String[] args) {
		
		StudentManager studentManager = new StudentManager();
		InstructorManager instructorManager = new InstructorManager();
		
		Student student1=new Student(1, "Murat", "selim", "murat@gmail.com", "12345","Istanbul");
		
		Instructor instructor1=new Instructor(1, "Engin", "Demiroğ", "engin@gmail.com", "123456", "Yazılım, Programlama");
		
		
		studentManager.add(student1);
		studentManager.update(student1);
		studentManager.addAddress(student1, "Sakarya");
		studentManager.addComment();
		studentManager.uploadHomework();
				
		instructorManager.add(instructor1);
		instructorManager.addCourse();
		instructorManager.deleteCourse();
		
		

	}

}
