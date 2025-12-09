package iestp.edu.pe.repository;

import iestp.edu.pe.model.Client;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientRepo extends IGenericRepo<Client,Integer> {
   // Category getCustomcategory();

	List<Client>findBylastName(String lastName);
}
