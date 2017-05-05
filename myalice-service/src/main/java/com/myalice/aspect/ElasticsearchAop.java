package com.myalice.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ElasticsearchAop {
    Logger logger = LoggerFactory.getLogger(ElasticsearchAop.class);
    @Value("${alice.elasticsearch.enabled}")
    private boolean enabled;

    @Pointcut("execution(* com.myalice.services.QuestionRecordService.*(..))")
    public void executeService() {
    }


    @After("executeService()")
    public void doAfter() throws Throwable {
        logger.info("[切面操作] - [后置通知]");
        if (enabled) {
            System.out.println("[切面操作ES搜索......]");
            logger.info("[切面操作ES搜索......]");
        }
    }


}