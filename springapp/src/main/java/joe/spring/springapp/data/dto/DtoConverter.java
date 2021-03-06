package joe.spring.springapp.data.dto;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import joe.spring.springapp.data.domain.Customer;
import joe.spring.springapp.data.reference.Country;
import joe.spring.springapp.data.reference.State;
import joe.spring.springdomain.CountryDto;
import joe.spring.springdomain.CustomerDto;
import joe.spring.springdomain.StateDto;

public final class DtoConverter {
	
	public static CountryDto toCountryDto(Country c) {
		CountryDto dto = new CountryDto();
		dto.setId(c.getId());
		dto.setCode(c.getCode());
		dto.setName(c.getName());
		return dto;
	}

	public static List<CountryDto> toCountryDtoList(List<Country> list) {
		ArrayList<CountryDto> dtoList = new ArrayList<CountryDto>();
		for (Country obj : list) {
			CountryDto dto = toCountryDto(obj);
			dtoList.add(dto);
		}		
		return dtoList;
	}

	public static StateDto toStateDto(State obj) {
		StateDto dto = new StateDto();
		dto.setId(obj.getId());
		dto.setCode(obj.getCode());
		dto.setName(obj.getName());
		dto.setCountryCode(obj.getCountry().getCode());
		return dto;
	}

	public static List<StateDto> toStateDtoList(List<State> list) {
		ArrayList<StateDto> dtoList = new ArrayList<StateDto>();
		for (State obj : list) {
			StateDto dto = toStateDto(obj);
			dtoList.add(dto);
		}		
		return dtoList;
	}

	public static CustomerDto toCustomerDto(Customer obj) {
		CustomerDto dto = new CustomerDto();
		dto.setId(obj.getId());
		dto.setFirstName(obj.getFirstName());
		dto.setLastName(obj.getLastName());
		dto.setUserName(obj.getUserName());		
		Calendar c = Calendar.getInstance();
		c.setTime(obj.getBirthDate());
		dto.setBirthDate(c);
		return dto;
	}

	public static List<CustomerDto> toCustomerDtoList(List<Customer> list) {
		ArrayList<CustomerDto> dtoList = new ArrayList<CustomerDto>();
		for (Customer obj : list) {
			dtoList.add(toCustomerDto(obj));
		}		
		return dtoList;
	}
	
}
