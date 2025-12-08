package iestp.edu.pe.service.impl;

import iestp.edu.pe.repository.IClientRepo;
import iestp.edu.pe.repository.IGenericRepo;
import iestp.edu.pe.service.IClientService;
import iestp.edu.pe.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService extends CRUDimpl<Client,Integer> implements IClientService {

    private final IClientRepo repo;

    @Override
    protected IGenericRepo<Client, Integer> getRepo() {
        return repo;
    }

	@Override
	public List<Client> findBylastName(String lastName) {
		// TODO Auto-generated method stub
		return repo.findBylastName(lastName);
	}

   
    
}
