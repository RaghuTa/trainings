package com.aem.training.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import com.aem.training.core.models.MultifieldHelper;
import com.aem.training.core.models.NestedHelper;


@Model(adaptables={SlingHttpServletRequest.class, Resource.class},
defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class AuthorBooks {
	@Inject
	Resource componentResource;

	@ValueMapValue
	private String authorname;

	@ValueMapValue
	private List<String> books;

	public String getAuthorName() {
		return authorname;
	}

	/*
	 * @ValueMapValue private String bookname;
	 * 
	 * @ValueMapValue private String booksubject;
	 * 
	 * @ValueMapValue private String publishyear;
	 */

/*	@ValueMapValue
	private List<Map<String, String>> bookdetailswithmap;*/
	private static final Logger LOG=LoggerFactory.getLogger(AuthorBooks.class);
	
	List<Map<String,String>> getbookdetailswithmap;
	
	public List<Map<String,String>> getBookDetailsWithMap()
	{
	List<Map<String,String>> bookdetails=new ArrayList();
	try
	{
	Resource books=componentResource.getChild("bookdetailswithmap");
	if(books!=null)
	{
		for(Resource book:books.getChildren())
		{
			Map<String,String> bookmap=new HashMap();
			bookmap.put("bookname",book.getValueMap().get("bookname",String.class));
			bookmap.put("booksubject",book.getValueMap().get("booksubject",String.class));
			bookmap.put("publishyear",book.getValueMap().get("publishyear",String.class));
			bookmap.put("test",book.getValueMap().get("test",String.class));
			bookdetails.add(bookmap);
		}
	}

	}
	catch(Exception e)
	{
		System.out.println("this is error message");
	}
	return bookdetails;
	}
	
	public List<String> getAuthorBooks() {
		if (books != null) {
			return new ArrayList<String>(books);
		} else
			return Collections.emptyList();
	}

	@PostConstruct
	public void init() {
		LOG.info("this is in Author Books!!!!!");
	}
	List<MultifieldHelper> bookdetailswithbean;
	public List<MultifieldHelper> getBookDetailsWithBean()
	{
		List<MultifieldHelper> multi=new ArrayList<>();
		try
		{
			Resource res=componentResource.getChild("bookdetailswithbean");
			if(res!=null)
			{
				for(Resource rest:res.getChildren())
				{
					multi.add(new MultifieldHelper(rest));
					
				}
			}
		}
		catch(Exception e)
		{
			LOG.info("\n error in bean authorbooks" +e.getMessage());
		}
		return multi;
	}
	
	
	/*List<MultifieldHelper> bookdetailswithnestedmultifield;
	
	public List<MultifieldHelper> getBookDetailsWithNestedMultifield() {
	    List<MultifieldHelper> bookDetailsNested=new ArrayList<>();
	    try {
	        Resource bookDetailNested=componentResource.getChild("bookdetailswithnestedmultifield");
	        if(bookDetailNested!=null){
	            for (Resource bookNested : bookDetailNested.getChildren()) {
	                MultifieldHelper multifieldHelper=new MultifieldHelper(bookNested);
	                if(bookNested.hasChildren()){
	                    List<NestedHelper> bookNestedList=new ArrayList<>();
	                    Resource nestedResource=bookNested.getChild("bookeditions");
	                    for(Resource nested : nestedResource.getChildren()){
	                        bookNestedList.add(new NestedHelper(nested));
	                    }
	                    multifieldHelper.setBookEditions(bookNestedList);
	                }
	                bookDetailsNested.add(multifieldHelper);
	            }
	        }
	    }catch (Exception e){
	        LOG.info("\n ERROR while getting Book Details With Nested Multifield {} ",e.getMessage());
	    }
	    LOG.info("\n SIZE Multifield {} ",bookDetailsNested.size());
	    return bookDetailsNested;
	}*/
	/*public List<MultifieldHelper> getBookDetailsWithNestedMultifield() {
	    List<MultifieldHelper> bookDetailsNested=new ArrayList<>();
	    try {
	        Resource bookDetailNasted=componentResource.getChild("bookdetailswithnestedmultifield");
	        if(bookDetailNasted!=null){
	            for (Resource bookNested : bookDetailNasted.getChildren()) {
	                MultifieldHelper multifieldHelper=new MultifieldHelper(bookNested);
	                if(bookNested.hasChildren()){
	                    List<NestedHelper> bookNastedList=new ArrayList<>();
	                    Resource nastedResource=bookNested.getChild("bookeditons");
	                    for(Resource nasted : nastedResource.getChildren()){
	                        bookNastedList.add(new NestedHelper(nasted));
	                    }
	                    multifieldHelper.setBookEditons(bookNastedList);
	                }
	                bookDetailsNested.add(multifieldHelper);
	            }
	        }
	    }catch (Exception e){
	        LOG.info("\n ERROR while getting Book Details With Nested Multifield {} ",e.getMessage());
	    }
	    LOG.info("\n SIZE Multifield {} ",bookDetailsNested.size());
	    return bookDetailsNested;
	}	*/
	List<MultifieldHelper> bookdetailswithnestedmultifield;
	public List<MultifieldHelper> getBookDetailsWitNestedMultifield()
	{
		List<MultifieldHelper> mul=new ArrayList<>();
		try
		{
			Resource resou=componentResource.getChild("bookdetailswithnestedmultifield");
			if(resou!=null)
			{
				for(Resource rest:resou.getChildren())
				{
					MultifieldHelper mp=new MultifieldHelper(rest);
					if(rest.hasChildren())
					{
					 List<NestedHelper> np=new ArrayList<>();
					 Resource resc=rest.getChild("bookeditions");
					 for(Resource resce:resc.getChildren())
					 {
						 np.add(new NestedHelper(resce));
					 }
					 mp.setBookEditions(np);
					}
					mul.add(mp);
				}
			}
		}
		catch (Exception e){
	        LOG.info("\n ERROR while getting Book Details With Nested Multifield {} ",e.getMessage());
	}
		return mul;
}
}