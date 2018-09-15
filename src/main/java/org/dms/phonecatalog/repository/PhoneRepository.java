/*
 * @author: David Martinez Sepulveda
 * @date: 15-sep-2018
 * 
 */
package org.dms.phonecatalog.repository;

import org.dms.phonecatalog.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone, Long> {

}
