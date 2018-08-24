package com.common.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

 
public class AccessFilter extends ZuulFilter{

//	private static InternalLogger log =  Log4JLoggerFactory.getInstance(AccessFilter.class);

	@Override
	public Object run() {
		// TODO Auto-generated method stub
		
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest req = ctx.getRequest();
		
//		log.info("send {} request to {}", req.getMethod(), req.getRequestURL().toString());
//		System.out.println("it is ok ---------------------->");
		Object accessToken = req.getParameter("accessToken");
		
		HttpSession ss = req.getSession();
		
		if(accessToken == null) {
//			log.warn("access token is empty");
//			System.out.println("access token is empty");
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			return null;
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}
}
