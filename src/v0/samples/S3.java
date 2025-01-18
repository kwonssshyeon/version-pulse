package v0.samples;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import v0.annotations.Api;
import v0.annotations.ApiGroup;

@ApiGroup(value = "s3 ��Ʈ�ѷ�")
public class S3 {
	
	@Api(name = "s3_1 API")
	@GetMapping(name = "hey")
	public void s3_1(
			@RequestParam(name="qs1") String name1,
			@RequestParam(name="qs2") String name2,
			@PathVariable(name="pv1") Integer name3) {};

}
