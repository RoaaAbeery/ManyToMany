package com.example.teacheraddress.Controller;

import com.example.teacheraddress.DTO.AddressDTO;
import com.example.teacheraddress.Model.Address;
import com.example.teacheraddress.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/v1/Address")
@RestController
public class AddressController {
    private final AddressService addressService;
    @GetMapping("/getAddress")
    public ResponseEntity getAddress(){
        return ResponseEntity.status(HttpStatus.OK).body(addressService.getAddress());
    }
    @PostMapping("/addAddress")
    public ResponseEntity addAddress(@RequestBody@Valid AddressDTO addressDTO){
        addressService.addAddress(addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Address add");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateAddress(@PathVariable Integer id,@RequestBody@Valid AddressDTO addressDTO){
        addressService.updateAddress(id, addressDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Address updated");
    }
    @DeleteMapping("/deleteAddress/{id}")
    public ResponseEntity deleteAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(HttpStatus.OK).body("Address deleted");
    }
}
