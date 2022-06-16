package org.example.ex2Mousavi.repository;

import org.example.ex2Mousavi.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository <User,Long> {
}
