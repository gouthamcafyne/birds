package com.common.pojo.web;

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

	public void setBirds(SSBatch<Bird> birds) {
		this.birds = birds;
	}
}
