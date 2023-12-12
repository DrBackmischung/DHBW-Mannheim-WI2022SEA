REPORT Z_SORTING_STRATEGY.

DATA: lt_array TYPE TABLE OF i,
      lv_item TYPE i.

DATA: lo_sort_context TYPE REF TO zcl_sort_context,
      lo_bubble_sort TYPE REF TO zcl_bubble_sort_strategy,
      lo_quick_sort TYPE REF TO zcl_quick_sort_strategy.

CLASS zcl_sort_context DEFINITION.
  PUBLIC SECTION.
    METHODS:
      set_strategy IMPORTING io_strategy TYPE REF TO zcl_sort_strategy,
      perform_sort IMPORTING it_array TYPE TABLE OF i.
ENDCLASS.

CLASS zcl_sort_context IMPLEMENTATION.
  METHOD set_strategy.
    io_strategy = io_strategy.
  ENDMETHOD.

  METHOD perform_sort.
    io_strategy->sort( EXPORTING et_array = it_array ).
  ENDMETHOD.
ENDCLASS.

CLASS zcl_sort_strategy DEFINITION.
  PUBLIC SECTION.
    METHODS:
      sort IMPORTING et_array TYPE TABLE OF i.
ENDCLASS.

CLASS zcl_bubble_sort_strategy DEFINITION INHERITING FROM zcl_sort_strategy.
  PUBLIC SECTION.
    METHODS:
      sort REDEFINITION IMPORTING et_array TYPE TABLE OF i.
ENDCLASS.

CLASS zcl_bubble_sort_strategy IMPLEMENTATION.
  METHOD sort.
    DATA(lv_swapped) TYPE abap_bool.

    DO.
      lv_swapped = abap_false.

      LOOP AT et_array INTO lv_item WITH CONTROL lv_item_index.

        IF lv_item_index = lines( et_array ) - 1.
          CONTINUE.
        ENDIF.

        IF et_array[ lv_item_index ] > et_array[ lv_item_index + 1 ].
          " Swap items
          SWAP et_array[ lv_item_index ] WITH et_array[ lv_item_index + 1 ].
          lv_swapped = abap_true.
        ENDIF.

      ENDLOOP.

      IF lv_swapped = abap_false.
        EXIT.
      ENDIF.

    ENDDO.

  ENDMETHOD.
ENDCLASS.

CLASS zcl_quick_sort_strategy DEFINITION INHERITING FROM zcl_sort_strategy.
  PUBLIC SECTION.
    METHODS:
      sort REDEFINITION IMPORTING et_array TYPE TABLE OF i.
ENDCLASS.

CLASS zcl_quick_sort_strategy IMPLEMENTATION.
  METHOD sort.
    " Implement Quick Sort here
  ENDMETHOD.
ENDCLASS.

START-OF-SELECTION.

" Test the Sorting Strategies
DATA(lt_array_to_sort) TYPE TABLE OF i VALUE #( 5 2 9 1 5 6 ).

CREATE OBJECT lo_sort_context.

" Use Bubble Sort
CREATE OBJECT lo_bubble_sort.
lo_sort_context->set_strategy( lo_bubble_sort ).
lo_sort_context->perform_sort( lt_array_to_sort ).

" Use Quick Sort
CREATE OBJECT lo_quick_sort.
lo_sort_context->set_strategy( lo_quick_sort ).
lo_sort_context->perform_sort( lt_array_to_sort ).
