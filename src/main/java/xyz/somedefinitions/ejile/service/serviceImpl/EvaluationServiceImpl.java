package xyz.somedefinitions.ejile.service.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import xyz.somedefinitions.ejile.dao.EvaluationMapper;
import xyz.somedefinitions.ejile.dao.OrderMapper;
import xyz.somedefinitions.ejile.entity.Evaluation;
import xyz.somedefinitions.ejile.entity.RequestResult;
import xyz.somedefinitions.ejile.service.EvaluationService;

import javax.annotation.Resource;

@Service
public class EvaluationServiceImpl implements EvaluationService {
    @Resource
    EvaluationMapper evaluationMapper;

    @Resource
    OrderMapper orderMapper;

    @Transactional
    @Override
    public RequestResult<Void> add(Evaluation evaluation) {
        if (orderMapper.selectByPrimaryKey(evaluation.getNumber()) == null) {
            return new RequestResult<>(false,null,"没有该订单！");
        }
        if (evaluationMapper.selectByPrimaryKey(evaluation.getNumber()) != null) {
            return new RequestResult<>(false,null,"已经评价过了！");
        }
        return new RequestResult<>(evaluationMapper.insert(evaluation)>0,null,"");
    }

    @Override
    public RequestResult<Evaluation> get(String number) {
        Evaluation evaluation = evaluationMapper.selectByPrimaryKey(number);
        return new RequestResult<>(evaluation!=null,evaluation,"");
    }
}
