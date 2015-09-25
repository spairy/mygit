package com.mvc.func.validation.hibernate;

import java.util.ArrayList;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.apache.commons.lang.StringUtils;
import org.hibernate.validator.HibernateValidator;
import org.hibernate.validator.HibernateValidatorConfiguration;
import org.springframework.stereotype.Service;

@Service
public class ValidationHelper {
	/** The validator variable. */
    private final transient Validator validator;
    
    /**
     * The default Constructor for validationHelper.java.
     */
    public ValidationHelper() {

        HibernateValidatorConfiguration config = Validation.byProvider(
                HibernateValidator.class).configure();
        ValidatorFactory factory = config.buildValidatorFactory();
        this.validator = factory.getValidator();
    }
    
    /**
     * The doValidate() method.
     *
     * @param bean
     *            To get the DTO object from the module.
     * @return returns the List<errorInfo> list to the calling method.
     */
    public ArrayList<ErrorInfo> doValidate(final Object bean) {
        final ArrayList<ErrorInfo> errors = new ArrayList<ErrorInfo>();

        try {
            Set<ConstraintViolation<Object>> constraintViolations = validator.validate(bean);
            ErrorInfo errorInfo = null;
            if (!constraintViolations.isEmpty()) {
                for (ConstraintViolation<Object> constraintViolation : constraintViolations) {
                    errorInfo = new ErrorInfo(constraintViolation.getMessage());

                    String path = constraintViolation.getPropertyPath().toString();
                    String[] properties = path.split("\\.");
                    String concatenatedPath = StringUtils.EMPTY;
                    if (properties.length > 1) {
                        concatenatedPath = StringUtils.replace(path.substring(0, path.lastIndexOf(".")), ".", "_");
                    }

                    String lastNode = properties[properties.length - 1];

                    String[] multipleFields = StringUtils.split(lastNode, "_");
                    for (String field : multipleFields) {
                        if (properties.length > 1) {
                            if (field.startsWith("[") && field.endsWith("]")) {
                                errorInfo.addErrorParameter(concatenatedPath + field);
                            } else {
                                errorInfo.addErrorParameter(concatenatedPath + "_" + field);
                            }
                        } else {
                            errorInfo.addErrorParameter(field);
                        }
                    }
                    errors.add(errorInfo);
                }
            }
        } catch (Exception exception) {
        	exception.printStackTrace();
        }
        return errors;
    }
}
