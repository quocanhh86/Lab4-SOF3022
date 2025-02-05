package com.example.th01267_lab4.controller;

import com.example.th01267_lab4.model.Staff;
import com.example.th01267_lab4.model.Staff_Bai2;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class StaffController_Bai2 {
    @RequestMapping("/staff/create/form-bai2")
    public String createForm(Model model, @ModelAttribute("staff") Staff staff) {
        model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
        return "/demo/staff-validate";
    }
    @RequestMapping(value = "/staff/create/save-bai2", method = RequestMethod.POST)
    public String createSave(Model model,
                             @RequestPart("photo_file") MultipartFile photoFile,
                             @Valid @ModelAttribute("staff") Staff_Bai2 staff, Errors errors) {
        if (!photoFile.isEmpty()) {
            staff.setPhoto(photoFile.getName());
        }
        if (errors.hasErrors()) {
            model.addAttribute("message", "Vui lòng sửa các lỗi sau!");
        } else {
            model.addAttribute("message", "Dữ liệu đã nhập đúng!");
        }
        return "/demo/staff-validate";
    }
}
