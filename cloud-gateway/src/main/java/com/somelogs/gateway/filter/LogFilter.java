package com.somelogs.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.net.URI;

/**
 * log filter
 *
 * @author LBG - 3/22/21
 */
@Component
public class LogFilter implements GlobalFilter, Ordered {

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		URI uri = exchange.getRequest().getURI();
		System.out.println("request url: " + uri.toString());
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
