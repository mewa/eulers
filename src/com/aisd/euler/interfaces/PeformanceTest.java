package com.aisd.euler.interfaces;

import javax.inject.Inject;

public abstract class PeformanceTest {
	protected abstract void init();

	@Inject
	IClock clock;
	protected long runtime;

	public final void start() {
		runtime = clock.time();
		run();
		runtime = clock.time() - runtime;
		onFinished();
	};

	protected abstract void onFinished();

	public abstract void run();
}
