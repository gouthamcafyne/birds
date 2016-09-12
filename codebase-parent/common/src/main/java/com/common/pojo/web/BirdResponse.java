package com.common.pojo.web;

import java.util.List;

import com.common.pojo.Bird;
import com.common.pojo.SSBatch;

public class BirdResponse extends BaseResponse {
	private SSBatch<Bird> birds;

	public BirdResponse() {
		birds = new SSBatch<Bird>();
	}

	public SSBatch<Bird> getBirds() {
		return birds;
	}

	public void setBirds(List<Bird> birds) {
		this.birds.setItems(birds);
	}
}
