package com.aisd.euler;

import com.aisd.euler.components.ApplicationComponent;
import com.aisd.euler.components.DaggerApplicationComponent;

public class Main {
	public static void main(String[] args) {
		ApplicationComponent appComponent = DaggerApplicationComponent.create();
		Application app = appComponent.app();
		app.run();
	}

}
