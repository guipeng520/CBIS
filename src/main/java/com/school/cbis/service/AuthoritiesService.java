package com.school.cbis.service;

import com.school.cbis.domain.tables.records.AuthoritiesRecord;

import java.util.List;

/**
 * Created by lenovo on 2016-02-21.
 */
public interface AuthoritiesService {
    /**
     * 通过用户名查询
     *
     * @param username
     * @return
     */
    List<AuthoritiesRecord> findByUsername(String username);

    /**
     * 通过用户名删除
     *
     * @param username 用户名
     */
    void delete(String username);

    /**
     * 更新权限
     *
     * @param authoritiesRecords
     */
    void update(List<AuthoritiesRecord> authoritiesRecords);

    /**
     * 保存权限
     *
     * @param authoritiesRecords
     */
    void save(List<AuthoritiesRecord> authoritiesRecords);
}
