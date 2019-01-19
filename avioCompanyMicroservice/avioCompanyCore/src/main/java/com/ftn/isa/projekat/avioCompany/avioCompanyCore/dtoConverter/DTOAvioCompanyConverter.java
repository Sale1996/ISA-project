package com.ftn.isa.projekat.avioCompany.avioCompanyCore.dtoConverter;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ftn.isa.projekat.avioCompany.avioCompanyApi.dto.AvioCompanyDTO;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.model.AvioCompany;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.AvioCompany.repository.AvioCompanyRepository;
import com.ftn.isa.projekat.avioCompany.avioCompanyCore.Destination.model.Destination;

@Component
public class DTOAvioCompanyConverter 
{
	@Autowired
	private AvioCompanyRepository avioRepository;
	
	@Autowired
	private DTODestinationConverter destConverter;
	
	@Autowired 
	private DTOIncomeConverter incomeConverter;
	
	//ovde sto se doda u konverteru on ce to da vrati preko json-a u postman-u
	
	
	/*
	 * Returns DTO object from regular model object
	 */
	public AvioCompanyDTO convertToDTO(AvioCompany avio)
	{
		AvioCompanyDTO dto = new AvioCompanyDTO();
		
		dto.setId(avio.getId());
		dto.setAddress(avio.getAddress());
		dto.setName(avio.getName());
		dto.setDescription(avio.getDescription());
		//dto.setDestination(destConverter.convertToDto(avio.getDestination()));
		//dto.setIncome(incomeConverter.convertToDTO(avio.getIncome()));
		
		return dto;
	}

	public AvioCompany convertFromDTO(AvioCompanyDTO dto) //nz jel gotova metoda
	{
		Optional<AvioCompany> company = avioRepository.findById(dto.getId());
		
		if(company.isPresent())
		{
			return company.get();
		}
		
		AvioCompany bean = new AvioCompany();
		
		bean.setName(dto.getName());
		bean.setAddress(dto.getAddress());
		bean.setDescription(dto.getDescription());
		//***********************************************
		//bean.setDestination((Destination) destConverter.convertFromDTO(dto.getDestination())); //zasto ovde cast mora??
		//***********************************************
		//bean.setIncome(incomeConverter.convertFromDTO(dto.getIncome()));
		
		return bean;
	}

}

















