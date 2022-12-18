package com.aem.training.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Play {
	void display()
	{
		System.out.println("This is to test Git repo of kiran");
	}
	int add(int a,int b)
	{
		int c=a+b;
		System.out.println("the value of c:"+c);
		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Play t=new Play();
		t.display();
		t.add(45, 54);
		ArrayList al=new ArrayList();
		al.add("Raghu");
		al.add("Talluri");
		al.add("Apple");
        al.sort(Comparator.naturalOrder());		
        System.out.println(al);
	}
}

