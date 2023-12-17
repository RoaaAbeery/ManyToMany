package com.example.teacheraddress.Service;

import com.example.teacheraddress.ApiException.APiException;
import com.example.teacheraddress.DTO.AddressDTO;
import com.example.teacheraddress.Model.Address;
import com.example.teacheraddress.Model.Teacher;
import com.example.teacheraddress.Repository.AddressRepository;
import com.example.teacheraddress.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;
    public List<Address> getAddress(){
        return addressRepository.findAll();
    }
    public void addAddress(AddressDTO addressDTO){
        Teacher teacher=teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if(teacher==null){
            throw new APiException("teacher not found");
        }
        Address address=new Address(null, addressDTO.getArea(), addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);
      addressRepository.save(address);
    }
    public void updateAddress(Integer id,AddressDTO addressDTO){
        Address oldAddress=addressRepository.findAddressById(id);
        if(oldAddress==null){
            throw new APiException("address not found");
        }
        oldAddress.setArea(addressDTO.getArea());
        oldAddress.setStreet(addressDTO.getStreet());
        oldAddress.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(oldAddress);
    }
    public void deleteAddress(Integer id){
        Address address=addressRepository.findAddressById(id);
        if(address==null){
            throw new APiException("address not found");
        }
        Teacher teacher=teacherRepository.findTeacherById(id);
        teacher.setAddress(null);
        teacherRepository.save(teacher);
        addressRepository.delete(address);
    }
}
