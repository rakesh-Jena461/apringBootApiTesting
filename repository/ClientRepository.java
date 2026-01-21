package com.myproject.my_Domy_project.repository;


import com.myproject.my_Domy_project.entyty.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client,Long> {
}
