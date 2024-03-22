package sap.escooters.launcher;

import sap.escooters.application_layer.*;
import sap.escooters.business_logic_layer.*;
import sap.escooters.infrastructure_layer.data_source.FileSystemAdapter;
import sap.escooters.infrastructure_layer.ui.WebBasedUIAdapter;

public class EScooterManagementSystem {

    public static void main(String[] args) {
    	FileSystemAdapter dataSourceAdapter = new FileSystemAdapter("dbase");
    	DomainModelImpl domainLayer = new DomainModelImpl();
    	ApplicationLayerImpl appLayer = new ApplicationLayerImpl();
    	WebBasedUIAdapter ui = new WebBasedUIAdapter(8081);
    	dataSourceAdapter.init();
    	domainLayer.init(dataSourceAdapter);
    	appLayer.init(domainLayer, ui);
    	ui.init(appLayer);
    }
}
