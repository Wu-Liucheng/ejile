package xyz.somedefinitions.ejile.service;

import xyz.somedefinitions.ejile.entity.Evaluation;
import xyz.somedefinitions.ejile.entity.RequestResult;

public interface EvaluationService {
    RequestResult<Void> add(Evaluation evaluation);
    RequestResult<Evaluation> get(String number);
}
