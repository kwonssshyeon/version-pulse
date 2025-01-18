package v0;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import v0.apispecifications.ApiSpecFetcher;
import v0.scanners.ApiGroupScanner;
import v0.scanners.ApiScanner;

public class VersionPulse {
	public static String packageName;
	public static String notionUrl = "~~~";
	
	public VersionPulse(String packageName) {
		VersionPulse.packageName = packageName;
		execute();
	}
	
	public void execute() {
		ApiGroupScanner apiGroupScanner = new ApiGroupScanner(packageName);
		ApiScanner apiScanner = new ApiScanner();
		List<Method> methods = new ArrayList<>();
		
		List<Class<?>> clazzes = apiGroupScanner.scan(); // ��Ʈ�ѷ� ���� ��ĵ
		
		for (Class<?> clazz : clazzes) {
			List<Method> targets = apiScanner.scan(clazz); // API ���� ��ĵ
			
			for (Method target : targets) {
				ApiSpecFetcher apiSpecFetcher = new ApiSpecFetcher(target);
				apiSpecFetcher.print();
			}
			
			methods.addAll(targets);
		}
	}
}
