package com.augustosouza.financehub.dashboard.controller;

import com.augustosouza.financehub.dashboard.dto.DashboardResponse;
import com.augustosouza.financehub.dashboard.service.DashboardService;
import com.augustosouza.financehub.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService service;

    @GetMapping("/dashboard")
    public DashboardResponse dashboard(
            @AuthenticationPrincipal User user){

        return service.getDashboard(user);

    }

}