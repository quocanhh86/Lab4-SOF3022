package com.example.th01267_lab4.controller;

import com.example.th01267_lab4.model.Staff;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class StaffController {
    @RequestMapping("/staff/create/form")
    public String createForm(Model model, @ModelAttribute("staff") Staff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "/demo/staff-create";
    }
    @RequestMapping(value = "/staff/create/save", method = RequestMethod.POST)
    public String createSave(Model model, @ModelAttribute("staff") Staff staff,
                             @RequestPart("photo_file") MultipartFile photoFile) {
// Gán tên file upload cho thuộc tính photo của bean nếu có upload file
        if(!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getName());
        }
        model.addAttribute("message", "Xin chào " + staff.getFullname());
        return "/demo/staff-create";
    }
}
