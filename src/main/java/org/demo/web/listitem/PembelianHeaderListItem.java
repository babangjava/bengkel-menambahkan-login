/*
 * Created on 25 Jul 2021 ( Time 02:07:52 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package org.demo.web.listitem;

import org.demo.bean.PembelianHeader;
import org.demo.web.common.ListItem;

public class PembelianHeaderListItem implements ListItem {

	private final String value ;
	private final String label ;
	
	public PembelianHeaderListItem(PembelianHeader pembelianHeader) {
		super();

		this.value = ""
			 + pembelianHeader.getIdPembelian()
		;

		//TODO : Define here the attributes to be displayed as the label
		this.label = pembelianHeader.toString();
	}

	@Override
	public String getValue() {
		return value;
	}

	@Override
	public String getLabel() {
		return label;
	}

}
