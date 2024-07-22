package com.example.banking;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    List<Member> findByName(String name);

    @Query("SELECT a FROM Member a WHERE a.name = :name")
    List<Member> findAllByName(@Param("name") String name);
}
