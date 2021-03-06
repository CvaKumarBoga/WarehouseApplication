package com.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Item_table")
public class Item {
	
	@Id
	@GeneratedValue
	@Column(name="sid")
	private Integer id;
	@Column(name="icode")
	private String itemCode;
	@Column(name="iwidth")
	private Double itemWidth;
	@Column(name="ilength")
	private Double itemLength;
	@Column(name="ihight")
	private Double itemHight;
	@Column(name="icost")
	private Double itemCost;
	@Column(name="currency")
	private String baseCurrency;
	
	@ManyToOne
	@JoinColumn(name="ItmUomPk")
	private UomType uom;
	@ManyToOne
	@JoinColumn(name="ItmOrdPk")
	private OrderMethod om;
	public Item() {
		super();
	}
	public Item(Integer id) {
		super();
		this.id = id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getItemCode() {
		return itemCode;
	}
	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	public Double getItemWidth() {
		return itemWidth;
	}
	public void setItemWidth(Double itemWidth) {
		this.itemWidth = itemWidth;
	}
	public Double getItemLength() {
		return itemLength;
	}
	public void setItemLength(Double itemLength) {
		this.itemLength = itemLength;
	}
	public Double getItemHight() {
		return itemHight;
	}
	public void setItemHight(Double itemHight) {
		this.itemHight = itemHight;
	}
	public Double getItemCost() {
		return itemCost;
	}
	public void setItemCost(Double itemCost) {
		this.itemCost = itemCost;
	}
	public String getBaseCurrency() {
		return baseCurrency;
	}
	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}
	public UomType getUom() {
		return uom;
	}
	public void setUom(UomType uom) {
		this.uom = uom;
	}
	public OrderMethod getOm() {
		return om;
	}
	public void setOm(OrderMethod om) {
		this.om = om;
	}
	@Override
	public String toString() {
		return "Item [id=" + id + ", itemCode=" + itemCode + ", itemWidth=" + itemWidth + ", itemLength=" + itemLength
				+ ", itemHight=" + itemHight + ", itemCost=" + itemCost + ", baseCurrency=" + baseCurrency + ", uom="
				+ uom + ", om=" + om + "]";
	}
	
}