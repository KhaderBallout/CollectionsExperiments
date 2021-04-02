package edu.bethlehem.assignment2;

public class Score2 {
	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getArrayList() {
		return arrayList;
	}


	public void setArrayList(String arrayList) {
		this.arrayList = arrayList;
	}


	public String getLinkedList() {
		return linkedList;
	}


	public void setLinkedList(String linkedList) {
		this.linkedList = linkedList;
	}


	public String getVector() {
		return vector;
	}


	public void setVector(String vector) {
		this.vector = vector;
	}


	private String size;
	private String arrayList;
	private String linkedList;
	private String vector;
	
	
	public Score2(String n1 , String n2 , String n3 , String n4 ) {
		this.size=n1;		
		this.arrayList=n2;
		this.linkedList=n3;
		this.vector=n4;
	}

}
