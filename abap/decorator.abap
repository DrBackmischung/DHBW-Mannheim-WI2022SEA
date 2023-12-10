REPORT ZDECORATOR.

* Component interface
INTERFACE zif_coffee.
  METHODS: cost RETURNING VALUE(rv_cost) TYPE i,
          description RETURNING VALUE(rv_description) TYPE string.
ENDINTERFACE.

* Concrete Component
CLASS zcl_simple_coffee DEFINITION.
  PUBLIC SECTION.
    INTERFACES: zif_coffee.
ENDCLASS.

CLASS zcl_simple_coffee IMPLEMENTATION.
  METHOD zif_coffee~cost.
    rv_cost = 5.
  ENDMETHOD.

  METHOD zif_coffee~description.
    rv_description = 'Simple Coffee'.
  ENDMETHOD.
ENDCLASS.

* Decorator interface
INTERFACE zif_coffee_decorator.
  METHODS: cost RETURNING VALUE(rv_cost) TYPE i,
          description RETURNING VALUE(rv_description) TYPE string.
ENDINTERFACE.

* Concrete Decorator
CLASS zcl_milk_decorator DEFINITION.
  PUBLIC SECTION.
    INTERFACES: zif_coffee_decorator.
    METHODS: constructor IMPORTING io_coffee TYPE REF TO zif_coffee.
ENDCLASS.

CLASS zcl_milk_decorator IMPLEMENTATION.
  PRIVATE SECTION.
    DATA: mo_coffee TYPE REF TO zif_coffee.

  METHODS constructor.
    mo_coffee = io_coffee.
  ENDMETHOD.

  METHOD zif_coffee_decorator~cost.
    rv_cost = mo_coffee->cost( ) + 2.
  ENDMETHOD.

  METHOD zif_coffee_decorator~description.
    rv_description = mo_coffee->description( ) && ', Milk'.
  ENDMETHOD.
ENDCLASS.

* Example application
DATA(lo_simple_coffee) TYPE REF TO zif_coffee.
DATA(lo_milk_coffee) TYPE REF TO zif_coffee_decorator.

START-OF-SELECTION.
  CREATE OBJECT lo_simple_coffee TYPE zcl_simple_coffee.

  CALL METHOD lo_simple_coffee->description
    RECEIVING
      rv_description = DATA(lv_description).

  CALL METHOD lo_simple_coffee->cost
    RECEIVING
      rv_cost = DATA(lv_cost).

  WRITE: / lv_description, 'Cost:', lv_cost.

  CREATE OBJECT lo_milk_coffee TYPE zcl_milk_decorator
    EXPORTING
      io_coffee = lo_simple_coffee.

  CALL METHOD lo_milk_coffee->description
    RECEIVING
      rv_description = DATA(lv_milk_description).

  CALL METHOD lo_milk_coffee->cost
    RECEIVING
      rv_cost = DATA(lv_milk_cost).

  WRITE: / lv_milk_description, 'Cost:', lv_milk_cost.
