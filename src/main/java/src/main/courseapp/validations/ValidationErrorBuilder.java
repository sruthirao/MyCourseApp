package src.main.courseapp.validations;

import org.springframework.validation.Errors;

public class ValidationErrorBuilder {

	public static ValidationError fromBindingErrors(Errors errors) {
		ValidationError error = new ValidationError("Validation failed. " + errors.getErrorCount() + " error(s)");
		errors.getAllErrors().forEach(e -> error.addValidationError(e.getDefaultMessage()));
		return error;
	}

}
