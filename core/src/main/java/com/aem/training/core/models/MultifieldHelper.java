package com.aem.training.core.models;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.sling.api.resource.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import com.aem.training.core.models.AuthorBooks;

//import com.aem.firstapp.core.models.NestedHelper;

//import com.aem.firstapp.core.models.NestedHelper;

//import uk.org.lidalia.slf4jext.LoggerFactory;

public class MultifieldHelper
{
private String bookname;
private Date publishdate;
private int copies;
private String bookauthor;
private String booksubject;
private List<NestedHelper> bookEditions;

public String getBookName()
{
	return bookname;
}

public Date getPublishDate()
{
	return publishdate;
}

public int getCopies()
{
	return copies;
}

public String getBookAuthor()
{
	return bookauthor;
}

public String getBookSubject()
{
	return booksubject;
}


public List<NestedHelper> getBookEditions() {
    return bookEditions;
}

public void setBookEditions(List<NestedHelper> bookEditions) {
    this.bookEditions = bookEditions;
}


private static final Logger LOG=LoggerFactory.getLogger(MultifieldHelper.class);

public MultifieldHelper(Resource resource)
{
try
{
	if(StringUtils.isNotBlank(resource.getValueMap().get("bookname",String.class)))
	{
		this.bookname=resource.getValueMap().get("bookname",String.class);
	}
	if(resource.getValueMap().get("publishdate",Date.class)!=null)
	{
		this.publishdate=resource.getValueMap().get("publishdate",Date.class);
	}
	if(resource.getValueMap().get("copies",Integer.class)!=null)
	{
		this.copies=resource.getValueMap().get("copies",Integer.class);
	}
	if(StringUtils.isNotBlank(resource.getValueMap().get("bookauthor",String.class)))
	{
		this.bookauthor=resource.getValueMap().get("bookauthor",String.class);
	}
	if(StringUtils.isNotBlank(resource.getValueMap().get("booksubject",String.class)))
	{
		this.booksubject=resource.getValueMap().get("booksubject",String.class);
	}
}
catch(Exception e)
{
	LOG.info("\n Bean Error" +e.getMessage());
}
}
}