package com.api.crud.repository;

import com.api.crud.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Repositorio es una clse que permite hacer queries a una base de datos
public interface IUserRepository extends JpaRepository<UserModel, Long> {

}
