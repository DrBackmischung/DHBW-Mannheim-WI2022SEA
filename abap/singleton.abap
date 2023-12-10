*&---------------------------------------------------------------------*
*& Report ZSINGLETON
*&---------------------------------------------------------------------*

REPORT ZSINGLETON.

DATA: gv_singleton_instance TYPE REF TO ZCL_SINGLETON.

CLASS ZCL_SINGLETON DEFINITION.
  PUBLIC SECTION.
    CLASS-METHODS get_instance
      RETURNING
        VALUE(ro_instance) TYPE REF TO ZCL_SINGLETON.
    METHODS some_method.
ENDCLASS.

CLASS ZCL_SINGLETON IMPLEMENTATION.
  METHOD get_instance.
    IF gv_singleton_instance IS INITIAL.
      CREATE OBJECT gv_singleton_instance.
    ENDIF.
    ro_instance = gv_singleton_instance.
  ENDMETHOD.

  METHOD some_method.
    WRITE: / 'Some method of the singleton'.
  ENDMETHOD.
ENDCLASS.

START-OF-SELECTION.
  DATA(lo_singleton) = ZCL_SINGLETON=>get_instance( ).
  lo_singleton->some_method( ).
