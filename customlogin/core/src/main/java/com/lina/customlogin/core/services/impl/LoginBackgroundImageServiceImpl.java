package com.lina.customlogin.core.services.impl;

import com.lina.customlogin.core.services.LoginBackgroundImageService;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.propertytypes.ServiceDescription;
import org.osgi.service.metatype.annotations.Designate;

@Component(service = LoginBackgroundImageService.class, immediate = true,
        configurationPolicy = ConfigurationPolicy.REQUIRE)
@ServiceDescription("Changes the login page background image according to the runmode")
@Designate(ocd = LoginBackgroundImageConfiguration.class)
public class LoginBackgroundImageServiceImpl implements LoginBackgroundImageService {

    private String bgCssId = "bg_default";

    @Activate
    @Modified
    protected void activate(LoginBackgroundImageConfiguration config) {

        bgCssId = config.bgImage_cssId();

    }

    public String getBackgroundImageCssId() {

        return bgCssId;

    }
}
