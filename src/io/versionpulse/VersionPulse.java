package io.versionpulse;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import io.versionpulse.api.apispecifications.ApiSpecFetcher;
import io.versionpulse.api.scanners.ApiGroupScanner;
import io.versionpulse.api.scanners.ApiScanner;
import io.versionpulse.doc.apis.CreateDatabase;

public class VersionPulse {
	public static String packageName;
	public static String notionKey;
	public static String pageId;
	
	public VersionPulse(String packageName, String notionKey, String pageId) {
		VersionPulse.packageName = packageName;
		VersionPulse.notionKey = notionKey;
		VersionPulse.pageId = pageId;
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
		
		initializeDB();
	}
	
	public void initializeDB() {
		CreateDatabase client = CreateDatabase.builder()
				.notionKey(notionKey)
				.pageId(pageId)
				.build();
		client.execute();
	}
}
