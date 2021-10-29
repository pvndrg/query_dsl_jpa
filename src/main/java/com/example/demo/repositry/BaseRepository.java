package com.example.demo.repositry;

import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Niu Li
 * @date 2017/1/8
 */
@NoRepositoryBean
public class BaseRepository {

    @PersistenceContext(unitName = "")
    protected EntityManager em;


}
