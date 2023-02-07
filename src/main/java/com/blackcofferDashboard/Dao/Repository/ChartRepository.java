package com.blackcofferDashboard.Dao.Repository;

import com.blackcofferDashboard.Dao.entity.ChartData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChartRepository extends JpaRepository<ChartData,Integer> {

}
