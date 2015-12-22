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
		System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>RESPONSE DATA = "
				+ new String(data));

		ServletOutputStream out = response.getOutputStream();
		out.write(data);
		out.flush();
		out.close();
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
