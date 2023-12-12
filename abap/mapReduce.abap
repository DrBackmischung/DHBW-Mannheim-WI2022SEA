REPORT ZMAPREDUCE_EXAMPLE.

TYPES: BEGIN OF ty_word_count,
         word TYPE string,
         count TYPE i,
       END OF ty_word_count.

DATA(lt_documents) TYPE TABLE OF string.
DATA(lt_mapped_results) TYPE TABLE OF ty_word_count.
DATA(lt_sorted_results) TYPE TABLE OF ty_word_count.
DATA(lt_word_count) TYPE TABLE OF ty_word_count.

lt_documents = VALUE #( ( 'Hello world' )
                       ( 'ABAP is awesome' )
                       ( 'Hello ABAP' )
                       ( 'MapReduce in ABAP' )
                       ( 'ABAP programming' ) ).

* Step 1: Map - Tokenize each document and emit (word, 1) pairs
LOOP AT lt_documents INTO DATA(lv_document).
  SPLIT lv_document AT space INTO TABLE DATA(lt_words).
  APPEND VALUE #( word = lt_word count = 1 ) TO lt_mapped_results FOR TABLE LINE IN lt_words.
ENDLOOP.

* Step 2: Shuffle and Sort - Sort by the key (word)
SORT lt_mapped_results BY word.

* Step 3: Reduce - Aggregate counts for each word
LOOP AT lt_mapped_results INTO DATA(ls_mapped_result).
  DATA(lv_word) = ls_mapped_result-word.
  DATA(lv_count) = ls_mapped_result-count.

  LOOP AT lt_word_count INTO DATA(ls_word_count)
       WHERE word = lv_word.
    ls_word_count-count = ls_word_count-count + lv_count.
    MODIFY lt_word_count FROM ls_word_count TRANSPORTING count
           WHERE word = lv_word.
    EXIT.
  ENDLOOP.

  IF sy-subrc <> 0.
    APPEND VALUE #( word = lv_word count = lv_count ) TO lt_word_count.
  ENDIF.
ENDLOOP.

* Display the final word count
LOOP AT lt_word_count INTO DATA(ls_word_count).
  WRITE: / 'Word:', ls_word_count-word, 'Count:', ls_word_count-count.
ENDLOOP.
