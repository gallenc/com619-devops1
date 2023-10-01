package net.map.controller;

import net.map.domain.MapPoint;
import net.map.repository.MapPointRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pingwin on 25.10.16.
 */
@RestController
public class MapPointController {
    MapPointRepository mapPointRepository;

    @Autowired
    public MapPointController(MapPointRepository mapPointRepository){
        this.mapPointRepository = mapPointRepository;
    }


    @RequestMapping("/get")
    public Iterable<MapPoint> list() {
        return mapPointRepository.findAll();
    }

    @RequestMapping("/get/{id}")
    public MapPoint getById(@PathVariable(value = "id") long id){
        Optional<MapPoint> mpo = mapPointRepository.findById(id);
        return (mpo.isEmpty()) ? null : mpo.get();
    }


}
