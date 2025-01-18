package v0.sample;

import v0.annotations.Api;
import v0.annotations.ApiGroup;

@ApiGroup(value = "s1")
public class S1 {
	
	@Api(name = "s1 API - 1", detail = "s1 클래스의 API 1입니다.")
	public void test1() {};

	@Api(name = "s1 API - 2")
	public void test2() {};
	
	public void test3() {};
}
