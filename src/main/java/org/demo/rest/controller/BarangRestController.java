/*
 * Created on 25 Jul 2021 ( Time 02:07:51 )
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
import org.demo.bean.Barang;
import org.demo.business.service.BarangService;
import org.demo.web.listitem.BarangListItem;

/**
 * Spring MVC controller for 'Barang' management.
 */
@Controller
public class BarangRestController {

	@Resource
	private BarangService barangService;
	
	@RequestMapping( value="/items/barang",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<BarangListItem> findAllAsListItems() {
		List<Barang> list = barangService.findAll();
		List<BarangListItem> items = new LinkedList<BarangListItem>();
		for ( Barang barang : list ) {
			items.add(new BarangListItem( barang ) );
		}
		return items;
	}
	
	@RequestMapping( value="/barang",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Barang> findAll() {
		return barangService.findAll();
	}

	@RequestMapping( value="/barang/{kodeBarang}",
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Barang findOne(@PathVariable("kodeBarang") String kodeBarang) {
		return barangService.findById(kodeBarang);
	}
	
	@RequestMapping( value="/barang",
			method = RequestMethod.POST,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Barang create(@RequestBody Barang barang) {
		return barangService.create(barang);
	}

	@RequestMapping( value="/barang/{kodeBarang}",
			method = RequestMethod.PUT,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Barang update(@PathVariable("kodeBarang") String kodeBarang, @RequestBody Barang barang) {
		return barangService.update(barang);
	}

	@RequestMapping( value="/barang/{kodeBarang}",
			method = RequestMethod.DELETE,
			produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void delete(@PathVariable("kodeBarang") String kodeBarang) {
		barangService.delete(kodeBarang);
	}
	
}
