package com.Practica3.service.impl;

import com.Practica3.Service.ArbolService;
import com.Practica3.dao.ArbolDao;
import com.Practica3.domain.Arbol;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ArbolServiceImpl implements ArbolService{
    
    @Autowired
    ArbolDao arbolDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Arbol> getArboles(boolean estadoVida) {
        List<Arbol> arboles = arbolDao.findAll();
        
        if (estadoVida) {
            arboles.removeIf(x -> !x.isEstadoVida());
        }
        
        return arboles;    }
}
