package io.versionpulse.api.apispecifications;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import io.versionpulse.api.apispecifications.models.ReturnValueModel;
import io.versionpulse.api.apispecifications.models.ReturnValueModel.ResponseBody;

public class MethodReturnValueReader {
	static ReturnValueModel getReturnValueModel(Method method) {
		Type type = method.getReturnType();
		List<String[]> body = new ArrayList<>();
		
		if (type instanceof Class<?>) {
	        Class<?> clazz = (Class<?>) type;

	        Field[] fields = clazz.getDeclaredFields();
	        for (Field field : fields) {
	            field.setAccessible(true);  // private �ʵ嵵 ������ �� �ֵ��� ����
	            body.add(new String[] {field.getType().toString(), field.getName()});
	        }
	    }
		return new ReturnValueModel(new ResponseBody(type.toString(), body));
	}
}
