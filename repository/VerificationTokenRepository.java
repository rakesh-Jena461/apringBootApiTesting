package com.myproject.my_Domy_project.repository;

import com.myproject.my_Domy_project.entyty.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerificationTokenRepository extends JpaRepository<VerificationToken,Long> {
    VerificationToken findByToken(String token);
}
