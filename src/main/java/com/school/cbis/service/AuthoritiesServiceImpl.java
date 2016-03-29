package com.school.cbis.service;

import com.school.cbis.domain.Tables;
import com.school.cbis.domain.tables.pojos.Authorities;
import com.school.cbis.domain.tables.records.AuthoritiesRecord;
import org.apache.log4j.Logger;
import org.jooq.BatchBindStep;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lenovo on 2016-02-21.
 */
@Service("authoritiesService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class AuthoritiesServiceImpl implements AuthoritiesService {

    private static Logger logger = Logger.getLogger(AuthoritiesServiceImpl.class);

    private final DSLContext create;

    @Autowired
    public AuthoritiesServiceImpl(DSLContext dslContext) {
        this.create = dslContext;
    }

    @Override
    public AuthoritiesRecord findByUsername(String username) {
        AuthoritiesRecord authoritiesRecord = create.selectFrom(Tables.AUTHORITIES).where(Tables.AUTHORITIES.USERNAME.eq(username)).fetchOne();
        return authoritiesRecord;
    }

    @Override
    public void delete(String username) {
        create.deleteFrom(Tables.AUTHORITIES).where(Tables.AUTHORITIES.USERNAME.eq(username));
    }

    @Override
    public void update(AuthoritiesRecord authoritiesRecord) {
        create.update(Tables.AUTHORITIES)
                .set(Tables.AUTHORITIES.AUTHORITY, authoritiesRecord.getAuthority())
                .where(Tables.AUTHORITIES.USERNAME.eq(authoritiesRecord.getUsername())).execute();
    }

    @Override
    public void save(AuthoritiesRecord authoritiesRecord) {
        create.insertInto(Tables.AUTHORITIES)
                .set(Tables.AUTHORITIES.USERNAME, authoritiesRecord.getUsername())
                .set(Tables.AUTHORITIES.AUTHORITY, authoritiesRecord.getAuthority())
                .execute();
    }
}
