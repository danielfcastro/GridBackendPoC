package com.ing.grid.database.repository;

import com.ing.grid.database.entity.MyTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyTableRepository extends JpaRepository<MyTable, Long> {
}
