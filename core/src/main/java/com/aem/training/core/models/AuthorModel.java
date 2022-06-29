package com.aem.training.core.models;

import java.util.*;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.apache.sling.models.annotations.Default;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Optional;
import org.apache.sling.models.annotations.Via;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;
import org.apache.sling.models.annotations.injectorspecific.RequestAttribute;
import org.apache.sling.models.annotations.injectorspecific.ResourcePath;
import org.apache.sling.models.annotations.injectorspecific.ScriptVariable;
import org.apache.sling.models.annotations.injectorspecific.Self;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.search.QueryBuilder;
import com.day.cq.wcm.api.Page;


/*@Model(adaptables={Resource.class, SlingHttpServletRequest.class}, defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class AuthorModel{
	
	private static final Logger LOG = LoggerFactory.getLogger(AuthorModel.class);

	@ValueMapValue
	@Optional
	private String fname;
	
	@ValueMapValue
	@Optional
	private String lname;
	
	@ValueMapValue
	@Optional
	private boolean professor;
    
	@PostConstruct
	public void init(){
		LOG.info("from init method");
		LOG.info("fname: {}", fname);
		LOG.info("lname: {}", lname);
	}
	public String getFirstName() {
		// TODO Auto-generated method stub
		return fname;
	}

	
	public String getLastName() {
		// TODO Auto-generated method stub
		return lname;
	}

	
	public boolean getIsProfessor() {
		// TODO Auto-generated method stub
		return professor;
	}

}
*/
@Model(adaptables={SlingHttpServletRequest.class,Resource.class},defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class AuthorModel
{
private static final Logger LOG=LoggerFactory.getLogger(AuthorModel.class);

@SlingObject
ResourceResolver resourceResolver;

@Self
SlingHttpServletRequest slinghttpservletrequest;

@OSGiService
QueryBuilder queryBuilder;

@ValueMapValue
@Named("jcr:lastModifiedBy")
private String modified;

@ValueMapValue
@Default(values="AEM")
@Via("resource")
private String fname;

@ValueMapValue
@Default(values="Training")
@Via("resource")
private String lname;

@ValueMapValue
@Via("resource")
private boolean professor;

@RequestAttribute(name="kAttribute")
private String reqAttribute;

@ScriptVariable
Page currentPage;

@ResourcePath(path="/content/training/us/en/TrainingContent")
Resource resource;

private String getHomePageName;

public String getHomePageName()
{
	return resource.getName();
}

public String getLastModifiedBy()
{
	return modified;
}
@PostConstruct
public void init(){
	LOG.info("from init method");
	LOG.info("f: {}", fname);
	LOG.info("lname: {}", lname);
	LOG.info("professor: {}",professor);
	LOG.info("reqAttribute:{}",reqAttribute);
	LOG.info("resource:{}",getHomePageName());
	LOG.info("\n inside init method {} : {} : {} : {}",currentPage.getTitle(),resource.getPath(),currentPage.getPageManager(),currentPage.getLastModifiedBy());
}
public String getFirstName()
{
	return fname;
}

public String getLastName()
{
    return lname;	
}

public boolean getIsProfessor()
{
   return professor;	
}

public String getreqAttribute()
{
	return reqAttribute;
}

@ValueMapValue
private List<String> books;

public List<String> getBooks()
{
	
	if(books!=null)
	{
		return new ArrayList<String>(books);
	}
	else
	return Collections.emptyList();
	
}

/*public static ResourceResolver newResolver( ResourceResolverFactory resourceResolverFactory ) throws LoginException {
    final Map<String, Object> paramMap = new HashMap<String, Object>();
    paramMap.put( ResourceResolverFactory.SUBSERVICE, GEEKS_SERVICE_USER );

    // fetches the admin service resolver using service user.
    ResourceResolver resolver = resourceResolverFactory.getServiceResourceResolver(paramMap);
    return resolver;
}*/
}




