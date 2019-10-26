package com.lina.customlogin.core.services.impl;

import io.wcm.testing.mock.aem.junit5.AemContext;
import io.wcm.testing.mock.aem.junit5.AemContextExtension;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(AemContextExtension.class)
public class LoginBackgroundImageServiceImplTest {

    private LoginBackgroundImageServiceImpl loginBackgroundImageServiceImpl;

    private AemContext context;

    private Map<String, Object> parameters;

    @BeforeEach
    public void setup() throws Exception {

        parameters = new HashMap<>();

        context = new AemContext();

        loginBackgroundImageServiceImpl = new LoginBackgroundImageServiceImpl();

    }

    @Test
    void whenNoRunmodeThenReturnDefaultCssId() throws Exception {

        String cssId = "bg_default";

        String bgCssId = loginBackgroundImageServiceImpl.getBackgroundImageCssId();
        assertNotNull(bgCssId);
        assertTrue(StringUtils.equals(bgCssId, cssId));
    }

    @Test
    void whenRunmodeGinzaThenReturnGinzaCssId() throws Exception {

        String cssId = "bg_author_ginza";
        parameters.put("bgImage.cssId", cssId);
        context.registerInjectActivateService(loginBackgroundImageServiceImpl, parameters);

        String bgCssId = loginBackgroundImageServiceImpl.getBackgroundImageCssId();
        assertNotNull(bgCssId);
        assertTrue(StringUtils.equals(bgCssId, cssId));
    }

    @Test
    void whenRunmodeHongKongThenReturnHongKongCssId() throws Exception {

        String cssId = "bg_author_hongkong";
        parameters.put("bgImage.cssId", cssId);
        context.registerInjectActivateService(loginBackgroundImageServiceImpl, parameters);

        String bgCssId = loginBackgroundImageServiceImpl.getBackgroundImageCssId();
        assertNotNull(bgCssId);
        assertTrue(StringUtils.equals(bgCssId, cssId));

    }

}
