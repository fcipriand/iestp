package iestp.edu.pe.service;

import iestp.edu.pe.model.Client;

import java.util.List;

public interface IClientService extends ICRUD<Client,Integer> {

	List<Client>findBylastName(String lastName);
}
