package com.ws.parsers;

import java.util.HashMap;

public interface Parser {
    public Boolean esSelect();
    public Boolean esJoin(); 
    public HashMap<String, String> obtenerCampos();

}