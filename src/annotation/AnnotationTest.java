package annotation;

@MyAnno(value="�׽�Ʈ Ŭ����")
public class AnnotationTest {

	@MyAnno(value="���ϱ� ����")
	public void plus(int a, int b) {
		System.out.println(a+" + "+b+" = "+(a+b));
	}
}
