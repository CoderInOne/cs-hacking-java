package cs.hacking.java_basic.annotations;

/**
 * vs XML?
 * 1. simple, easy, convenient but coupled with code
 * 2. add meta data to biz code, make it reusable
 *
 * 1. AP works at compile time TODO lombok/motan @MotanAsync generator
 * 2. Retention.RUNTIME work as reflection way in runtime (after loaded into JVM)
 *    TODO how Spring @Component and @Autowired works
 *
 * 1. A annotation object get by getAnnotation(annotationClz) is a proxy
 * 2. AnnotationInvocationHandler implements InvocationHandler
 * 3. Also annotations' method-value stored in map, and set by AnnotationParser
 * 4. AnnotationParser is responsible parse constant from class file
 * check AnnotationParser#parseConst
 */

/*
public final class $Proxy1 extends Proxy implements Hello {
	private static Method m1;
	private static Method m2;
	private static Method m4;
	private static Method m0;
	private static Method m3;

	public $Proxy1(InvocationHandler var1) throws  {
		super(var1);
	}

	public final boolean equals(Object var1) throws  {
		try {
			return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
		} catch (RuntimeException | Error var3) {
			throw var3;
		} catch (Throwable var4) {
			throw new UndeclaredThrowableException(var4);
		}
	}

	public final String toString() throws  {
		try {
			return (String)super.h.invoke(this, m2, (Object[])null);
		} catch (RuntimeException | Error var2) {
			throw var2;
		} catch (Throwable var3) {
			throw new UndeclaredThrowableException(var3);
		}
	}

	public final Class annotationType() throws  {
		try {
			return (Class)super.h.invoke(this, m4, (Object[])null);
		} catch (RuntimeException | Error var2) {
			throw var2;
		} catch (Throwable var3) {
			throw new UndeclaredThrowableException(var3);
		}
	}

	public final int hashCode() throws  {
		try {
			return (Integer)super.h.invoke(this, m0, (Object[])null);
		} catch (RuntimeException | Error var2) {
			throw var2;
		} catch (Throwable var3) {
			throw new UndeclaredThrowableException(var3);
		}
	}

	public final String value() throws  {
		try {
			return (String)super.h.invoke(this, m3, (Object[])null);
		} catch (RuntimeException | Error var2) {
			throw var2;
		} catch (Throwable var3) {
			throw new UndeclaredThrowableException(var3);
		}
	}

	static {
		try {
			m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
			m2 = Class.forName("java.lang.Object").getMethod("toString");
			m4 = Class.forName("cs.hacking.java_basic.annotations.Hello").getMethod("annotationType");
			m0 = Class.forName("java.lang.Object").getMethod("hashCode");
			m3 = Class.forName("cs.hacking.java_basic.annotations.Hello").getMethod("value");
		} catch (NoSuchMethodException var2) {
			throw new NoSuchMethodError(var2.getMessage());
		} catch (ClassNotFoundException var3) {
			throw new NoClassDefFoundError(var3.getMessage());
		}
	}
}
*/
