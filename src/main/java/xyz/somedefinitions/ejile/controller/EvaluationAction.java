package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.somedefinitions.ejile.service.EvaluationService;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/evaluation")
public class EvaluationAction {
    @Resource
    EvaluationService evaluationService;
}
