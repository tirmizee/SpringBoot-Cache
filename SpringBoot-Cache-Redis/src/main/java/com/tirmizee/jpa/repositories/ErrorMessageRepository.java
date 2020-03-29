package com.tirmizee.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.tirmizee.jpa.enties.ErrorMessage;

public interface ErrorMessageRepository extends JpaRepository<ErrorMessage, Long>, JpaSpecificationExecutor<ErrorMessage> {

}
