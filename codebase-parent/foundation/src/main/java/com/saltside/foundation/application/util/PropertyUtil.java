/**
 * 
 */
package com.saltside.foundation.application.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author Goutham P N
 *
 */
@Component
public class PropertyUtil {

	@Autowired
	private ApplicationContext applicationContext;

	public String getProperty(String key) {
		return applicationContext.getEnvironment().getProperty(key);
	}
}
