package stream;
@FunctionalInterface
public interface Interface1 {
	public default int data1() {
		return 1;
	}
	public int data2();

}
