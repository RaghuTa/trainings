package com.aem.training.core.models;

import java.util.*;

import org.apache.sling.api.resource.Resource;


public class NestedHelper {
private int bookedition;
private Date editiondate;

public int getBookEdition()
{
	return bookedition;
}
public Date getEditionDate()
{
	return editiondate;
}

public NestedHelper(Resource resource)
{
	if(resource.getValueMap().get("editiondate",Date.class)!=null)
	{
		this.editiondate=resource.getValueMap().get("editiondate",Date.class);
	}
	if(resource.getValueMap().get("bookedition",Integer.class)!=null)
	{
		this.bookedition=resource.getValueMap().get("bookedition",Integer.class);
	}
}
	/*  private int bookEditon;
	    private Date editonDate;
	    public NestedHelper(Resource resource){
	        if(resource.getValueMap().get("bookediton", Integer.class)!=null) {
	            this.bookEditon = resource.getValueMap().get("bookediton", Integer.class);
	        }
	        if(resource.getValueMap().get("editondate",Date.class)!=null){
	            this.editonDate=resource.getValueMap().get("editondate",Date.class);
	        }

	    }

	    public int getBookEditon() {
	        return bookEditon;
	    }

	    public Date getEditonDate() {
	        return editonDate;
	    }*/
	

}
