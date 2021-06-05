package kodlamaio.hrms.core.adapters;

public class MernisValidation {

		public static boolean isRealPerson(String tcno) {
			
			return FakeMernisService.validate(tcno);
	    }

}
