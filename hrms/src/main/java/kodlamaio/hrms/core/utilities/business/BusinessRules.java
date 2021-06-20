package kodlamaio.hrms.core.utilities.business;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

public class BusinessRules {

	public static Result run(Result... logics) {
		for (Result logic : logics) {
			if (!logic.isSuccess()) {
				return new ErrorResult(logic.getMessage());
			}
		}
		return new SuccessResult();
	}
}
