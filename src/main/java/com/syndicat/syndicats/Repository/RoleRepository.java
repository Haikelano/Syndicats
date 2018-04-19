package com.syndicat.syndicats.Repository;

import com.syndicat.syndicats.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
    List<Role> findAll();
    Set<Role> findByRole(String role);

}
