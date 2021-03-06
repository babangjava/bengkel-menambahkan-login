/*
 * Created on 25 Jul 2021 ( Time 02:07:43 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.business.service.mapping;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Component;
import org.demo.bean.PenjualanDetail;
import org.demo.bean.jpa.PenjualanDetailEntity;
import org.demo.bean.jpa.PenjualanHeaderEntity;
import org.demo.test.MockValues;

/**
 * Test : Mapping between entity beans and display beans.
 */
public class PenjualanDetailServiceMapperTest {

	private PenjualanDetailServiceMapper penjualanDetailServiceMapper;

	private static ModelMapper modelMapper = new ModelMapper();

	private MockValues mockValues = new MockValues();
	
	
	@BeforeClass
	public static void setUp() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
	}
	
	@Before
	public void before() {
		penjualanDetailServiceMapper = new PenjualanDetailServiceMapper();
		penjualanDetailServiceMapper.setModelMapper(modelMapper);
	}
	
	/**
	 * Mapping from 'PenjualanDetailEntity' to 'PenjualanDetail'
	 * @param penjualanDetailEntity
	 */
	@Test
	public void testMapPenjualanDetailEntityToPenjualanDetail() {
		// Given
		PenjualanDetailEntity penjualanDetailEntity = new PenjualanDetailEntity();
		penjualanDetailEntity.setHarga(mockValues.nextDouble());
		penjualanDetailEntity.setJumlah(mockValues.nextInteger());
		penjualanDetailEntity.setNamaBarang(mockValues.nextString(100));
		penjualanDetailEntity.setTotal(mockValues.nextDouble());
		penjualanDetailEntity.setPenjualanHeader2(new PenjualanHeaderEntity());
		penjualanDetailEntity.getPenjualanHeader2().setIdPenjualanHeader(mockValues.nextInteger());
		
		// When
		PenjualanDetail penjualanDetail = penjualanDetailServiceMapper.mapPenjualanDetailEntityToPenjualanDetail(penjualanDetailEntity);
		
		// Then
		assertEquals(penjualanDetailEntity.getHarga(), penjualanDetail.getHarga());
		assertEquals(penjualanDetailEntity.getJumlah(), penjualanDetail.getJumlah());
		assertEquals(penjualanDetailEntity.getNamaBarang(), penjualanDetail.getNamaBarang());
		assertEquals(penjualanDetailEntity.getTotal(), penjualanDetail.getTotal());
		assertEquals(penjualanDetailEntity.getPenjualanHeader2().getIdPenjualanHeader(), penjualanDetail.getPenjualanHeader());
	}
	
	/**
	 * Test : Mapping from 'PenjualanDetail' to 'PenjualanDetailEntity'
	 */
	@Test
	public void testMapPenjualanDetailToPenjualanDetailEntity() {
		// Given
		PenjualanDetail penjualanDetail = new PenjualanDetail();
		penjualanDetail.setHarga(mockValues.nextDouble());
		penjualanDetail.setJumlah(mockValues.nextInteger());
		penjualanDetail.setNamaBarang(mockValues.nextString(100));
		penjualanDetail.setTotal(mockValues.nextDouble());
		penjualanDetail.setPenjualanHeader(mockValues.nextInteger());

		PenjualanDetailEntity penjualanDetailEntity = new PenjualanDetailEntity();
		
		// When
		penjualanDetailServiceMapper.mapPenjualanDetailToPenjualanDetailEntity(penjualanDetail, penjualanDetailEntity);
		
		// Then
		assertEquals(penjualanDetail.getHarga(), penjualanDetailEntity.getHarga());
		assertEquals(penjualanDetail.getJumlah(), penjualanDetailEntity.getJumlah());
		assertEquals(penjualanDetail.getNamaBarang(), penjualanDetailEntity.getNamaBarang());
		assertEquals(penjualanDetail.getTotal(), penjualanDetailEntity.getTotal());
		assertEquals(penjualanDetail.getPenjualanHeader(), penjualanDetailEntity.getPenjualanHeader2().getIdPenjualanHeader());
	}

}