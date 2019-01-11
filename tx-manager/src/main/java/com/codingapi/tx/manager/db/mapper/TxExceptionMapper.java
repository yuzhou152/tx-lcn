package com.codingapi.tx.manager.db.mapper;

import com.codingapi.tx.manager.db.domain.TxException;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Description:
 * Date: 2018/12/18
 *
 * @author ujued
 */
@Mapper
public interface TxExceptionMapper {

    @Insert("insert into t_tx_exception(group_id, unit_id, mod_id, transaction_state, registrar, ex_state, create_time) " +
            "values(#{groupId}, #{unitId}, #{modId}, #{transactionState}, #{registrar}, #{exState}, #{createTime})")
    void save(TxException txException);

    @Select("select * from t_tx_exception where group_id=#{groupId} and unit_id=#{unitId}")
    TxException getByGroupAndUnitId(@Param("groupId") String groupId, @Param("unitId") String unitId);

    @Select("select * from t_tx_exception")
    List<TxException> findAll();

    @Update("update t_tx_exception set ex_state=#{state} where id=#{id}")
    void changeExState(@Param("id") Long id, @Param("state") short state);

    @Select("select * from t_tx_exception where group_id=#{groupId}")
    TxException getByGroupId(String groupId);

    @Select("select transaction_state from t_tx_exception where group_id=#{groupId} limit 1")
    Integer getTransactionStateByGroupId(String groupId);
}
