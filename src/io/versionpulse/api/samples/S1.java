package io.versionpulse.api.samples;

import io.versionpulse.api.annotations.Api;
import io.versionpulse.api.annotations.ApiGroup;

@ApiGroup(value = "s1")
public class S1 {
	
	@Api(name = "s1 API - 1", detail = "s1 Ŭ������ API 1�Դϴ�.")
	public void test1() {};

	@Api(name = "s1 API - 2")
	public void test2() {};
	
	public void test3() {};
}
