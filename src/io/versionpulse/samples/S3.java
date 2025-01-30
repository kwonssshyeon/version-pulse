package io.versionpulse.samples;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import io.versionpulse.api.annotations.Api;
import io.versionpulse.api.annotations.ApiGroup;

@ApiGroup(value = "s3 ��Ʈ�ѷ�")
public class S3 {
	
	@Api(name = "s3_1 API")
	@GetMapping(name = "hey")
	public SBody2 s3_1(
			@RequestParam(name="qs1") String name1,
			@RequestParam(name="qs2") String name2,
			@PathVariable(name="pv1") Integer name3,
			@RequestBody SBody sBody) 
	{return new SBody2(); };

}
