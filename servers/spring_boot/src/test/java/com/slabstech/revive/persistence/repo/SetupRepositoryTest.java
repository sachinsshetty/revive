package com.slabstech.revive.persistence.repo;

import com.slabstech.revive.persistence.model.Setup;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@DataJpaTest
public class SetupRepositoryTest {

    @Autowired
    private SetupRepository setupRepository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    public void getSetup_returnSetupDetails()throws Exception{
        Setup savedSetup = testEntityManager.persistAndFlush(new Setup("v0.0.1"));
        Setup setup = setupRepository.findByName("v0.0.1");
    }
}