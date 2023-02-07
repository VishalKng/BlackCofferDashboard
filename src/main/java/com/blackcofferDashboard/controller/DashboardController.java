package com.blackcofferDashboard.controller;


import com.blackcofferDashboard.Service.ChartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.blackcofferDashboard.Dao.entity.ChartData;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Controller
public class DashboardController {
    @Autowired
    private ChartService chartService;

    @GetMapping("/")
    public String getPieChart(Model model) {
        Map<String, Integer> graphData = new TreeMap<>();
        graphData.put("2016", 147);
        graphData.put("2017", 1256);
        graphData.put("2018", 3856);
        graphData.put("2019", 19807);
        model.addAttribute("chartData", graphData);
        return "google-charts";
    }

    @GetMapping("/getChart")
    public List<ChartData> getChart() {
        return this.chartService.getChart();
    }

    @GetMapping("/getChartById/{id}")
    public ChartData getChartById(@PathVariable Integer id) {
        return this.chartService.getChartById(id).orElse(null);
    }


    @GetMapping("/dashboard")
    public String getDashDetails(Model model) {
        model.addAttribute("data", chartService.getCompanyInformation());
        model.addAttribute("companyData", chartService.getChart());
        model.addAttribute("chartData", chartService.getChartData());
        model.addAttribute("barChartData", chartService.getBarChart());
        return "/dashboard";
    }
}