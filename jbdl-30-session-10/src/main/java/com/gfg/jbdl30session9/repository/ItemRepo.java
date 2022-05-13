package com.gfg.jbdl30session9.repository;

import com.gfg.jbdl30session9.entity.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepo extends CrudRepository<Item,Long> {
}
