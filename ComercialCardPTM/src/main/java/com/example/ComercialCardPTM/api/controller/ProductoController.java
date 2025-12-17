package com.example.ComercialCardPTM.api.controller;

import com.example.ComercialCardPTM.domain.model.ProductoModel;
import com.example.ComercialCardPTM.domain.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/producto")
public class ProductoController {
    @Autowired
    ProductoService productoService;

    @GetMapping()
    public ArrayList<ProductoModel> obtenerProductos(){
        return productoService.obtenerProductos();
    }

    @PostMapping()
    public ProductoModel guardarProduacto(@RequestBody ProductoModel producto){
        return this.productoService.guardarProducto(producto);
    }
}
