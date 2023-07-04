package com.template.service;

import com.template.entity.NhanVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

public interface NhanVienService {
    Page<NhanVien> getAllNhanVien(Pageable pageable);
    NhanVien addNhanVien(NhanVien nv);
    NhanVien updateNhanVien(UUID id, NhanVien nv);
    void deleteNhanVien(UUID id);

    NhanVien getOneNhanVien(UUID id);
}
