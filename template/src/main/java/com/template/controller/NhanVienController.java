package com.template.controller;

import com.template.common.ResponseObject;
import com.template.entity.NhanVien;
import com.template.service.NhanVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/nhan-vien")
@CrossOrigin(origins = {"*"}, maxAge = 4800, allowCredentials = "false")
public class NhanVienController {

    @Autowired
    private NhanVienService nhanVienService;

    @GetMapping("/hien-thi")
    public ResponseEntity<Page<NhanVien>> getAllNhanVien(@RequestParam(defaultValue = "1") Integer page) {
        if (page < 1) page = 1;
        Pageable pageable = PageRequest.of(page - 1, 5);
        return ResponseEntity.ok(nhanVienService.getAllNhanVien(pageable));
    }

    @PostMapping("/add")
    public ResponseObject add(@RequestBody NhanVien nv){
        return new ResponseObject(nhanVienService.addNhanVien(nv));
    }

    @GetMapping("/detail/{id}")
    public ResponseObject detail(@PathVariable("id") String id){
        return new ResponseObject(nhanVienService.getOneNhanVien(UUID.fromString(id)));
    }

    @PutMapping("/update/{id}")
    public ResponseObject update(@PathVariable("id") String id, @RequestBody NhanVien nv){
        return new ResponseObject(nhanVienService.updateNhanVien(UUID.fromString(id), nv));
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        nhanVienService.deleteNhanVien(UUID.fromString(id));
    }

}
