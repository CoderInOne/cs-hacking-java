package cs.hacking.java_basic.annotations;

public class HelloMain {
	public static void main(String[] args) {
		System.setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
		Hello hello = TestClass.class.getAnnotation(Hello.class);
		// hello is $Proxy class
		hello.value();
	}
}
