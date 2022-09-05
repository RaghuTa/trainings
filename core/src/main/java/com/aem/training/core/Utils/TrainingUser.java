package com.aem.training.core.Utils;

import java.util.HashMap;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;

public class TrainingUser {
	private TrainingUser()
	{
		
	}
public static ResourceResolver getResolver(final ResourceResolverFactory resolverFactory) throws LoginException
{
	Map<String, Object> param=new HashMap<String,Object>();
	param.put(ResourceResolverFactory.SUBSERVICE, "trainingserviceuser");
	ResourceResolver resolver=resolverFactory.getServiceResourceResolver(param);
	return resolver;
	
}
}
