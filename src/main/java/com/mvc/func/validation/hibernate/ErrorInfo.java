package com.mvc.func.validation.hibernate;

import java.io.Serializable;
import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

public class ErrorInfo implements Serializable {

	private static final long serialVersionUID = -1574121018119937800L;

    private String code;

    private ArrayList<String> parameters;

    public ErrorInfo() {
    }

    public ErrorInfo(final String errCode) {
        this.code = errCode;
    }

    public final void addErrorParameter(final String parameter) {
        if (parameter != null) {
            if (parameters == null) {
                parameters = new ArrayList<String>(0);
            }
            if (!StringUtils.isBlank(parameter)) {
                parameters.add(parameter);
            }
        }
    }

    public final String getCode() {
        return code;
    }

    public final void setCode(final String errCode) {
        this.code = errCode;
    }

    public final boolean isErrorInfo(final String errCode) {
        boolean result = false;
        if (this.code != null) {
            result =  this.code.equals(errCode);
        }
        return result;
    }

    public final ArrayList<String> getParameters() {
        if (parameters == null) {
            parameters = new ArrayList<String>(0);
        }
        return parameters;
    }

    public final void setParameters(final ArrayList<String> aparameters) {
        this.parameters = aparameters;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ErrorInfo [code=");
        builder.append(code);
        builder.append(", parameters=");
        builder.append(parameters);
        builder.append(']');
        return builder.toString();
    }

}
