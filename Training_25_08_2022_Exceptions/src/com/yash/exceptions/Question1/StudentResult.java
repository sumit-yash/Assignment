package com.yash.exceptions.Question1;

public class StudentResult {

	private int physicsMarks;
	private int mathsMarks;
	private int chemistryMarks;

	public int getPhysicsMarks() {
		return physicsMarks;
	}

	public void setPhysicsMarks(int physicsMarks) {
		this.physicsMarks = physicsMarks;
	}

	public int getMathsMarks() {
		return mathsMarks;
	}

	public void setMathsMarks(int mathsMarks) {
		this.mathsMarks = mathsMarks;
	}

	public int getChemistryMarks() {
		return chemistryMarks;
	}

	public void setChemistryMarks(int chemistryMarks) {
		this.chemistryMarks = chemistryMarks;
	}

	@Override
	public String toString() {
		return "StudentResult [physicsMarks=" + physicsMarks + ", mathsMarks=" + mathsMarks + ", chemistryMarks="
				+ chemistryMarks + "]";
	}

	public StudentResult(int physicsMarks, int mathsMarks, int chemistryMarks) {
		super();
		this.physicsMarks = physicsMarks;
		this.mathsMarks = mathsMarks;
		this.chemistryMarks = chemistryMarks;
	}

	public StudentResult() {
		super();
		// TODO Auto-generated constructor stub
	}

}
