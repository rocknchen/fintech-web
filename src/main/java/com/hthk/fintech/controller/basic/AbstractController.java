package com.hthk.fintech.controller.basic;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hthk.fintech.action.basic.AbstractApplication;
import com.hthk.fintech.component.AbstractComponent;
import com.hthk.fintech.model.software.app.AppVersion;
import com.hthk.fintech.model.web.http.HttpResponse;
import com.hthk.fintech.utils.HttpResponseUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;

import static com.hthk.fintech.config.FintechStaticData.KW_APP_VERSION;
import static com.hthk.fintech.config.FintechStaticData.LOG_WRAP;

/**
 * @Author: Rock CHEN
 * @Date: 2023/12/20 14:58
 */
public abstract class AbstractController extends AbstractComponent {

    private final static Logger logger = LoggerFactory.getLogger(AbstractController.class);

    @GetMapping(value = "/appVersion")
    public HttpResponse<?> getAppVersion() throws JsonProcessingException {

        AppVersion appVersion = appInfoService.getVersion();
        logger.info(LOG_WRAP, KW_APP_VERSION, getDefaultObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(appVersion));
        return HttpResponseUtils.success(appVersion);
    }

}