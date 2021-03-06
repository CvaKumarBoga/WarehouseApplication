package com.app.util;

import java.io.File;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ShipmentTypeUtil {
	public void generatePie(String path,List<Object[]> list) {
	
		//1.create data set
		
		DefaultPieDataset dataset = new DefaultPieDataset();
		for(Object[] ob:list) {
		//provide key and value
			dataset.setValue(ob[0].toString(), new Double(ob[1].toString()));
		}
		
		//2.create JFreeChart using chartFactory
		
		JFreeChart chart=ChartFactory.createPieChart3D("shipmentType Modes", dataset);
		
		//3.save as image using charts utils
		
		try {
			ChartUtils.saveChartAsJPEG(new File (path+"/resources/images/ShipmentPie.jpg"), chart, 300, 300);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public void generateBar(String path,List<Object[]> list) {
		
		//1.create data set
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		for(Object[] ob:list) {
		//provide value and key
			dataset.setValue(new Double(ob[1].toString()),
										ob[0].toString(),
										"ShipmentModes");
		}
		
		//2.create JFreeChart using chartFactory
		
		JFreeChart chart=ChartFactory.createBarChart("shipmentType Modes","Modes","count",dataset);
		
		//3.save as image using charts utils
		
		try {
			ChartUtils.saveChartAsJPEG(new File (path+"/resources/images/ShipmentBar.jpg"), chart, 300, 300);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
