package ch06.ex03;

public interface Verbose {
	public enum MessageLebel {
		SILENT, TERSE, NORMAL, VERBOSE,
	}

	void setVerbosity(int level);

	int getVerbosity();
}
