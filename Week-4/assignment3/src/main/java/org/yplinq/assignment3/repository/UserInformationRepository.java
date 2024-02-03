package org.yplinq.assignment3.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.yplinq.assignment3.entity.UserInformation;

import java.util.List;

/**
 * perform database operations related to entity UserInformation
 */

@Repository
public interface UserInformationRepository extends CrudRepository<UserInformation, Integer> {
    List<UserInformation> findByEmail(String email);

    List<UserInformation> findByPassword(String password);

}
