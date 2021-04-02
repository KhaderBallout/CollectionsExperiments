package edu.bethlehem.assignment2;

public class Score {
	public String getSize() {
		return size;
	}


	public void setSize(String size) {
		this.size = size;
	}


	public String getHashSet() {
		return hashSet;
	}


	public void setHashSet(String hashSet) {
		this.hashSet = hashSet;
	}


	public String getLinkedHashSet() {
		return linkedHashSet;
	}


	public void setLinkedHashSet(String linkedHashSet) {
		this.linkedHashSet = linkedHashSet;
	}


	public String getTreeSet() {
		return treeSet;
	}


	public void setTreeSet(String treeSet) {
		this.treeSet = treeSet;
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


	public String getQueue() {
		return queue;
	}


	public void setQueue(String queue) {
		this.queue = queue;
	}


	public String getVector() {
		return vector;
	}


	public void setVector(String vector) {
		this.vector = vector;
	}


	private String size;
	private String hashSet;
	private String linkedHashSet;
	private String treeSet;
	private String arrayList;
	private String linkedList;
	private String queue;
	private String vector;
	
	
	public Score(String n1 , String n2 , String n3 , String n4 , String n5 , String n6 , String n7 , String n8) {
		this.size=n1;
		this.hashSet=n2;
		this.linkedHashSet=n3;
		this.treeSet=n4;
		this.arrayList=n5;
		this.linkedList=n6;
		this.queue=n7;
		this.vector=n8;
	}

}
