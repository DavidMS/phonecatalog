/*
 * @author: ${author}
 * @date: 16-sep-2018
 * 
 */
package org.dms.phonecatalog.repository;

import org.dms.phonecatalog.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface PhoneRepository.
 */
public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
