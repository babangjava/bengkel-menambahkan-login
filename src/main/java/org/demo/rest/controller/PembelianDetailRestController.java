/*
 * Created on 25 Jul 2021 ( Time 02:07:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.rest.controller;

import java.util.LinkedList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.demo.bean.PembelianDetail;
import org.demo.business.service.PembelianDetailService;
import org.demo.web.listitem.PembelianDetailListItem;

/**
 * Spring MVC controller for 'PembelianDetail' management.
 */
@Controller
public class PembelianDetailRestController {

	@Resource
	private PembelianDetailService pembelianDetailService;
	
	@RequestMapping( value="/items/pembelianDetail",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<PembelianDetailListItem> findAllAsListItems() {
		List<PembelianDetail> list = pembelianDetailService.findAll();
		List<PembelianDetailListItem> items = new LinkedList<PembelianDetailListItem>();
		for ( PembelianDetail pembelianDetail : list ) {
			items.add(new PembelianDetailListItem( pembelianDetail ) );
		}
		return items;
	}
	
	@RequestMapping( value="/pembelianDetail",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<PembelianDetail> findAll() {
		return pembelianDetailService.findAll();
	}

	@RequestMapping( value="/pembelianDetail/{idPembelianDetail}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public PembelianDetail findOne(@PathVariable("idPembelianDetail") Integer idPembelianDetail) {
		return pembelianDetailService.findById(idPembelianDetail);
	}
	
	@RequestMapping( value="/pembelianDetail",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public PembelianDetail create(@RequestBody PembelianDetail pembelianDetail) {
		return pembelianDetailService.create(pembelianDetail);
	}

	@RequestMapping( value="/pembelianDetail/{idPembelianDetail}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public PembelianDetail update(@PathVariable("idPembelianDetail") Integer idPembelianDetail, @RequestBody PembelianDetail pembelianDetail) {
		return pembelianDetailService.update(pembelianDetail);
	}

	@RequestMapping( value="/pembelianDetail/{idPembelianDetail}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("idPembelianDetail") Integer idPembelianDetail) {
		pembelianDetailService.delete(idPembelianDetail);
	}
	
}
