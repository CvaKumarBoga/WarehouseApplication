package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;

@RestController
@RequestMapping("/rest/shipment")
public class ShipmentTypeRestController {
	
	@Autowired
	private IShipmentTypeService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> resp=null;
		List<ShipmentType> ob=service.getAllShipmentTypes();
		if(ob!=null && !ob.isEmpty()) {
			resp=new ResponseEntity<List<ShipmentType>>(ob,HttpStatus.OK);
		}
		else {
			resp=new ResponseEntity<String>("Data is not found",HttpStatus.OK);
		}
		return resp;
	}
	//To fetch one row
	@GetMapping("/one/{id}")
	public ResponseEntity<?> getOne(@PathVariable Integer id){
		ResponseEntity<?> resp=null;
		ShipmentType st=service.getOneShipmentType(id);
		if(st!=null) {
			resp=new ResponseEntity<ShipmentType>(st,HttpStatus.OK);
		}
		else {
			resp=new ResponseEntity<String>("Your id not exist",HttpStatus.BAD_REQUEST);
		}
		
		return resp;
	}
//delete one row
	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> delete(@PathVariable Integer id){
		ResponseEntity<String> resp=null;
		try {
			service.deleteShipmentType(id);
			resp=new ResponseEntity<String>("Record '"+id+"'is deleted",HttpStatus.OK);	
		}
		catch(Exception e) {
			resp=new ResponseEntity<String>("Record is not found",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
	}
	//insert/save operations
	@PostMapping("/insert")
	public ResponseEntity<String> saveData(@RequestBody ShipmentType shipmentType){
		Integer id=service.saveShipmentType(shipmentType);
		ResponseEntity<String> resp=new ResponseEntity<String>("save '"+id+"' is succesfully",HttpStatus.OK);
		return resp;
	}
	//Update data
	@PutMapping("/modify")
	public ResponseEntity<String> UpdateData(@RequestBody ShipmentType shipmentType){
		ResponseEntity<String> resp=null;
		try {
			service.updateShipmentType(shipmentType);
			resp=new ResponseEntity<String>("Updated succesfully",HttpStatus.OK);
		}
		catch(Exception e) {
			resp=new ResponseEntity<String>("Data is not found",HttpStatus.BAD_REQUEST);
			e.printStackTrace();
		}
		return resp;
		
	}
}

