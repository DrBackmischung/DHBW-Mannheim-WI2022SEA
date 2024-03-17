@EndUserText.label : 'Getränke'
@AbapCatalog.enhancement.category : #NOT_EXTENSIBLE
@AbapCatalog.tableCategory : #TRANSPARENT
@AbapCatalog.deliveryClass : #A
@AbapCatalog.dataMaintenance : #RESTRICTED
define table z90_wi22seb {

  key client            : abap.clnt not null;
  key uuid              : abap.raw(16) not null;
  name                  : abap.string(0);
  description           : abap.string(0);
  @Semantics.amount.currencyCode : 'z90_wi22seb.currency'
  price                 : abap.curr(16,2);
  currency              : abap.cuky;
  local_last_changed_at : abp_locinst_lastchange_tstmpl;
  last_changed_at       : abp_lastchange_tstmpl;

}
