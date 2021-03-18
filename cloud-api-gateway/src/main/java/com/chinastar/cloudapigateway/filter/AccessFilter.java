package com.chinastar.cloudapigateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * 服务网关 - 过滤器
 * <p>
 * 问题：
 * 所以，比较好的做法是将这些校验逻辑剥离出去，构建出一个独立的鉴权服务。
 * 在完成了剥离之后，有不少开发者会直接在微服务应用中通过调用鉴权服务来实现校验，
 * 但是这样的做法仅仅只是解决了鉴权逻辑的分离，并没有在本质上将这部分不属于业余的逻辑拆分出原有的微服务应用，
 * 冗余的拦截器或过滤器依然会存在。
 * <p>
 * 解决：
 * 对于这样的问题，更好的做法是通过前置的网关服务来完成这些非业务性质的校验。
 * 由于网关服务的加入，外部客户端访问我们的系统已经有了统一入口，
 * 既然这些校验与具体业务无关，那何不在请求到达的时候就完成校验和过滤，而不是转发后再过滤而导致更长的请求延迟。
 * 同时，通过在网关中完成校验和过滤，微服务应用端就可以去除各种复杂的过滤器和拦截器了，
 * 这使得微服务应用的接口开发和测试复杂度也得到了相应的降低。
 *
 * @author LBG - 2019/4/8
 */
public class AccessFilter extends ZuulFilter {

	private static Logger logger = LoggerFactory.getLogger(AccessFilter.class);

	/**
	 * 过滤器的类型, 决定过滤器在请求那个生命周期中执行
	 * “pre” 表示请求被路由之前执行
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/**
	 * 过滤器执行的顺序：
	 * 请求在一个阶段中存在多个过滤器时，需要根据该方法返回的值来依次执行
	 */
	@Override
	public int filterOrder() {
		return 0;
	}

	/**
	 * 该过滤器是否需要执行
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext cxt = RequestContext.getCurrentContext();
		HttpServletRequest request = cxt.getRequest();

		String token = request.getParameter("accessToken");
		if (StringUtils.isBlank(token)) {
			logger.warn("access token is empty");
			// 让zuul过滤该请求，不对其进行路由
			cxt.setSendZuulResponse(false);
			cxt.setResponseStatusCode(401);
			return null;
		}

		logger.info("access token is ok");
		return null;
	}
}
