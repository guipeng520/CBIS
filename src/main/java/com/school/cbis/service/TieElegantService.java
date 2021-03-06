package com.school.cbis.service;

import com.school.cbis.domain.tables.pojos.TieElegant;
import com.school.cbis.vo.tie.TieElegantVo;
import org.jooq.Record3;
import org.jooq.Record4;
import org.jooq.Record5;
import org.jooq.Result;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by lenovo on 2016-01-24.
 */
public interface TieElegantService {
    /**
     * 保存文章信息到系风采表
     *
     * @param tieElegant
     * @return id
     */
    void save(TieElegant tieElegant);

    /**
     * 分页模糊搜索
     *
     * @param tieElegantVo
     * @param tie_id
     * @return
     */
    Result<Record5<Integer, String, String, Timestamp,Byte>> findByTieIdWithBigTitleAndPage(TieElegantVo tieElegantVo, int tie_id);

    /**
     * 查询总数
     *
     * @param tieElegantVo
     * @param tie_id
     * @return
     */
    int findByTieIdWithBigTitleAndCount(TieElegantVo tieElegantVo, int tie_id);

    /**
     * 通过文章id删除
     *
     * @param id 文章id
     * @return
     */
    void deleteByArticleInfoId(int id);

    /**
     * 更新系风采文章信息
     *
     * @param tieElegant
     * @return
     */
    void update(TieElegant tieElegant);

    /**
     * 通过id查询系风采文章信息
     *
     * @param id
     * @return
     */
    TieElegant findById(int id);

    /**
     * 分页查询系风采文章id,标题
     *
     * @param tieId
     * @param pageNum
     * @param pageSize
     * @return
     */
    Result<Record4<Integer, String, String, String>> findByTieIdWithArticleOrderByDateDescAndPage(int tieId, int pageNum, int pageSize);

    /**
     * 通过系风采时间组查询
     *
     * @param tieElegantTimeId
     * @return
     */
    Result<Record3<Integer, String, Timestamp>> findByTieElegantTimeIdOrBigTitleWithArticleOrderByDateDesc(int tieElegantTimeId, String bigTitle);

    /**
     * 通过show字段查询
     * @param bytes
     * @return
     */
    List<TieElegant> findByShow(Byte bytes);

    /**
     * 通过主键删除
     * @param id
     */
    void deleteById(int id);
}
