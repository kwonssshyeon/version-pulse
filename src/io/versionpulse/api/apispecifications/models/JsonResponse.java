package io.versionpulse.api.apispecifications.models;

import java.lang.reflect.Field;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JsonResponse<T> {
	private static final ObjectMapper objectMapper = new ObjectMapper(); // �̱��� ���
    private final T object;

	
    @Override
    public String toString() {
        try {
            // DTO Ŭ������ �ʵ� �̸��� �ڷ����� ������ �� ����
            return toJson(object.getClass());
        } catch (Exception e) {
            System.err.println("JSON ��ȯ ����: " + e.getMessage());
            return "{}";
        }
    }

    // Ŭ���� Ÿ���� ���������� �����ϴ� �޼���
    private String toJson(Class<?> clazz) throws Exception {
        ObjectNode jsonStructure = objectMapper.createObjectNode();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            String fieldName = field.getName();
            String fieldType = field.getType().getSimpleName();

            // ���� �ʵ尡 �� �ٸ� DTO��� ��������� ó��
            if (isDTO(field.getType())) {
                ObjectNode nestedJson = objectMapper.createObjectNode();
                // ���� DTO �ʵ嵵 ��������� �߰�
                jsonStructure.set(fieldName, objectMapper.readTree(toJson(field.getType()))); // ��ø�� �ʵ�� ObjectNode ���·� �߰�
            } else {
                // �⺻ Ÿ���̳� ��Ÿ �ڷ����� ���ڿ��� ó��
                jsonStructure.put(fieldName, fieldType);
            }
        }
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonStructure);
    }
    
    
    
    private boolean isDTO(Class<?> clazz) {
    	Package clazzPackage = clazz.getPackage();
        if (clazzPackage == null) {
            return false; // ��Ű���� ������ DTO�� ����
        }
        
        // ��Ű���� "java.lang"�� ������ Ŭ�������� DTO�� ���� 
        return !clazzPackage.getName().startsWith("java.lang");
    }

}
