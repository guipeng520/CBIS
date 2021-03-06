package com.school.cbis.service;

import com.school.cbis.domain.tables.pojos.AutonomousPracticeContent;
import com.school.cbis.vo.autonomicpractice.*;
import org.jooq.Record;
import org.jooq.Record1;
import org.jooq.Record5;
import org.jooq.Result;

import java.util.List;

/**
 * Created by lenovo on 2016-04-12.
 */
public interface AutonomousPracticeContentService {

    /**
     * 通过自主实习标题表主键删除
     *
     * @param autonomousPracticeHeadId
     */
    void deleteByAutonomousPracticeHeadId(int autonomousPracticeHeadId);

    /**
     * 通过自主实习信息表主键与学生id查询
     * @param autonomousPracticeInfoId
     * @param studentId
     * @return
     */
    Result<Record> findByAutonomousPracticeInfoIdAndStudentId(int autonomousPracticeInfoId, int studentId);

    /**
     * 保存内容
     *
     * @param autonomousPracticeContent
     */
    void save(AutonomousPracticeContent autonomousPracticeContent);

    /**
     * 通过自主实习标题表主键与学生主键删除
     *
     * @param autonomousPracticeHeadId
     * @param studentId
     */
    void deleteByAutonomousPracticeHeadIdAndStudentId(int autonomousPracticeHeadId, int studentId);

    /**
     * distinct studentid查询并分页所有数据 并可根据headId 与content模糊搜索
     * @param autonomicPracticeTeacherListVo
     * @return
     */
    Result<Record1<Integer>> findByAutonomousPracticeInfoIdDistinctStudentIdAndPage(AutonomicPracticeTeacherListVo autonomicPracticeTeacherListVo);

    /**
     *  distinct studentid查询 用于导出数据使用
     * @param autonomicPracticeTeacherListVo
     * @return
     */
    Result<Record1<Integer>> findByAutonomousPracticeInfoIdDistinctStudentId(AutonomicPracticeTeacherListVo autonomicPracticeTeacherListVo);

    /**
     * distinct studentid查询并分页所有数据总数
     * @param autonomicPracticeTeacherListVo
     * @return
     */
    int findByAutonomousPracticeInfoIdDistinctStudentIdAndPageCount(AutonomicPracticeTeacherListVo autonomicPracticeTeacherListVo);

    /**
     * 查询对应该自主实习下该学生的 标题以及对应内容信息
     * @param autonomousPracticeInfoId
     * @param studentId
     * @param isShowHighlyActive
     * @return
     */
    Result<Record> findByAutonomousPracticeInfoIdAndStudentIdAndIsShowHighlyActive(int autonomousPracticeInfoId, int studentId, Byte isShowHighlyActive);

    /**
     * 更新
     *
     * @param autonomousPracticeContent
     */
    void update(AutonomousPracticeContent autonomousPracticeContent);

    /**
     * 按照学生年级统计人数
     * @param autonomousPracticeInfoId
     * @param year
     * @return
     */
    int findByAutonomousPracticeInfoIdDistinctStudentIdAndYearCount(int autonomousPracticeInfoId ,String year);


    /**
     * 按照学生年级 查询学生id
     * @param autonomousPracticeParamVo
     * @return
     */
    Result<Record1<Integer>> findByAutonomousPracticeInfoIdDistinctStudentIdAndYear(AutonomousPracticeParamVo autonomousPracticeParamVo);

    /**
     * 按照学生班级统计人数
     * @param autonomousPracticeInfoId
     * @param gradeId
     * @return
     */
    int findByAutonomousPracticeInfoIdDistinctStudentIdAndGradeIdCount(int autonomousPracticeInfoId ,int gradeId);

    /**
     * 按照学生专业统计人数
     * @param autonomousPracticeInfoId
     * @param majorId
     * @return
     */
    int findByAutonomousPracticeInfoIdDistinctStudentIdAndMajorIdCount(int autonomousPracticeInfoId ,int majorId);

    /**
     * 按照学生专业 查询学生id
     * @param autonomousPracticeParamVo
     * @return
     */
    Result<Record1<Integer>> findByAutonomousPracticeInfoIdDistinctStudentIdAndMajorIdAndYear(AutonomousPracticeParamVo autonomousPracticeParamVo);

    /**
     * 按照学生班级 查询学生id
     * @param autonomousPracticeParamVo
     * @return
     */
    Result<Record1<Integer>> findByAutonomousPracticeInfoIdDistinctStudentIdAndGradeIdAndYear(AutonomousPracticeParamVo autonomousPracticeParamVo);

    /**
     * 根据 autonomousPracticeInfoId查询
     * @param autonomousPracticeInfoId
     * @return
     */
    List<AutonomousPracticeContent> findByAutonomousPracticeInfoId(int autonomousPracticeInfoId);

    /**
     * 通过标题id查询
     * @param autonomousPracticeHeadId
     * @return
     */
    List<AutonomousPracticeContent> findByAutonomousPracticeHeadId(int autonomousPracticeHeadId);

}
