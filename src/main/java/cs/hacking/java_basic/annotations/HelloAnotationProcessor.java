package cs.hacking.java_basic.annotations;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;
import java.util.Set;

// https://travisdazell.blogspot.com/2012/10/writing-annotation-based-processor-in.html
public class HelloAnotationProcessor extends AbstractProcessor {
	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		Set<? extends Element> elements = roundEnv.getElementsAnnotatedWith(Hello.class);
		StringBuilder sb = new StringBuilder();
		for (Element e : elements) {
			sb.append("class:" + e.getSimpleName() + "\n");

			Hello hello = e.getAnnotation(Hello.class);
			processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, sb.toString());
		}
		return false;
	}
}
