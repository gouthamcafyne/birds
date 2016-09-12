/**
 * 
 */
package com.saltside.foundation.web.security.interceptors;

/**
 * @author Goutham P N
 *
 */
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.sun.jersey.spi.container.ContainerRequest;
import com.sun.jersey.spi.container.ContainerRequestFilter;

@Component
public class ApiRequestInterceptor implements ContainerRequestFilter {

	private static final Logger _logger = Logger.getLogger(ApiRequestInterceptor.class);

	/*
	 * @Autowired private ITokenHandlerService tokenHandlerService;
	 */
	public ContainerRequest filter(ContainerRequest request) {
		_logger.info("Request is intercepted... Can be used for authentication");
		return request;
	}
}
