package com.matthewwerth.crudweek.controller;

import com.matthewwerth.crudweek.model.Address;
import com.matthewwerth.crudweek.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/person/{id}")
    public ResponseEntity <Address> getProductById(@PathVariable Long id){
        return ResponseEntity.ok().body(addressService.getAddressById(id));
    }

    @PostMapping("/person")
    public ResponseEntity <Address> createProduct(@RequestBody Address address){
        return ResponseEntity.ok().body(this.addressService.createAddress(address));
    }

    @PutMapping("/person/{id}")
    public ResponseEntity <Address> updateProduct(@PathVariable Long id, @RequestBody Address address){
        address.setId(id);
        return ResponseEntity.ok().body(this.addressService.updateAddress(address));
    }
    @DeleteMapping("/person/{id}")
    public HttpStatus deleteProduct(@PathVariable Long id){
        this.addressService.deleteAddress(id);
        return HttpStatus.OK;
    }
}