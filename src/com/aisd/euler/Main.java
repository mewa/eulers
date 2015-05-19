package com.aisd.euler;

import com.aisd.euler.components.ApplicationComponent;
import com.aisd.euler.components.DaggerApplicationComponent;
import com.aisd.euler.components.DaggerGraphComponent;
import com.aisd.euler.interfaces.Logger;
import com.aisd.euler.models.GraphMatrix;
import com.aisd.euler.utils.GraphPerformanceTest;

public class Main {
	public static void main(String[] args) {
		ApplicationComponent appComponent = DaggerApplicationComponent.create();
		Application app = appComponent.app();
	}

}
