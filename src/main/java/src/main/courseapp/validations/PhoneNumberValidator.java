package src.main.courseapp.validations;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<Phone, String>{

	@Override
	public void initialize(Phone param) {
		
	}

	@Override
	public boolean isValid(String phoneNumber, ConstraintValidatorContext context) {
		if(phoneNumber==null){
		return false;
		}
		 if (phoneNumber.matches("\\d{10}")) return true;
	        else if(phoneNumber.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) return true;
	        else if(phoneNumber.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) return true;
	        else if(phoneNumber.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) return true;
	        else return false;
		
	}

}
