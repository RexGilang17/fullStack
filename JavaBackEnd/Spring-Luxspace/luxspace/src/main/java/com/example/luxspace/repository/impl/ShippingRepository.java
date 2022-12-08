package com.example.luxspace.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.luxspace.model.Shipping;
import com.example.luxspace.repository.IShippingRepository;

@Repository
public class ShippingRepository implements IShippingRepository{
	
	@Autowired
	JdbcTemplate jdbcTemplate;

	@Override
	public Shipping insertShipping(Shipping shipping) {
		// TODO Auto-generated method stub
		String query = "INSERT INTO tb_student(deskripsi_diri, email, hard_skill, interest, jenis_kelamin, nama, soft_skill, umur) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
		jdbcTemplate.update(query, new Object[] {shipping.getDeskripsi_diri(), shipping.getEmail(), shipping.getHard_skill(),
				shipping.getInterest(), shipping.getJenis_kelamin(), shipping.getNama(), shipping.getSoft_skill(), shipping.getUmur(),});
		return shipping;
	}

	@Override
	public List<Shipping> getAllShipping() {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_student";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Shipping.class));
	}

	@Override
	public Shipping updateShipping(int id, Shipping shipping) {
		// TODO Auto-generated method stub
		String query = "UPDATE tb_student SET deskripsi_diri = ?, email = ?, hard_skill = ?, interest = ?, "
				+ "jenis_kelamin = ?, nama = ?, soft_skill = ?, umur = ? WHERE id = ?";
		
		jdbcTemplate.update(query, new Object[] {shipping.getDeskripsi_diri(), shipping.getEmail(), shipping.getHard_skill(),
				shipping.getInterest(), shipping.getJenis_kelamin(), shipping.getNama(), shipping.getSoft_skill(), shipping.getUmur(), id});
		
		return shipping;
	}

	@Override
	public Shipping deleteShipping(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_student WHERE id = ?";
		var result = jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Shipping.class), id);
		
		query = "DELETE FROM tb_student WHERE id = ?";
		jdbcTemplate.update(query, id);
		
		return result;
	}

	@Override
	public Shipping getStudent(int id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM tb_student WHERE id = ?";
		return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(Shipping.class), id);
	}

}
