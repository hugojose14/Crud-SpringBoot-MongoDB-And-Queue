package com.bolsaideas.springboot.web.app.domain.model;

import java.util.HashMap;
import lombok.Getter;

@Getter
public enum Status {
  
  CREADO(Status.CREADO_CODE, "Creado"), 
  ANULADO(Status.ANULADO_CODE,"Anulado"), 
  PENDIENTE(Status.PENDIENTE_CODE, "Pendiente"), 
  ACEPTADO(Status.ACEPTADO_CODE, "Aceptado"),
  ND(Status.ND_CODE,"No Definido");

  private final String id;
  private final String name;

  public static final String CREADO_CODE = "1";
  public static final String PENDIENTE_CODE = "2";
  public static final String ACEPTADO_CODE = "3";
  public static final String ANULADO_CODE = "4";
  public static final String ND_CODE = "0";

  private static final HashMap<String, Status> ENUM_MAP_BY_CODE = new HashMap<>();
  
  static {
    ENUM_MAP_BY_CODE.put(CREADO_CODE, CREADO);
    ENUM_MAP_BY_CODE.put(ANULADO_CODE, ANULADO);
    ENUM_MAP_BY_CODE.put(PENDIENTE_CODE, PENDIENTE);
    ENUM_MAP_BY_CODE.put(ACEPTADO_CODE, ACEPTADO);
    ENUM_MAP_BY_CODE.put(ND_CODE, ND);
  }
  
  Status(String id,String name){
    this.id= id;
    this.name= name;
  }
  
  public static Status findByPrimaryKey(String id) {
    if (id != null) {
      return ENUM_MAP_BY_CODE.get(id);
    } else {
      return ND;
    }
  }
  
  public String getId() {
    return id;
  }
  
}

