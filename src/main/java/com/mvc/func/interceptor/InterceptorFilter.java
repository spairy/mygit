package com.mvc.func.interceptor;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.formula.functions.T;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class InterceptorFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		WrapperedResponse wrapResponse = new WrapperedResponse(
				(HttpServletResponse) response);
		chain.doFilter(request, wrapResponse);
		
		byte[] data = wrapResponse.getResponseData();
		System.out.println("****** Original Rsponse Data = " + new String(data));
		String tempx = new String(data);
		ParentShop object = fromJson(tempx);
		System.out.println("****** JSON Rsponse Data. Base Class Code Value = " + object.getCode());
		ServletOutputStream out = response.getOutputStream();
		out.write(data);
		out.flush();
		out.close();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	private ParentShop fromJson(String json) throws JsonParseException, JsonMappingException, IOException{
		ParentShop shop = new ObjectMapper().readValue(json, ParentShop.class);
		return shop;
	}

}
