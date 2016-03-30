package com.school.cbis.service;

import com.school.cbis.domain.Tables;
import com.school.cbis.domain.tables.daos.TeacherDao;
import com.school.cbis.domain.tables.pojos.Teacher;
import com.school.cbis.domain.tables.records.TeacherRecord;
import com.school.cbis.vo.users.TeacherVo;
import org.jooq.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Created by lenovo on 2016-02-15.
 */
@Service("teacherService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class TeacherServiceImpl implements TeacherService {

    private final DSLContext create;

    private TeacherDao teacherDao;

    @Autowired
    public TeacherServiceImpl(DSLContext dslContext, Configuration configuration) {
        this.create = dslContext;
        this.teacherDao = new TeacherDao(configuration);
    }

    @Override
    public Result<TeacherRecord> findByTieIdAndTearchName(String teacherName, int tieId) {
        Result<TeacherRecord> records = create.selectFrom(Tables.TEACHER).where(Tables.TEACHER.TEACHER_NAME.like("%" + teacherName + "%").and(Tables.TEACHER.TIE_ID.eq(tieId))).fetch();
        return records;
    }

    @Override
    public List<Teacher> findByTeacherJobNumber(String teacherJobNumber) {
        List<Teacher> teachers = teacherDao.fetchByTeacherJobNumber(teacherJobNumber);
        return teachers;
    }

    @Override
    public Teacher findById(int id) {
        Teacher teacher = teacherDao.findById(id);
        return teacher;
    }

    @Override
    public Result<Record5<Integer, String, String, Byte, String>> findByTieIdAndPage(String teacherName, String teacherJobNumber, int pageNum, int pageSize, int tieId) {
        Condition a = Tables.TEACHER.TIE_ID.eq(tieId);


        if (StringUtils.hasLength(teacherName)) {
            a = a.and(Tables.TEACHER.TEACHER_NAME.like("%" + teacherName + "%"));
        }

        if (StringUtils.hasLength(teacherJobNumber)) {
            a = a.and(Tables.TEACHER.TEACHER_JOB_NUMBER.like("%" + teacherJobNumber + "%"));
        }

        if (pageNum <= 0) {
            pageNum = 1;
        }

        Result<Record5<Integer, String, String, Byte, String>> record5s = create.select(Tables.TEACHER.ID,
                Tables.TEACHER.TEACHER_NAME, Tables.TEACHER.TEACHER_JOB_NUMBER, Tables.USERS.ENABLED,
                Tables.AUTHORITIES.AUTHORITY)
                .from(Tables.TEACHER)
                .leftJoin(Tables.USERS)
                .on(Tables.TEACHER.TEACHER_JOB_NUMBER.eq(Tables.USERS.USERNAME))
                .leftJoin(Tables.AUTHORITIES)
                .on(Tables.USERS.USERNAME.eq(Tables.AUTHORITIES.USERNAME))
                .where(a)
                .limit((pageNum - 1) * pageSize, pageSize)
                .fetch();
        return record5s;
    }

    @Override
    public int findByTieIdAndPageCount(String teacherName, String teacherJobNumber, int tieId) {
        Condition a = Tables.TEACHER.TIE_ID.eq(tieId);


        if (StringUtils.hasLength(teacherName)) {
            a = a.and(Tables.TEACHER.TEACHER_NAME.like("%" + teacherName + "%"));
        }

        if (StringUtils.hasLength(teacherJobNumber)) {
            a = a.and(Tables.TEACHER.TEACHER_JOB_NUMBER.like("%" + teacherJobNumber + "%"));
        }

        Record1<Integer> count = create.selectCount()
                .from(Tables.TEACHER)
                .leftJoin(Tables.USERS)
                .on(Tables.TEACHER.TEACHER_JOB_NUMBER.eq(Tables.USERS.USERNAME))
                .leftJoin(Tables.AUTHORITIES)
                .on(Tables.USERS.USERNAME.eq(Tables.AUTHORITIES.USERNAME))
                .where(a)
                .fetchOne();
        return count.value1();
    }

    @Override
    public void save(Teacher teacher) {
        teacherDao.insert(teacher);
    }
}
