package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import xyz.somedefinitions.ejile.dao.EvaluationMapper;
import xyz.somedefinitions.ejile.service.EvaluationService;

import javax.annotation.Resource;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Resource
    EvaluationMapper evaluationMapper;
}
