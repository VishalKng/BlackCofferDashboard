package com.blackcofferDashboard.Service;

import com.blackcofferDashboard.Dao.Repository.ChartRepository;
import com.blackcofferDashboard.Dao.entity.ChartData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.*;

@Service
public class ChartServiceImpl implements ChartService{
    @Autowired
    private ChartRepository chartRepository;
    @Override
    public List<ChartData> getChart() {

        return this.chartRepository.findAll();
    }

    @Override
    public Optional<ChartData> getChartById(Integer id) {
        return this.chartRepository.findById(id);
    }

    @Override
    public Object getCompanyInformation() {
        List<ChartData> ls = chartRepository.findAll();
        HashMap<String, Object> companyInformationMap = new HashMap<>();
        for (ChartData chartData : ls) {
            companyInformationMap.put("pestle", chartData.getPestle());
            companyInformationMap.put("intensity", chartData.getIntensity());
            companyInformationMap.put("likelihood", chartData.getLikelihood());
            companyInformationMap.put("relevance", chartData.getRelevance());
            companyInformationMap.put("year", chartData.getStart_year());
            companyInformationMap.put("country", chartData.getCountry());
            companyInformationMap.put("topic", chartData.getTopic());
            companyInformationMap.put("region", chartData.getRegion());
            companyInformationMap.put("city", chartData.getCity());

        }
        return companyInformationMap;
    }

    @Override
    public HashMap<String, Object> getChartData() {
        List<ChartData> chartDataList = chartRepository.findAll(Sort.by("id"));

        HashMap<String, Object> chartDataMap = new HashMap<>();

        List<String> start_year = new ArrayList<>();
        List<String> intensity = new ArrayList<>();

        for (ChartData chartData : chartDataList) {
            start_year.add(chartData.getStart_year());
            intensity.add(String.valueOf(chartData.getIntensity()));
        }
        chartDataMap.put("start_year", start_year.toString());
        chartDataMap.put("intensity", intensity.toString());
        return chartDataMap;
    }

    @Override
    public HashMap<String, Object> getBarChart() {
        HashMap<String, Object> chartDataMap = new HashMap<>();

        List<ChartData> chartDataList = chartRepository.findAll();

        List<String> label = new ArrayList<>();
        List<String> value = new ArrayList<>();
        double  totalRelevance = 0;
        double totalLikelihood = 0;


        for (ChartData chartValue : chartDataList) {
            label.add(chartValue.getStart_year());
            value.add(String.valueOf(chartValue.getIntensity()));
            totalRelevance += chartValue.getRelevance();
            totalLikelihood += chartValue.getLikelihood();
        }
          System.out.println(label);
        System.out.println(value);

        chartDataMap.put("crLabels", label.toString());
        chartDataMap.put("crValue", value.toString());
        chartDataMap.put("totalRelevance", totalRelevance);
        chartDataMap.put("totalLikelihood", totalLikelihood);


        return chartDataMap;
    }
}
