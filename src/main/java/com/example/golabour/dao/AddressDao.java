package com.example.golabour.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.golabour.model.Address;

public interface AddressDao extends JpaRepository<Address, Integer> {

}
