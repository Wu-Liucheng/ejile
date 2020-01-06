package xyz.somedefinitions.ejile.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.somedefinitions.ejile.entity.Evaluation;

@Mapper
public interface EvaluationMapper {
    @Select("select * from evaluation where number = #{number}")
    Evaluation selectByPrimaryKey(String number);

    @Insert("insert into evaluation(number,stars,content,createTime) values(#{number}," +
            "#{stars},#{content},#{createTime});")
    int insert(Evaluation evaluation);
}
