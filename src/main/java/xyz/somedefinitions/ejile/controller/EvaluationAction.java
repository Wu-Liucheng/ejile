package xyz.somedefinitions.ejile.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.somedefinitions.ejile.entity.Evaluation;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.EvaluationService;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping(value = "/evaluation")
public class EvaluationAction {
    @Resource
    EvaluationService evaluationService;

    @RequestMapping(value="/add",method = RequestMethod.POST)
    @ResponseBody
    public RequestResult<Void> add(@RequestParam @Valid Evaluation evaluation){
        return evaluationService.add(evaluation);
    }

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    @ResponseBody
    public RequestResult<Evaluation> get(@RequestParam String number){
        return evaluationService.get(number);
    }
}
