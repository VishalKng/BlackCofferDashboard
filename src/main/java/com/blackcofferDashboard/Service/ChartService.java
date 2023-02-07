package com.blackcofferDashboard.Service;

import com.blackcofferDashboard.Dao.entity.ChartData;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface ChartService{
    public List<ChartData> getChart();

   public Optional<ChartData> getChartById(Integer id);

   public Object getCompanyInformation();

    HashMap<String, Object> getChartData();

    HashMap<String, Object> getBarChart();
}
