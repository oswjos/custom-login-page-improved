package com.lina.customlogin.core.services.impl;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "Custom Login Image Config")
public @interface LoginBackgroundImageConfiguration {

    @AttributeDefinition(
            name = "Css Id",
            description = "The login page background image css Id",
            type = AttributeType.STRING
    )
    String bgImage_cssId() default "bg_default";

}
