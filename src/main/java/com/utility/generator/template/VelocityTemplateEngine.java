package com.utility.generator.template;

import java.io.StringWriter;
import java.io.Writer;
import java.util.Map;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;

public class VelocityTemplateEngine implements TemplateEngine {

	@Override
	public String fillTemplate(String templateName, Map<String, Object> properties) {
		VelocityEngine velocity = new VelocityEngine();

		configure(velocity);

		velocity.init();

		VelocityContext context = createContext(properties);

		Template template = velocity.getTemplate(templateName);

		Writer writer = mergeContextWithTemplate(context, template);

		return writer.toString();
	}

	private void configure(VelocityEngine velocity) {
		velocity.setProperty("input.encoding", "utf-8");
		velocity.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
		velocity.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
	}

	private VelocityContext createContext(Map<String, Object> properties) {
		VelocityContext context = new VelocityContext();
		for (String key : properties.keySet()) {
			context.put(key, properties.get(key));
		}
		return context;
	}

	private Writer mergeContextWithTemplate(VelocityContext context, Template template) {
		Writer writer = new StringWriter();
		template.merge(context, writer);
		return writer;
	}

}
