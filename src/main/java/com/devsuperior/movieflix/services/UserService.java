package com.devsuperior.movieflix.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityNotFoundException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.devsuperior.movieflix.controller.exceptions.FieldMessage;
import com.devsuperior.movieflix.dto.UserDTO;
import com.devsuperior.movieflix.dto.UserInsertDTO;
import com.devsuperior.movieflix.entities.User;
import com.devsuperior.movieflix.repositories.RoleRepository;
import com.devsuperior.movieflix.repositories.UserRepository;
import com.devsuperior.movieflix.services.exceptions.DatabaseException;
import com.devsuperior.movieflix.services.exceptions.MyUsernameNotFoundException;
import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

import org.springframework.transaction.annotation.Transactional;


@Service
public class UserService implements UserDetailsService{
	
	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository repository;	
	
	@Autowired
	private RoleRepository roleRepository;


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findByEmail(username);
		if(user == null) {
			logger.error("User not found: " + username);
			throw new MyUsernameNotFoundException("Email not found");
		}
		
		logger.info("User found: " + username);
		return user;
	}
	
	@Transactional(readOnly = true)
	public UserDTO getLoggedUser() {
		
		Authentication loggedUser = SecurityContextHolder.getContext().getAuthentication();
		if(!(loggedUser instanceof AnonymousAuthenticationToken)) {
			String email = loggedUser.getName();
			User user = repository.findByEmail(email);
			return new UserDTO(user);
		}
		
		return null;
	}
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(PageRequest pageRequest) {
		Page<User> list = repository.findAll(pageRequest);
		// Usando 'expressão lambda' para transferir User para UserDTO
		return list.map(x -> new UserDTO(x));
	}
	
	//public UserDTO insert(UserInsertDTO dto) {
	@Transactional
	public UserDTO insert(UserInsertDTO dto) {		
		
		User entity = new User();
		
		if(validaInsertUser(dto)) {
			copyDtoToEntity(dto, entity);
			entity.setPassword(passwordEncoder.encode(dto.getPassword()));
			entity = repository.save(entity);			
		}
		UserDTO retorno = new UserDTO(entity);
		retorno.errorList = dto.errorList;

		return retorno;
	}

	//public UserDTO update(Long id, UserUpdateDTO dto) {
	@Transactional
	public UserDTO update(Long id, UserDTO dto) {
		try {
			User entity = repository.getOne(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new UserDTO(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		}

	}

	// Único sem Transactional, pois tem que capturar uma exceção e o transactional
	// não deixaria
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity Violation!");
		}

	}

	private void copyDtoToEntity(UserDTO dto, User entity) {

		entity.setName(dto.getName());
		//entity.setLastName(dto.getLastName());
		entity.setEmail(dto.getEmail());		

		entity.getRoles().clear();

		dto.getRoles().forEach(roleDto -> {
			
			entity.getRoles().add(roleRepository.getOne(roleDto.getId()));
		});
	}
	
	
	public boolean validaInsertUser(UserInsertDTO dtoRequest) {
		//List<FieldMessage> list = new ArrayList<>();
		
		// Coloque aqui seus testes de validação, acrescentando objetos FieldMessage à lista
		User user = repository.findByEmail(dtoRequest.getEmail());
		if(user != null) {			
			dtoRequest.errorList.add(new FieldMessage("email", "Email já existe;"));
			return false;
		}
		
		return true;
	}
	

}
