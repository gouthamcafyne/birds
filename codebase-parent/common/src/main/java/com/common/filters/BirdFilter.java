/** 
 * 
 */
package com.common.filters;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Component;

import com.common.pojo.Bird;

/**
 * @author Goutham P N
 *
 */
@Component
public class BirdFilter {
	public List<Bird> filterVisibleData(List<Bird> data) {
		if (!CollectionUtils.isNotEmpty(data)) {
			return null;
		}
		List<Bird> resp = new ArrayList<Bird>();
		for (Bird bird : data) {
			if (null!=bird.getVisible() && bird.getVisible()) {
				resp.add(bird);
			}
		}
		return resp;
	}
}
