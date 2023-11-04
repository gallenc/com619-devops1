package org.solent.spring.map.repository;

import org.solent.spring.map.model.MapPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MapPointRepository extends JpaRepository<MapPoint,Long>{

}
