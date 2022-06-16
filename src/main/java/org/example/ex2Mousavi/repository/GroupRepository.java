package org.example.ex2Mousavi.repository;

import org.example.ex2Mousavi.model.Group;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GroupRepository extends PagingAndSortingRepository<Group,Long> {

}
