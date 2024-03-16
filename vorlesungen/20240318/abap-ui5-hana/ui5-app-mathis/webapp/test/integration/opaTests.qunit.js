sap.ui.require(
    [
        'sap/fe/test/JourneyRunner',
        'ui5appmathis/test/integration/FirstJourney',
		'ui5appmathis/test/integration/pages/ZC_90_WI22SEBList',
		'ui5appmathis/test/integration/pages/ZC_90_WI22SEBObjectPage'
    ],
    function(JourneyRunner, opaJourney, ZC_90_WI22SEBList, ZC_90_WI22SEBObjectPage) {
        'use strict';
        var JourneyRunner = new JourneyRunner({
            // start index.html in web folder
            launchUrl: sap.ui.require.toUrl('ui5appmathis') + '/index.html'
        });

       
        JourneyRunner.run(
            {
                pages: { 
					onTheZC_90_WI22SEBList: ZC_90_WI22SEBList,
					onTheZC_90_WI22SEBObjectPage: ZC_90_WI22SEBObjectPage
                }
            },
            opaJourney.run
        );
    }
);