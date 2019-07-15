package cs.hacking.java_basic;

public class Strings {
	/**
	 * String:
	 *   - can not modified, constant
	 *
	 * StringBuilder:
	 *   - can be modified, len and cap can be changed
	 *   - not thread-safe
	 *
	 * StringBuilder:
	 *   - synchronized, thread-safe
	 *
	 * StringBuilder and StringBuffer extends AbstractStringBuilder
	 *
	 * AbstractStringBuilder's capacity extension:
	 * 1. double if no overflow
	 * 2. MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8
	 * -8 because some VM having array header @see java.lang.AbstractStringBuilder#newCapacity(int)
	 */
}
