package com.utility.generator.template;

import java.util.Map;

public interface TemplateEngine {

	String fillTemplate(String templateName, Map<String, Object> properties);

}
