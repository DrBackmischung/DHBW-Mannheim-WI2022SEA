CLASS CaffeineBeverage DEFINITION.
  PUBLIC SECTION.
    METHODS prepare_recipe.
    ABSTRACT METHODS brew.
    ABSTRACT METHODS add_condiments.
    METHODS boil_water.
    METHODS pour_in_cup.
ENDCLASS.

CLASS CaffeineBeverage IMPLEMENTATION.
  METHOD prepare_recipe.
    boil_water( ).
    brew( ).
    pour_in_cup( ).
    add_condiments( ).
  ENDMETHOD.

  METHOD boil_water.
    WRITE: 'Boiling water', /.
  ENDMETHOD.

  METHOD pour_in_cup.
    WRITE: 'Pouring into cup', /.
  ENDMETHOD.
ENDCLASS.

CLASS Tea DEFINITION INHERITING FROM CaffeineBeverage.
  PUBLIC SECTION.
    METHODS brew REDEFINITION.
    METHODS add_condiments REDEFINITION.
ENDCLASS.

CLASS Tea IMPLEMENTATION.
  METHOD brew.
    WRITE: 'Steeping the tea', /.
  ENDMETHOD.

  METHOD add_condiments.
    WRITE: 'Adding lemon', /.
  ENDMETHOD.
ENDCLASS.

CLASS Coffee DEFINITION INHERITING FROM CaffeineBeverage.
  PUBLIC SECTION.
    METHODS brew REDEFINITION.
    METHODS add_condiments REDEFINITION.
ENDCLASS.

CLASS Coffee IMPLEMENTATION.
  METHOD brew.
    WRITE: 'Dripping coffee through filter', /.
  ENDMETHOD.

  METHOD add_condiments.
    WRITE: 'Adding sugar and milk', /.
  ENDMETHOD.
ENDCLASS.

START-OF-SELECTION.
  DATA(tea) TYPE REF TO Tea.
  DATA(coffee) TYPE REF TO Coffee.

  CREATE OBJECT tea.
  CREATE OBJECT coffee.

  WRITE: / 'Making tea:', /.
  tea->prepare_recipe( ).

  WRITE: / 'Making coffee:', /.
  coffee->prepare_recipe( ).
