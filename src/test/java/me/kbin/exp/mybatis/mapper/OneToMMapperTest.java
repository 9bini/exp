package me.kbin.exp.mybatis.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import me.kbin.exp.mybatis.onetomany.One;
import me.kbin.exp.mybatis.onetomany.OneToM;
import me.kbin.exp.mybatis.onetomany.OneToMMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mybatis.spring.boot.test.autoconfigure.AutoConfigureMybatis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;


@DataJpaTest
@AutoConfigureMybatis
@ExtendWith(SpringExtension.class)
class OneToMMapperTest {

  @Autowired
  OneToMMapper oneToMMapper;

  @Autowired
  private TestEntityManager entityManager;


  @Test
  void get() {
    OneToM saveOneToMany = entityManager.persist(new OneToM());

    One one = new One(null, saveOneToMany);
    saveOneToMany.getOnes().add(one);

    One saveOne = entityManager.persist(one);
    entityManager.flush();
    assertNotNull(saveOne.getOneToM());

    List<OneToM> oneToMS = oneToMMapper.get(saveOneToMany.getId());
    assertEquals(1, oneToMS.size());
    assertEquals(1, oneToMS.get(0).getOnes().size());

  }

}