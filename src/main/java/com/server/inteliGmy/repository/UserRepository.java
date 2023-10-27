package com.server.inteliGmy.repository;

import com.server.inteliGmy.model.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<BaseUser, Long> {

    @Query(
            "SELECT a FROM BaseUser a WHERE a.uid = :uid"
    )
    BaseUser findBaseUserDTOByUid(String uid);
}
