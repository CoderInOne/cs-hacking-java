package cs.hacking.ds_algo;

import java.util.Objects;

public class Pair<One, Two> {
	private One o;
	private Two t;

	private Pair(One o, Two t) {
		this.o = o;
		this.t = t;
	}

	public One getOne() {
		return o;
	}

	public Two getTwo() {
		return t;
	}

	public static <One, Two> Pair from(One o, Two t) {
		return new Pair<>(o, t);
	}

	@Override
	public boolean equals(Object o1) {
		if (this == o1) return true;
		if (o1 == null || getClass() != o1.getClass()) return false;
		Pair<?, ?> pair = (Pair<?, ?>) o1;
		return Objects.equals(o, pair.o) &&
				Objects.equals(t, pair.t);
	}

	@Override
	public int hashCode() {
		return Objects.hash(o, t);
	}

	@Override
	public String toString() {
		return "Pair{" +
				"o=" + o +
				", t=" + t +
				'}';
	}
}
