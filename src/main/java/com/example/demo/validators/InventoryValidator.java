package com.example.demo.validators;
import com.example.demo.domain.Part;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class InventoryValidator implements ConstraintValidator<ValidInventory, Part> {

    @Override
    public void initialize(ValidInventory constraintAnnotation) {
        // No initialization needed, but method must be present
    }

    @Override
    public boolean isValid(Part part, ConstraintValidatorContext constraintValidatorContext) {
        if (part.getInv() > part.getMaxInv()) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                            "Inventory must be less than or equal to max inventory")
                    .addPropertyNode("inv")
                    .addConstraintViolation();
            return false;
        }

        else if (part.getInv() < part.getMinInv()) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(
                            "Inventory must be greater than or equal to min inventory")
                    .addPropertyNode("inv")
                    .addConstraintViolation();
            return false;
        }

        return true;
    }
}
