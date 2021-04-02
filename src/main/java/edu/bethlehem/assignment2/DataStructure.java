package edu.bethlehem.assignment2;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeSet;
import java.util.Vector;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class DataStructure extends Application {
	static int N = 5000; 
	static int N2 = 20000;
	static int N3 = 0 ;
	static int counter = 1;
	static int test = 0; 
	static long member[][] = new long[7][10];
	static long remove[][] = new long[7][10];
	static long forLoop[][] = new long[3][10];
	static long forEach[][] = new long[3][10];
	static int i = 0 ;
	
	Scene s0,s1,s2,s3,s4,s5,s6,s7,s8;
	TableView<Score> tableView,tableView1 ;
	TableView<Score2>tableView2,tableView3;
	public static void main(String[] args)  {

		// Add numbers 0, 1, 2, ..., N - 1 to the array list
		while(N <= 50000) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < N; i++)
			list.add(i);
		Collections.shuffle(list); 
		// Shuffle the array list
		
		List<Integer> listTwo = new ArrayList<Integer>();
		for (int i = 0; i < N2; i++)
			listTwo.add(i);
		Collections.shuffle(listTwo); // Shuffle the array list
		
		
		List<Integer> listThree = new ArrayList<Integer>();
		for (int i = 0; i < N3; i++)
			listThree.add(i);
		Collections.shuffle(listThree); // Shuffle the array list

		// Create a hash set, and test its performance
		Collection<Integer> set1 = new HashSet<Integer>(list); // hashset
		member[0][i] = getTestTime(set1);
		remove[0][i] = getRemoveTime(set1);
//		System.out.println("Member test time for hash set is " + getTestTime(set1) + " milliseconds");
//		System.out.println("Remove element time for hash set is " + getRemoveTime(set1) + " milliseconds");
//        System.out.println("----------------");

		// Create a linked hash set, and test its performance
		Collection<Integer> set2 = new LinkedHashSet<Integer>(list); // linked hash set
		member[1][i] = getTestTime(set2);
		remove[1][i] = getRemoveTime(set2);
//		System.out.println("Member test time for linked hash set is " + getTestTime(set2) + " milliseconds");
//		System.out.println("Remove element time for linked hash set is " + getRemoveTime(set2) + " milliseconds");
//		System.out.println("----------------");

		// Create a tree set, and test its performance
		Collection<Integer> set3 = new TreeSet<Integer>(list); // tree set
		member[2][i] = getTestTime(set3);
		remove[2][i] = getRemoveTime(set3);
//		System.out.println("Member test time for tree set is " + getTestTime(set3) + " milliseconds");
//		System.out.println("Remove element time for tree set is " + getRemoveTime(set3) + " milliseconds");
//		System.out.println("----------------");

		// Create an array list, and test its performance
		Collection<Integer> list1 = new ArrayList<Integer>(list); // arraylist
//		System.out.println("Member test time for array list is " + getTestTime(list1) + " milliseconds");
//		System.out.println("Remove element time for array list is " + getRemoveTime(list1) + " milliseconds");
		member[3][i] = getTestTime(list1);
		remove[3][i] = getRemoveTime(list1);
		List<Integer> list1a = new ArrayList<Integer>(listThree);
		List<Integer> list1b = new ArrayList<Integer>(listTwo);
//     	System.out.println("Traversing all element for array list is "+getTraveringForLoopTime(list1b)+ "milliseconds using for loop"); //
//		System.out.println("Traversing all element for array list is "+getTraveringForEachTime(list1b)+ "milliseconds using for each");
		forLoop[0][i] = getTraveringForLoopTime(list1b);
		forEach[0][i] = getTraveringForEachTime(list1a);
//		System.out.println("----------------");

		// Create a linked list, and test its performance
		Collection<Integer> list2 = new LinkedList<Integer>(list); // linked list
//		System.out.println("Member test time for linked list is " + getTestTime(list2) + " milliseconds");
//		System.out.println("Remove element time for linked list is " + getRemoveTime(list2) + " milliseconds");
		member[4][i] = getTestTime(list2);
		remove[4][i] = getRemoveTime(list2);
		List<Integer> list2a = new LinkedList<Integer>(listThree);
		List<Integer> list2b = new LinkedList<Integer>(listTwo);
//		System.out.println("Traversing all element for linked list is "+getTraveringForLoopTime(list2b)+ "milliseconds using for loop"); //
//		System.out.println("Traversing all element for linked list is "+getTraveringForEachTime(list2b)+ "milliseconds using for each");
		forLoop[1][i] = getTraveringForLoopTime(list2b);
		forEach[1][i] = getTraveringForEachTime(list2a);
//		System.out.println("----------------");

		// Create a  priorityQueue, and test its performance
		Collection<Integer> list3 = new PriorityQueue<Integer>(list); // priorityQueue
//		System.out.println("Member test time for PriorityQueuet is " + getTestTime(list3) + " milliseconds");
//		System.out.println("Remove element time for PriorityQueue is " + getRemoveTime(list3) + " milliseconds");
//		System.out.println("----------------");
		member[5][i] = getTestTime(list3);
		remove[5][i] = getRemoveTime(list3);
		
		Collection<Integer> list4 = new Vector<Integer>(list); // vector
//		System.out.println("Member test time for vector is " + getTestTime(list4) + " milliseconds");
//		System.out.println("Remove element time for vector is " + getRemoveTime(list4) + " milliseconds");
		member[6][i] = getTestTime(list4);
		remove[6][i] = getRemoveTime(list4);
		List<Integer> list4b = new Vector<Integer>(listTwo);
		List<Integer> list4a = new Vector<Integer>(listThree);
//		System.out.println("Traversing all element for vector is "+getTraveringForLoopTime(list4b)+ "milliseconds using for loop"); //
//		System.out.println("Traversing all element for vector is "+getTraveringForEachTime(list4b)+ "milliseconds using for each");
		forLoop[2][i] = getTraveringForLoopTime(list4b);
		forEach[2][i] = getTraveringForEachTime(list4a);
		test++;
		i++;
		N+=5000;
		N2+=20000;
		N3+=100000;
		System.out.println("-------------------> The Test number:"+test);
		list.clear();
		listTwo.clear();
		listThree.clear();
		}

		launch(args);
	}

	public static long getTestTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();

		// Test if a number is in the collection
		for (int i = 0; i < c.size(); i++)
			c.contains((int) (Math.random() * 2 * N));

		return System.currentTimeMillis() - startTime;
	}

	public static long getRemoveTime(Collection<Integer> c) {
		long startTime = System.currentTimeMillis();

		for (int i = 0; i < c.size(); i++)
			c.remove(i);
		return System.currentTimeMillis() - startTime;

	}
	
	public static long getTraveringForLoopTime(List<Integer> c) {
		long startTime = System.currentTimeMillis();
		
		for (int i = 0; i < c.size(); i++) {
			c.get(i);
		}
		
		return System.currentTimeMillis() - startTime;

	}
	public static long getTraveringForEachTime(List<Integer> c) {
		long startTime = System.currentTimeMillis();
		
		Iterator<Integer> iterator = c.iterator();
		while(iterator.hasNext()) {
			iterator.next();
		}

		return System.currentTimeMillis() - startTime;

	}

	@Override
	public void start(Stage stage) throws Exception {
		// TODO Auto-generated method stub
		
		final Label label = new Label("Collections Preformance \n");
		label.setFont(new Font("Arial", 30));
		label.setTranslateX(450/2);
		Button memberButton = new Button("Member Table");
        memberButton.setTranslateX(150);
        memberButton.setOnAction(e-> stage.setScene(s1));
        Button removingButton = new Button("Removing Table");
        removingButton.setTranslateX(470);
        removingButton.setTranslateY(-35);
        removingButton.setOnAction(e-> stage.setScene(s3));
        Button forLoopButton = new Button("For Loop Table");
        forLoopButton.setTranslateX(150);
        forLoopButton.setOnAction(e-> stage.setScene(s5));
        Button forEachButton = new Button("For each Table");
        forEachButton.setTranslateX(470);
        forEachButton.setTranslateY(-35);
        forEachButton.setOnAction(e-> stage.setScene(s7));
        
        BackgroundFill background_fill = new BackgroundFill(Color.CADETBLUE,CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
        
        Text text = new Text();
        text.setFont(new Font(21));
        text.setTextAlignment(TextAlignment.JUSTIFY);
        text.setText("The Application will make 4 experiments for different java collection \n implementations to find out the relationship between "
        		+ "the time versus the \n size of the collection durning:- \n 1)Retrieving an element. \n 2)Removing an element"
        		+ " \n 3)traversing all elements using forLoop \n 4)traversing all elements using forEach \n");
        
        Text text2 = new Text();
        text2.setFont(new Font(21));
        text2.setTextAlignment(TextAlignment.JUSTIFY);
        text2.setText("\n Detalis about my environment in this experitments: \n CPU (Intel core i5-4200U 160GHz) \n RAM (8.0 GB DDR3) \n Java version: 1.8.0_211 ");
        
        
        Pane canvas = new Pane();
        canvas.setPrefSize(1000,800);
        
        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 10, 10, 50));
        vbox.getChildren().addAll(label,text,memberButton,removingButton,forLoopButton,forEachButton,text2);
        canvas.getChildren().addAll(vbox);
        
        canvas.setBackground(background);
		
        s0  = new Scene(new Group(),800,600);

        ((Group) s0.getRoot()).getChildren().addAll(canvas);

		
		//-------------------------------------------------------------s1
		
		final Label MemberLabel = new Label("Retriving Time Table");
        MemberLabel.setFont(new Font("Arial", 20));
        
        //size Column
        TableColumn<Score, String> size = new TableColumn<>("Size");
        size.setCellValueFactory(new PropertyValueFactory<>("size"));
        
      //size Column
        TableColumn<Score, String> hashSet = new TableColumn<>("HashSet");
        hashSet.setCellValueFactory(new PropertyValueFactory<>("hashSet"));
        
      //size Column
        TableColumn<Score, String> linkedHashSet = new TableColumn<>("LinkedHashSet");
        linkedHashSet.setCellValueFactory(new PropertyValueFactory<>("linkedHashSet"));
        
      //size Column
        TableColumn<Score, String> treeSet = new TableColumn<>("TreeSet");
        treeSet.setCellValueFactory(new PropertyValueFactory<>("treeSet"));
        
      //size Column
        TableColumn<Score, String> arrayList = new TableColumn<>("ArrayList");
        arrayList.setCellValueFactory(new PropertyValueFactory<>("arrayList"));
        
      //size Column
        TableColumn<Score, String> linkedList = new TableColumn<>("linkedList");
        linkedList.setCellValueFactory(new PropertyValueFactory<>("linkedList"));
        
      //size Column
        TableColumn<Score, String> queue = new TableColumn<>("PriorityQueue");
        queue.setCellValueFactory(new PropertyValueFactory<>("queue"));
        
      //size Column
        TableColumn<Score, String> vector = new TableColumn<>("Vector");
        vector.setCellValueFactory(new PropertyValueFactory<>("vector"));
        
        tableView = new TableView<>();
        tableView.setItems(getMemberScore());
        tableView.getColumns().addAll(size, hashSet, linkedHashSet,treeSet,arrayList,linkedList,queue,vector);
        tableView.setMinSize(670, 520);       
 
        Button memberToTable = new Button("To Member Table");
        memberToTable.setTranslateX(300);
        memberToTable.setOnAction(e-> stage.setScene(s2));
        Button memberToBack = new Button("Back to Main");
        memberToBack.setTranslateX(310);
        memberToBack.setOnAction(e-> stage.setScene(s0));
		
        final VBox memberBox = new VBox();
        memberBox.setSpacing(5);
        memberBox.setPadding(new Insets(10, 10, 10, 50));
        memberBox.getChildren().addAll(MemberLabel, tableView,memberToTable,memberToBack);
		
        s1  = new Scene(new Group(),800,650);
        ((Group) s1.getRoot()).getChildren().addAll(memberBox);
 
      
		
		//----------------------------------------------------------------------- s2
		//defining the axes
        final NumberAxis memberX = new NumberAxis();
        final NumberAxis memberY = new NumberAxis();
        memberX.setLabel("Size");
        memberY.setLabel("Retrieving Time");
        //creating the chart
        final LineChart<Number,Number> memberLineChart = new LineChart<Number,Number>(memberX,memberY);
        memberLineChart.setTitle("Retriving Time Graph");
        //defining a series
        XYChart.Series memberSeries = new XYChart.Series();
        memberSeries.setName("HashSet");
        //populating the series with data
        memberSeries.getData().add(new XYChart.Data(5000,member[0][0]));
        memberSeries.getData().add(new XYChart.Data(10000,member[0][1]));
        memberSeries.getData().add(new XYChart.Data(15000,member[0][2]));
        memberSeries.getData().add(new XYChart.Data(20000,member[0][3]));
        memberSeries.getData().add(new XYChart.Data(25000,member[0][4]));
        memberSeries.getData().add(new XYChart.Data(30000,member[0][5]));
        memberSeries.getData().add(new XYChart.Data(35000,member[0][6]));
        memberSeries.getData().add(new XYChart.Data(40000,member[0][7]));
        memberSeries.getData().add(new XYChart.Data(45000,member[0][8]));
        memberSeries.getData().add(new XYChart.Data(50000,member[0][9]));
        
        XYChart.Series memberSeries1 = new XYChart.Series();
        memberSeries1.setName("LinkedHashSet");
        
        memberSeries1.getData().add(new XYChart.Data(5000,member[1][0]));
        memberSeries1.getData().add(new XYChart.Data(10000,member[1][1]));
        memberSeries1.getData().add(new XYChart.Data(15000,member[1][2]));
        memberSeries1.getData().add(new XYChart.Data(20000,member[1][3]));
        memberSeries1.getData().add(new XYChart.Data(25000,member[1][4]));
        memberSeries1.getData().add(new XYChart.Data(30000,member[1][5]));
        memberSeries1.getData().add(new XYChart.Data(35000,member[1][6]));
        memberSeries1.getData().add(new XYChart.Data(40000,member[1][7]));
        memberSeries1.getData().add(new XYChart.Data(45000,member[1][8]));
        memberSeries1.getData().add(new XYChart.Data(50000,member[1][9]));
        
        XYChart.Series memberSeries2 = new XYChart.Series();
        memberSeries2.setName("TreeSet");
        
        memberSeries2.getData().add(new XYChart.Data(5000,member[2][0]));
        memberSeries2.getData().add(new XYChart.Data(10000,member[2][1]));
        memberSeries2.getData().add(new XYChart.Data(15000,member[2][2]));
        memberSeries2.getData().add(new XYChart.Data(20000,member[2][3]));
        memberSeries2.getData().add(new XYChart.Data(25000,member[2][4]));
        memberSeries2.getData().add(new XYChart.Data(30000,member[2][5]));
        memberSeries2.getData().add(new XYChart.Data(35000,member[2][6]));
        memberSeries2.getData().add(new XYChart.Data(40000,member[2][7]));
        memberSeries2.getData().add(new XYChart.Data(45000,member[2][8]));
        memberSeries2.getData().add(new XYChart.Data(50000,member[2][9]));
        
        XYChart.Series memberSeries3 = new XYChart.Series();
        memberSeries3.setName("ArrayList");
        
        memberSeries3.getData().add(new XYChart.Data(5000,member[3][0]));
        memberSeries3.getData().add(new XYChart.Data(10000,member[3][1]));
        memberSeries3.getData().add(new XYChart.Data(15000,member[3][2]));
        memberSeries3.getData().add(new XYChart.Data(20000,member[3][3]));
        memberSeries3.getData().add(new XYChart.Data(25000,member[3][4]));
        memberSeries3.getData().add(new XYChart.Data(30000,member[3][5]));
        memberSeries3.getData().add(new XYChart.Data(35000,member[3][6]));
        memberSeries3.getData().add(new XYChart.Data(40000,member[3][7]));
        memberSeries3.getData().add(new XYChart.Data(45000,member[3][8]));
        memberSeries3.getData().add(new XYChart.Data(50000,member[3][9]));
        
        XYChart.Series memberSeries4 = new XYChart.Series();
        memberSeries4.setName("LinkedList");
        
        memberSeries4.getData().add(new XYChart.Data(5000,member[4][0]));
        memberSeries4.getData().add(new XYChart.Data(10000,member[4][1]));
        memberSeries4.getData().add(new XYChart.Data(15000,member[4][2]));
        memberSeries4.getData().add(new XYChart.Data(20000,member[4][3]));
        memberSeries4.getData().add(new XYChart.Data(25000,member[4][4]));
        memberSeries4.getData().add(new XYChart.Data(30000,member[4][5]));
        memberSeries4.getData().add(new XYChart.Data(35000,member[4][6]));
        memberSeries4.getData().add(new XYChart.Data(40000,member[4][7]));
        memberSeries4.getData().add(new XYChart.Data(45000,member[4][8]));
        memberSeries4.getData().add(new XYChart.Data(50000,member[4][9]));
        
        XYChart.Series memberSeries5 = new XYChart.Series();
        memberSeries5.setName("Priority Queue");
        
        memberSeries5.getData().add(new XYChart.Data(5000,member[5][0]));
        memberSeries5.getData().add(new XYChart.Data(10000,member[5][1]));
        memberSeries5.getData().add(new XYChart.Data(15000,member[5][2]));
        memberSeries5.getData().add(new XYChart.Data(20000,member[5][3]));
        memberSeries5.getData().add(new XYChart.Data(25000,member[5][4]));
        memberSeries5.getData().add(new XYChart.Data(30000,member[5][5]));
        memberSeries5.getData().add(new XYChart.Data(35000,member[5][6]));
        memberSeries5.getData().add(new XYChart.Data(40000,member[5][7]));
        memberSeries5.getData().add(new XYChart.Data(45000,member[5][8]));
        memberSeries5.getData().add(new XYChart.Data(50000,member[5][9]));
        
        XYChart.Series memberSeries6 = new XYChart.Series();
        memberSeries6.setName("Vector");
        
        memberSeries6.getData().add(new XYChart.Data(5000,member[6][0]));
        memberSeries6.getData().add(new XYChart.Data(10000,member[6][1]));
        memberSeries6.getData().add(new XYChart.Data(15000,member[6][2]));
        memberSeries6.getData().add(new XYChart.Data(20000,member[6][3]));
        memberSeries6.getData().add(new XYChart.Data(25000,member[6][4]));
        memberSeries6.getData().add(new XYChart.Data(30000,member[6][5]));
        memberSeries6.getData().add(new XYChart.Data(35000,member[6][6]));
        memberSeries6.getData().add(new XYChart.Data(40000,member[6][7]));
        memberSeries6.getData().add(new XYChart.Data(45000,member[6][8]));
        memberSeries6.getData().add(new XYChart.Data(50000,member[6][9]));
        
        memberLineChart.setMinSize(800, 600);
        //memberLineChart.getData().addAll(memberSeries,memberSeries1);
        
        Button memberBackToTable = new Button("Back To Table");
        memberBackToTable.setTranslateX(800/2);
        memberBackToTable.setOnAction(e-> stage.setScene(s1));
		
        final VBox memberLineBox = new VBox(memberLineChart);
        memberLineBox.setSpacing(5);
        memberLineBox.setPadding(new Insets(10, 0, 0, 10));
        memberLineBox.getChildren().addAll(memberBackToTable);
        memberLineChart.getData().addAll(memberSeries,memberSeries1,memberSeries2,memberSeries3,memberSeries4,memberSeries5,memberSeries6);
        s2  = new Scene(new Group(),900,700);
        ((Group)s2.getRoot()).getChildren().addAll(memberLineBox);
        
        
        //----------------------------------------------------------------------s3
		
		final Label removeLabel = new Label("Remove Time Table");
        removeLabel.setFont(new Font("Arial", 20));
        
        //size Column
        TableColumn<Score, String> size1 = new TableColumn<>("Size");
        size1.setCellValueFactory(new PropertyValueFactory<>("size"));
        
      //size Column
        TableColumn<Score, String> hashSet1 = new TableColumn<>("HashSet");
        hashSet1.setCellValueFactory(new PropertyValueFactory<>("hashSet"));
        
      //size Column
        TableColumn<Score, String> linkedHashSet1 = new TableColumn<>("LinkedHashSet");
        linkedHashSet1.setCellValueFactory(new PropertyValueFactory<>("linkedHashSet"));
        
      //size Column
        TableColumn<Score, String> treeSet1 = new TableColumn<>("TreeSet");
        treeSet1.setCellValueFactory(new PropertyValueFactory<>("treeSet"));
        
      //size Column
        TableColumn<Score, String> arrayList1 = new TableColumn<>("ArrayList");
        arrayList1.setCellValueFactory(new PropertyValueFactory<>("arrayList"));
        
      //size Column
        TableColumn<Score, String> linkedList1 = new TableColumn<>("linkedList");
        linkedList1.setCellValueFactory(new PropertyValueFactory<>("linkedList"));
        
      //size Column
        TableColumn<Score, String> queue1 = new TableColumn<>("PriorityQueue");
        queue1.setCellValueFactory(new PropertyValueFactory<>("queue"));
        
      //size Column
        TableColumn<Score, String> vector1 = new TableColumn<>("Vector");
        vector1.setCellValueFactory(new PropertyValueFactory<>("vector"));
        
        tableView1 = new TableView<>();
        tableView1.setItems(getRemoveScore());
        tableView1.getColumns().addAll(size1, hashSet1, linkedHashSet1,treeSet1,arrayList1,linkedList1,queue1,vector1);
        tableView1.setMinSize(670, 520);       
 
        Button removingToTable = new Button("To Remove Table");
        removingToTable.setTranslateX(300);
        removingToTable.setOnAction(e-> stage.setScene(s4));
        Button removeToback = new Button("Back to Main");
        removeToback.setTranslateX(310);
        removeToback.setOnAction(e-> stage.setScene(s0));
		
        final VBox removeBox = new VBox();
        removeBox.setSpacing(5);
        removeBox.setPadding(new Insets(10, 10, 10, 50));
        removeBox.getChildren().addAll(removeLabel, tableView1,removingToTable,removeToback);
		
        s3  = new Scene(new Group(),800,650);
        ((Group) s3.getRoot()).getChildren().addAll(removeBox);
         //--------------------------------------------------------------------s4
        
        final NumberAxis removeX = new NumberAxis();
        final NumberAxis removeY = new NumberAxis();
        removeX.setLabel("Size");
        removeY.setLabel("Removing time");
        //creating the chart
        final LineChart<Number,Number> removeLineChart = new LineChart<Number,Number>(removeX,removeY);
        removeLineChart.setTitle("Remove Time Graph");
        //defining a series
        XYChart.Series removeSeries = new XYChart.Series();
        removeSeries.setName("HashSet");
        //populating the series with data
        removeSeries.getData().add(new XYChart.Data(5000,remove[0][0]));
        removeSeries.getData().add(new XYChart.Data(10000,remove[0][1]));
        removeSeries.getData().add(new XYChart.Data(15000,remove[0][2]));
        removeSeries.getData().add(new XYChart.Data(20000,remove[0][3]));
        removeSeries.getData().add(new XYChart.Data(25000,remove[0][4]));
        removeSeries.getData().add(new XYChart.Data(30000,remove[0][5]));
        removeSeries.getData().add(new XYChart.Data(35000,remove[0][6]));
        removeSeries.getData().add(new XYChart.Data(40000,remove[0][7]));
        removeSeries.getData().add(new XYChart.Data(45000,remove[0][8]));
        removeSeries.getData().add(new XYChart.Data(50000,remove[0][9]));
        
        XYChart.Series removeSeries1 = new XYChart.Series();
        removeSeries1.setName("LinkedHashSet");
        
        removeSeries1.getData().add(new XYChart.Data(5000,remove[1][0]));
        removeSeries1.getData().add(new XYChart.Data(10000,remove[1][1]));
        removeSeries1.getData().add(new XYChart.Data(15000,remove[1][2]));
        removeSeries1.getData().add(new XYChart.Data(20000,remove[1][3]));
        removeSeries1.getData().add(new XYChart.Data(25000,remove[1][4]));
        removeSeries1.getData().add(new XYChart.Data(30000,remove[1][5]));
        removeSeries1.getData().add(new XYChart.Data(35000,remove[1][6]));
        removeSeries1.getData().add(new XYChart.Data(40000,remove[1][7]));
        removeSeries1.getData().add(new XYChart.Data(45000,remove[1][8]));
        removeSeries1.getData().add(new XYChart.Data(50000,remove[1][9]));
        
        XYChart.Series removeSeries2 = new XYChart.Series();
        removeSeries2.setName("TreeSet");
        
        removeSeries2.getData().add(new XYChart.Data(5000,remove[2][0]));
        removeSeries2.getData().add(new XYChart.Data(10000,remove[2][1]));
        removeSeries2.getData().add(new XYChart.Data(15000,remove[2][2]));
        removeSeries2.getData().add(new XYChart.Data(20000,remove[2][3]));
        removeSeries2.getData().add(new XYChart.Data(25000,remove[2][4]));
        removeSeries2.getData().add(new XYChart.Data(30000,remove[2][5]));
        removeSeries2.getData().add(new XYChart.Data(35000,remove[2][6]));
        removeSeries2.getData().add(new XYChart.Data(40000,remove[2][7]));
        removeSeries2.getData().add(new XYChart.Data(45000,remove[2][8]));
        removeSeries2.getData().add(new XYChart.Data(50000,remove[2][9]));
        
        XYChart.Series removeSeries3 = new XYChart.Series();
        removeSeries3.setName("ArrayList");
        
        removeSeries3.getData().add(new XYChart.Data(5000,remove[3][0]));
        removeSeries3.getData().add(new XYChart.Data(10000,remove[3][1]));
        removeSeries3.getData().add(new XYChart.Data(15000,remove[3][2]));
        removeSeries3.getData().add(new XYChart.Data(20000,remove[3][3]));
        removeSeries3.getData().add(new XYChart.Data(25000,remove[3][4]));
        removeSeries3.getData().add(new XYChart.Data(30000,remove[3][5]));
        removeSeries3.getData().add(new XYChart.Data(35000,remove[3][6]));
        removeSeries3.getData().add(new XYChart.Data(40000,remove[3][7]));
        removeSeries3.getData().add(new XYChart.Data(45000,remove[3][8]));
        removeSeries3.getData().add(new XYChart.Data(50000,remove[3][9]));
        
        XYChart.Series removeSeries4 = new XYChart.Series();
        removeSeries4.setName("LinkedList");
        
        removeSeries4.getData().add(new XYChart.Data(5000,remove[4][0]));
        removeSeries4.getData().add(new XYChart.Data(10000,remove[4][1]));
        removeSeries4.getData().add(new XYChart.Data(15000,remove[4][2]));
        removeSeries4.getData().add(new XYChart.Data(20000,remove[4][3]));
        removeSeries4.getData().add(new XYChart.Data(25000,remove[4][4]));
        removeSeries4.getData().add(new XYChart.Data(30000,remove[4][5]));
        removeSeries4.getData().add(new XYChart.Data(35000,remove[4][6]));
        removeSeries4.getData().add(new XYChart.Data(40000,remove[4][7]));
        removeSeries4.getData().add(new XYChart.Data(45000,remove[4][8]));
        removeSeries4.getData().add(new XYChart.Data(50000,remove[4][9]));
        
        XYChart.Series removeSeries5 = new XYChart.Series();
        removeSeries5.setName("Priority Queue");
        
        removeSeries5.getData().add(new XYChart.Data(5000,remove[5][0]));
        removeSeries5.getData().add(new XYChart.Data(10000,remove[5][1]));
        removeSeries5.getData().add(new XYChart.Data(15000,remove[5][2]));
        removeSeries5.getData().add(new XYChart.Data(20000,remove[5][3]));
        removeSeries5.getData().add(new XYChart.Data(25000,remove[5][4]));
        removeSeries5.getData().add(new XYChart.Data(30000,remove[5][5]));
        removeSeries5.getData().add(new XYChart.Data(35000,remove[5][6]));
        removeSeries5.getData().add(new XYChart.Data(40000,remove[5][7]));
        removeSeries5.getData().add(new XYChart.Data(45000,remove[5][8]));
        removeSeries5.getData().add(new XYChart.Data(50000,remove[5][9]));
        
        XYChart.Series removeSeries6 = new XYChart.Series();
        removeSeries6.setName("Vector");
        
        removeSeries6.getData().add(new XYChart.Data(5000,remove[6][0]));
        removeSeries6.getData().add(new XYChart.Data(10000,remove[6][1]));
        removeSeries6.getData().add(new XYChart.Data(15000,remove[6][2]));
        removeSeries6.getData().add(new XYChart.Data(20000,remove[6][3]));
        removeSeries6.getData().add(new XYChart.Data(25000,remove[6][4]));
        removeSeries6.getData().add(new XYChart.Data(30000,remove[6][5]));
        removeSeries6.getData().add(new XYChart.Data(35000,remove[6][6]));
        removeSeries6.getData().add(new XYChart.Data(40000,remove[6][7]));
        removeSeries6.getData().add(new XYChart.Data(45000,remove[6][8]));
        removeSeries6.getData().add(new XYChart.Data(50000,remove[6][9]));
        
        
        removeLineChart.setMinSize(800, 600);
        
        Button removeBackToTable = new Button("Back To Table");
        removeBackToTable.setTranslateX(800/2);
        removeBackToTable.setOnAction(e-> stage.setScene(s3));
		
        final VBox removeLineBox = new VBox(removeLineChart);
        removeLineBox.setSpacing(5);
        removeLineBox.setPadding(new Insets(10, 0, 0, 10));
        removeLineBox.getChildren().addAll(removeBackToTable);
        removeLineChart.getData().addAll(removeSeries,removeSeries1,removeSeries2,removeSeries3,removeSeries4,removeSeries5,removeSeries6);
        s4  = new Scene(new Group(),900,700);
        ((Group)s4.getRoot()).getChildren().addAll(removeLineBox);
      
		//----------------------------------------------------------------------s5
        final Label forLoopLabel = new Label("For Loop Traversing Time Table");
        forLoopLabel.setFont(new Font("Arial", 20));
        
        //size Column
        TableColumn<Score2, String> size2 = new TableColumn<>("Size");
        size2.setCellValueFactory(new PropertyValueFactory<>("size"));
        
      //size Column
        TableColumn<Score2, String> arrayList2 = new TableColumn<>("ArrayList");
        arrayList2.setCellValueFactory(new PropertyValueFactory<>("arrayList"));
        
      //size Column
        TableColumn<Score2, String> linkedList2 = new TableColumn<>("linkedList");
        linkedList2.setCellValueFactory(new PropertyValueFactory<>("linkedList"));
        
      //size Column
        TableColumn<Score2, String> vector2 = new TableColumn<>("Vector");
        vector2.setCellValueFactory(new PropertyValueFactory<>("vector"));
        
        tableView2 = new TableView<>();
        tableView2.setItems(getForLoopScore());
        tableView2.getColumns().addAll(size2,arrayList2,linkedList2,vector2);
        tableView2.setMinSize(670, 520);       
 
        Button forLoopToTable = new Button("To For Loop Table");
        forLoopToTable.setTranslateX(300);
        forLoopToTable.setOnAction(e-> stage.setScene(s6));
        Button forLoopToback = new Button("Back to Main");
        forLoopToback.setTranslateX(310);
        forLoopToback.setOnAction(e-> stage.setScene(s0));
		
        final VBox forLoopBox = new VBox();
        forLoopBox.setSpacing(5);
        forLoopBox.setPadding(new Insets(10, 10, 10, 50));
        forLoopBox.getChildren().addAll(forLoopLabel, tableView2,forLoopToTable,forLoopToback);
		
        s5  = new Scene(new Group(),800,650);
        ((Group) s5.getRoot()).getChildren().addAll(forLoopBox);
        
        //----------------------------------------------------------------------s6
        final NumberAxis forLoopX = new NumberAxis();
        final NumberAxis forLoopY = new NumberAxis();
        forLoopX.setLabel("Size");
        forLoopY.setLabel("Traversing using for loop");
        //creating the chart
        final LineChart<Number,Number> forLoopLineChart = new LineChart<Number,Number>(forLoopX,forLoopY);
        forLoopLineChart.setTitle("For Loop Traversing Time Graph");
        //defining a series
        XYChart.Series forLoopSeries = new XYChart.Series();
        forLoopSeries.setName("Array List");
        //populating the series with data
        forLoopSeries.getData().add(new XYChart.Data(20000,forLoop[0][0]));
        forLoopSeries.getData().add(new XYChart.Data(40000, forLoop[0][1]));
        forLoopSeries.getData().add(new XYChart.Data(60000, forLoop[0][2]));
        forLoopSeries.getData().add(new XYChart.Data(80000, forLoop[0][3]));
        forLoopSeries.getData().add(new XYChart.Data(100000, forLoop[0][4]));
        forLoopSeries.getData().add(new XYChart.Data(120000, forLoop[0][5]));
        forLoopSeries.getData().add(new XYChart.Data(140000, forLoop[0][6]));
        forLoopSeries.getData().add(new XYChart.Data(160000, forLoop[0][7]));
        forLoopSeries.getData().add(new XYChart.Data(180000, forLoop[0][8]));
        forLoopSeries.getData().add(new XYChart.Data(200000, forLoop[0][9]));
        
        XYChart.Series forLoopSeries1 = new XYChart.Series();
        forLoopSeries1.setName("Linked List");
        //populating the series with data
        forLoopSeries1.getData().add(new XYChart.Data(20000,forLoop[1][0]));
        forLoopSeries1.getData().add(new XYChart.Data(40000, forLoop[1][1]));
        forLoopSeries1.getData().add(new XYChart.Data(60000, forLoop[1][2]));
        forLoopSeries1.getData().add(new XYChart.Data(80000, forLoop[1][3]));
        forLoopSeries1.getData().add(new XYChart.Data(100000, forLoop[1][4]));
        forLoopSeries1.getData().add(new XYChart.Data(120000, forLoop[1][5]));
        forLoopSeries1.getData().add(new XYChart.Data(140000, forLoop[1][6]));
        forLoopSeries1.getData().add(new XYChart.Data(160000, forLoop[1][7]));
        forLoopSeries1.getData().add(new XYChart.Data(180000, forLoop[1][8]));
        forLoopSeries1.getData().add(new XYChart.Data(200000, forLoop[1][9]));
        
        XYChart.Series forLoopSeries2 = new XYChart.Series();
        forLoopSeries2.setName("Vector");
        //populating the series with data
        forLoopSeries2.getData().add(new XYChart.Data(20000,forLoop[2][0]));
        forLoopSeries2.getData().add(new XYChart.Data(40000, forLoop[2][1]));
        forLoopSeries2.getData().add(new XYChart.Data(60000, forLoop[2][2]));
        forLoopSeries2.getData().add(new XYChart.Data(80000, forLoop[2][3]));
        forLoopSeries2.getData().add(new XYChart.Data(100000, forLoop[2][4]));
        forLoopSeries2.getData().add(new XYChart.Data(120000, forLoop[2][5]));
        forLoopSeries2.getData().add(new XYChart.Data(140000, forLoop[2][6]));
        forLoopSeries2.getData().add(new XYChart.Data(160000, forLoop[2][7]));
        forLoopSeries2.getData().add(new XYChart.Data(180000, forLoop[2][8]));
        forLoopSeries2.getData().add(new XYChart.Data(200000, forLoop[2][9]));
        
        forLoopLineChart.setMinSize(800, 600);
        
        Button forLoopBackToTable = new Button("Back To Table");
        forLoopBackToTable.setTranslateX(800/2);
        forLoopBackToTable.setOnAction(e-> stage.setScene(s5));
		
        final VBox forLoopLineBox = new VBox(forLoopLineChart);
        forLoopLineBox.setSpacing(5);
        forLoopLineBox.setPadding(new Insets(10, 0, 0, 10));
        forLoopLineBox.getChildren().addAll(forLoopBackToTable);
        forLoopLineChart.getData().addAll(forLoopSeries,forLoopSeries1,forLoopSeries2);
        s6  = new Scene(new Group(),900,700);
        ((Group)s6.getRoot()).getChildren().addAll(forLoopLineBox);
        //----------------------------------------------------------------------s7
        final Label forEachLabel = new Label("For Each Traversing Time Table");
        forEachLabel.setFont(new Font("Arial", 20));
        
        //size Column
        TableColumn<Score2, String> size3 = new TableColumn<>("Size");
        size3.setCellValueFactory(new PropertyValueFactory<>("size"));
        
      //size Column
        TableColumn<Score2, String> arrayList3 = new TableColumn<>("ArrayList");
        arrayList3.setCellValueFactory(new PropertyValueFactory<>("arrayList"));
        
      //size Column
        TableColumn<Score2, String> linkedList3 = new TableColumn<>("linkedList");
        linkedList3.setCellValueFactory(new PropertyValueFactory<>("linkedList"));
        
      //size Column
        TableColumn<Score2, String> vector3 = new TableColumn<>("Vector");
        vector3.setCellValueFactory(new PropertyValueFactory<>("vector"));
        
        tableView3 = new TableView<>();
        tableView3.setItems(getForEachScore());
        tableView3.getColumns().addAll(size3,arrayList3,linkedList3,vector3);
        tableView3.setMinSize(670, 520);       
 
        Button forEachToTable = new Button("To For Each Table");
        forEachToTable.setTranslateX(300);
        forEachToTable.setOnAction(e-> stage.setScene(s8));
        Button forEachToback = new Button("Back to Main");
        forEachToback.setTranslateX(310);
        forEachToback.setOnAction(e-> stage.setScene(s0));
		
        final VBox forEachBox = new VBox();
        forEachBox.setSpacing(5);
        forEachBox.setPadding(new Insets(10, 10, 10, 50));
        forEachBox.getChildren().addAll(forEachLabel, tableView3,forEachToTable,forEachToback);
		
        s7  = new Scene(new Group(),800,650);
        ((Group) s7.getRoot()).getChildren().addAll(forEachBox);
        //----------------------------------------------------------------------s8
        final NumberAxis forEachX = new NumberAxis();
        final NumberAxis forEachY = new NumberAxis();
        forEachX.setLabel("Size");
        forEachY.setLabel("Traversing using for Each");
        //creating the chart
        final LineChart<Number,Number> forEachLineChart = new LineChart<Number,Number>(forEachX,forEachY);
        forEachLineChart.setTitle("For Each Traversing Time Graph");
        //defining a series
        XYChart.Series forEachSeries = new XYChart.Series();
        forEachSeries.setName("Array List");
        //populating the series with data
        forEachSeries.getData().add(new XYChart.Data(0, forEach[0][0]));
        forEachSeries.getData().add(new XYChart.Data(100000, forEach[0][1]));
        forEachSeries.getData().add(new XYChart.Data(200000, forEach[0][2]));
        forEachSeries.getData().add(new XYChart.Data(300000, forEach[0][3]));
        forEachSeries.getData().add(new XYChart.Data(400000,forEach[0][4]));
        forEachSeries.getData().add(new XYChart.Data(500000,forEach[0][5]));
        forEachSeries.getData().add(new XYChart.Data(600000,forEach[0][6]));
        forEachSeries.getData().add(new XYChart.Data(700000,forEach[0][7]));
        forEachSeries.getData().add(new XYChart.Data(800000,forEach[0][8]));
        forEachSeries.getData().add(new XYChart.Data(900000,forEach[0][9]));
        
        XYChart.Series forEachSeries1 = new XYChart.Series();
        forEachSeries1.setName("Linked List");
        //populating the series with data
        forEachSeries1.getData().add(new XYChart.Data(0, forEach[1][0]));
        forEachSeries1.getData().add(new XYChart.Data(100000, forEach[1][1]));
        forEachSeries1.getData().add(new XYChart.Data(200000, forEach[1][2]));
        forEachSeries1.getData().add(new XYChart.Data(300000, forEach[1][3]));
        forEachSeries1.getData().add(new XYChart.Data(400000,forEach[1][4]));
        forEachSeries1.getData().add(new XYChart.Data(500000,forEach[1][5]));
        forEachSeries1.getData().add(new XYChart.Data(600000,forEach[1][6]));
        forEachSeries1.getData().add(new XYChart.Data(700000,forEach[1][7]));
        forEachSeries1.getData().add(new XYChart.Data(800000,forEach[1][8]));
        forEachSeries1.getData().add(new XYChart.Data(900000,forEach[1][9]));
        
        XYChart.Series forEachSeries2 = new XYChart.Series();
        forEachSeries2.setName("Vector");
        //populating the series with data
        forEachSeries2.getData().add(new XYChart.Data(0, forEach[2][0]));
        forEachSeries2.getData().add(new XYChart.Data(100000, forEach[2][1]));
        forEachSeries2.getData().add(new XYChart.Data(200000, forEach[2][2]));
        forEachSeries2.getData().add(new XYChart.Data(300000, forEach[2][3]));
        forEachSeries2.getData().add(new XYChart.Data(400000,forEach[2][4]));
        forEachSeries2.getData().add(new XYChart.Data(500000,forEach[2][5]));
        forEachSeries2.getData().add(new XYChart.Data(600000,forEach[2][6]));
        forEachSeries2.getData().add(new XYChart.Data(700000,forEach[2][7]));
        forEachSeries2.getData().add(new XYChart.Data(800000,forEach[2][8]));
        forEachSeries2.getData().add(new XYChart.Data(900000,forEach[2][9]));
        
        forEachLineChart.setMinSize(800, 600);
        
        Button forEachBackToTable = new Button("Back To Table");
        forEachBackToTable.setTranslateX(800/2);
        forEachBackToTable.setOnAction(e-> stage.setScene(s7));
		
        final VBox forEachLineBox = new VBox(forEachLineChart);
        forEachLineBox.setSpacing(5);
        forEachLineBox.setPadding(new Insets(10, 0, 0, 10));
        forEachLineBox.getChildren().addAll(forEachBackToTable);
        forEachLineChart.getData().addAll(forEachSeries,forEachSeries1,forEachSeries2);
        s8  = new Scene(new Group(),900,700);
        ((Group)s8.getRoot()).getChildren().addAll(forEachLineBox);
        
        //----------------------------------------------------------------------s0
       
        stage.setTitle("Collection");
        stage.setScene(s0);
        stage.setResizable(false);
        stage.show();
	}
	public ObservableList<Score> getMemberScore(){
		ObservableList<Score> Memberscore = FXCollections.observableArrayList();
		Memberscore.add(new Score("5000",Long.toString(member[0][0]),Long.toString(member[1][0]),
				Long.toString(member[2][0]),Long.toString(member[3][0]),Long.toString(member[4][0])
				,Long.toString(member[5][0]),Long.toString(member[6][0])));
		
		Memberscore.add(new Score("10000",Long.toString(member[0][1]),Long.toString(member[1][1]),
				Long.toString(member[2][1]),Long.toString(member[3][1]),Long.toString(member[4][1])
				,Long.toString(member[5][1]),Long.toString(member[6][1])));
		
		Memberscore.add(new Score("15000",Long.toString(member[0][2]),Long.toString(member[1][2]),
				Long.toString(member[2][2]),Long.toString(member[3][2]),Long.toString(member[4][2])
				,Long.toString(member[5][2]),Long.toString(member[6][2])));
		
		Memberscore.add(new Score("20000",Long.toString(member[0][3]),Long.toString(member[1][3]),
				Long.toString(member[2][3]),Long.toString(member[3][3]),Long.toString(member[4][3])
				,Long.toString(member[5][3]),Long.toString(member[6][3])));
		
		Memberscore.add(new Score("25000",Long.toString(member[0][4]),Long.toString(member[1][4]),
				Long.toString(member[2][4]),Long.toString(member[3][4]),Long.toString(member[4][4])
				,Long.toString(member[5][4]),Long.toString(member[6][4])));
		
		Memberscore.add(new Score("30000",Long.toString(member[0][5]),Long.toString(member[1][5]),
				Long.toString(member[2][5]),Long.toString(member[3][5]),Long.toString(member[4][5])
				,Long.toString(member[5][5]),Long.toString(member[6][5])));
		
		Memberscore.add(new Score("35000",Long.toString(member[0][6]),Long.toString(member[1][6]),
				Long.toString(member[2][6]),Long.toString(member[3][6]),Long.toString(member[4][6])
				,Long.toString(member[5][6]),Long.toString(member[6][6])));
		
		Memberscore.add(new Score("40000",Long.toString(member[0][7]),Long.toString(member[1][7]),
				Long.toString(member[2][7]),Long.toString(member[3][7]),Long.toString(member[4][7])
				,Long.toString(member[5][7]),Long.toString(member[6][7])));
		
		Memberscore.add(new Score("45000",Long.toString(member[0][8]),Long.toString(member[1][8]),
				Long.toString(member[2][8]),Long.toString(member[3][8]),Long.toString(member[4][8])
				,Long.toString(member[5][8]),Long.toString(member[6][8])));
		
		Memberscore.add(new Score("50000",Long.toString(member[0][9]),Long.toString(member[1][9]),
				Long.toString(member[2][9]),Long.toString(member[3][9]),Long.toString(member[4][9])
				,Long.toString(member[5][9]),Long.toString(member[6][9])));
		return Memberscore;
		
	}
	public ObservableList<Score> getRemoveScore(){
		ObservableList<Score> Memberscore = FXCollections.observableArrayList();
		Memberscore.add(new Score("5000",Long.toString(remove[0][0]),Long.toString(remove[1][0]),
				Long.toString(remove[2][0]),Long.toString(remove[3][0]),Long.toString(remove[4][0])
				,Long.toString(remove[5][0]),Long.toString(remove[6][0])));
		
		Memberscore.add(new Score("10000",Long.toString(remove[0][1]),Long.toString(remove[1][1]),
				Long.toString(remove[2][1]),Long.toString(remove[3][1]),Long.toString(remove[4][1])
				,Long.toString(remove[5][1]),Long.toString(remove[6][1])));
		
		Memberscore.add(new Score("15000",Long.toString(remove[0][2]),Long.toString(remove[1][2]),
				Long.toString(remove[2][2]),Long.toString(remove[3][2]),Long.toString(remove[4][2])
				,Long.toString(remove[5][2]),Long.toString(remove[6][2])));
		
		Memberscore.add(new Score("20000",Long.toString(remove[0][3]),Long.toString(remove[1][3]),
				Long.toString(remove[2][3]),Long.toString(remove[3][3]),Long.toString(remove[4][3])
				,Long.toString(remove[5][3]),Long.toString(remove[6][3])));
		
		Memberscore.add(new Score("25000",Long.toString(remove[0][4]),Long.toString(remove[1][4]),
				Long.toString(remove[2][4]),Long.toString(remove[3][4]),Long.toString(remove[4][4])
				,Long.toString(remove[5][4]),Long.toString(remove[6][4])));
		
		Memberscore.add(new Score("30000",Long.toString(remove[0][5]),Long.toString(remove[1][5]),
				Long.toString(remove[2][5]),Long.toString(remove[3][5]),Long.toString(remove[4][5])
				,Long.toString(remove[5][5]),Long.toString(remove[6][5])));
		
		Memberscore.add(new Score("35000",Long.toString(remove[0][6]),Long.toString(remove[1][6]),
				Long.toString(remove[2][6]),Long.toString(remove[3][6]),Long.toString(remove[4][6])
				,Long.toString(remove[5][6]),Long.toString(remove[6][6])));
		
		Memberscore.add(new Score("40000",Long.toString(remove[0][7]),Long.toString(remove[1][7]),
				Long.toString(remove[2][7]),Long.toString(remove[3][7]),Long.toString(remove[4][7])
				,Long.toString(remove[5][7]),Long.toString(remove[6][7])));
		
		Memberscore.add(new Score("45000",Long.toString(remove[0][8]),Long.toString(remove[1][8]),
				Long.toString(remove[2][8]),Long.toString(remove[3][8]),Long.toString(remove[4][8])
				,Long.toString(remove[5][8]),Long.toString(remove[6][8])));
		
		Memberscore.add(new Score("50000",Long.toString(remove[0][9]),Long.toString(remove[1][9]),
				Long.toString(remove[2][9]),Long.toString(remove[3][9]),Long.toString(remove[4][9])
				,Long.toString(remove[5][9]),Long.toString(remove[6][9])));
		return Memberscore;
		
	}
	public ObservableList<Score2> getForLoopScore(){
		ObservableList<Score2> Memberscore = FXCollections.observableArrayList();
		Memberscore.add(new Score2("20000",Long.toString(forLoop[0][0]),Long.toString(forLoop[1][0]),
				Long.toString(forLoop[2][0])));
		Memberscore.add(new Score2("40000",Long.toString(forLoop[0][1]),Long.toString(forLoop[1][1]),
				Long.toString(forLoop[2][1])));
		Memberscore.add(new Score2("60000",Long.toString(forLoop[0][2]),Long.toString(forLoop[1][2]),
				Long.toString(forLoop[2][2])));
		Memberscore.add(new Score2("80000",Long.toString(forLoop[0][3]),Long.toString(forLoop[1][3]),
				Long.toString(forLoop[2][3])));
		Memberscore.add(new Score2("100000",Long.toString(forLoop[0][4]),Long.toString(forLoop[1][4]),
				Long.toString(forLoop[2][4])));
		Memberscore.add(new Score2("120000",Long.toString(forLoop[0][5]),Long.toString(forLoop[1][5]),
				Long.toString(forLoop[2][5])));
		Memberscore.add(new Score2("140000",Long.toString(forLoop[0][6]),Long.toString(forLoop[1][6]),
				Long.toString(forLoop[2][6])));
		Memberscore.add(new Score2("160000",Long.toString(forLoop[0][7]),Long.toString(forLoop[1][7]),
				Long.toString(forLoop[2][7])));
		Memberscore.add(new Score2("180000",Long.toString(forLoop[0][8]),Long.toString(forLoop[1][8]),
				Long.toString(forLoop[2][8])));
		Memberscore.add(new Score2("200000",Long.toString(forLoop[0][9]),Long.toString(forLoop[1][9]),
				Long.toString(forLoop[2][9])));
		return Memberscore;
		
	}
	public ObservableList<Score2> getForEachScore(){
		ObservableList<Score2> Memberscore = FXCollections.observableArrayList();
		Memberscore.add(new Score2("0",Long.toString(forEach[0][0]),Long.toString(forEach[1][0]),
				Long.toString(forEach[2][0])));
		Memberscore.add(new Score2("100000",Long.toString(forEach[0][1]),Long.toString(forEach[1][1]),
				Long.toString(forEach[2][1])));
		Memberscore.add(new Score2("200000",Long.toString(forEach[0][2]),Long.toString(forEach[1][2]),
				Long.toString(forEach[2][2])));
		Memberscore.add(new Score2("300000",Long.toString(forEach[0][3]),Long.toString(forEach[1][3]),
				Long.toString(forEach[2][3])));
		Memberscore.add(new Score2("400000",Long.toString(forEach[0][4]),Long.toString(forEach[1][4]),
				Long.toString(forEach[2][4])));
		Memberscore.add(new Score2("500000",Long.toString(forEach[0][5]),Long.toString(forEach[1][5]),
				Long.toString(forEach[2][5])));
		Memberscore.add(new Score2("600000",Long.toString(forEach[0][6]),Long.toString(forEach[1][6]),
				Long.toString(forEach[2][6])));
		Memberscore.add(new Score2("700000",Long.toString(forEach[0][7]),Long.toString(forEach[1][7]),
				Long.toString(forEach[2][7])));
		Memberscore.add(new Score2("800000",Long.toString(forEach[0][8]),Long.toString(forEach[1][8]),
				Long.toString(forEach[2][8])));
		Memberscore.add(new Score2("900000",Long.toString(forEach[0][9]),Long.toString(forEach[1][9]),
				Long.toString(forEach[2][9])));
		return Memberscore;
		
	}


}