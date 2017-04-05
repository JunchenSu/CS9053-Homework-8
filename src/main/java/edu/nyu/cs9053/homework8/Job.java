package edu.nyu.cs9053.homework8;

public class Job {

	private final int start;
	private final int end;
	private final int weight;

	public Job(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return end;
	}

	public int getWeight() {
		return weight;
	}
}