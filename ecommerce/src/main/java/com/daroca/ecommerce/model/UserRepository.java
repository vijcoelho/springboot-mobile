package com.daroca.ecommerce.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface UserRepository extends CrudRepository<User, Integer> {
    User findUserByEmail(String email);
}
