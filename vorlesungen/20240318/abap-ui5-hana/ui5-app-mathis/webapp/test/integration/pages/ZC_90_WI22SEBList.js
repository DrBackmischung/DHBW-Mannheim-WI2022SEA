sap.ui.define(['sap/fe/test/ListReport'], function(ListReport) {
    'use strict';

    var CustomPageDefinitions = {
        actions: {},
        assertions: {}
    };

    return new ListReport(
        {
            appId: 'ui5appmathis',
            componentId: 'ZC_90_WI22SEBList',
            contextPath: '/ZC_90_WI22SEB'
        },
        CustomPageDefinitions
    );
});