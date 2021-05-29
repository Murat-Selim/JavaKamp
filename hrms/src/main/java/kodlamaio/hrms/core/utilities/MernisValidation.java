package kodlamaio.hrms.core.utilities;

import kodlamaio.hrms.core.services.FakeMernisService;

public class MernisValidation {

		public static boolean isRealPerson(String tcno) {
			FakeMernisService mernis = new FakeMernisService();
			return FakeMernisService.validate(tcno);
	    }

}
