package cs.hacking.java_basic;

import org.junit.Test;

import static org.junit.Assert.*;

public class StringsTest {
	@Test
	public void stringBuf() {
		StringBuffer strBuf = new StringBuffer();
		strBuf.append(1);
		strBuf.append("good");
		System.out.println(strBuf);
	}

	@Test
	public void strBuilder() {
		StringBuilder sb = new StringBuilder();
		sb.append(1);
		sb.append("good");
		System.out.println(sb.toString());
	}
}