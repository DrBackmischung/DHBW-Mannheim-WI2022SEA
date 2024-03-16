sap.ui.define(['sap/fe/test/ObjectPage'], function(ObjectPage) {
    'use strict';

    var CustomPageDefinitions = {
        actions: {},
        assertions: {}
    };

    return new ObjectPage(
        {
            appId: 'ui5appmathis',
            componentId: 'ZC_90_WI22SEBObjectPage',
            contextPath: '/ZC_90_WI22SEB'
        },
        CustomPageDefinitions
    );
});