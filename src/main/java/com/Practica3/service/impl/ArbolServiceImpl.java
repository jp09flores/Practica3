package com.Practica3.service.impl;

import com.Practica3.Service.ArbolService;
import com.Practica3.dao.ArbolDao;
import com.Practica3.domain.Arbol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class ArbolServiceImpl implements ArbolService{
    
    @Autowired
    ArbolDao arbolDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Arbol> getArboles(String especie) {
        List<Arbol> arboles = arbolDao.findAll();

        return arboles;    
    }    
}
