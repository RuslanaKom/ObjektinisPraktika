package praktika.tasks.second;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.Scanner;

public class Chronometer {

    private LocalTime startTime;

    private LocalTime stopTime;

    private LocalTime intermediateTime;

    private LocalTime pauseStart;

    private LocalTime pauseEnd;

    private Duration pause = Duration.ZERO;

    private Duration pausesBetweenIntermediates = Duration.ZERO;

    private static int pauseCounter = 0;

    private boolean chronometerStarted = false;

    SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");

    public void start() {
        startTime = LocalTime.now();
        pause = Duration.ZERO;
        intermediateTime = startTime;
        pauseStart = LocalTime.now();
        pauseEnd = LocalTime.now();
        chronometerStarted = true;
    }

    public String getIntermediate() {
        Duration activePause = Duration.ZERO;
        if (chronometerStarted) {
            LocalTime intermediateTimeTemp = LocalTime.now();
            if (pauseCounter == 1 && intermediateTime.isBefore(pauseStart)) {
                activePause = Duration.between(pauseStart, intermediateTimeTemp);
            }
            else if (pauseCounter == 1 && intermediateTime.isAfter(pauseStart)) {
                activePause = Duration.between(intermediateTime, intermediateTimeTemp);
            }
            else if (pauseCounter == 0 && intermediateTime.isAfter(pauseStart) && intermediateTime.isBefore(pauseEnd)) {
                activePause = Duration.between(intermediateTime, pauseEnd);
            }
            Duration dur = Duration.between(intermediateTime, intermediateTimeTemp).minus(pausesBetweenIntermediates)
                    .minus(activePause);
            intermediateTime = intermediateTimeTemp;
            pausesBetweenIntermediates = Duration.ZERO;

            return formatTime(dur.getSeconds());
        }
        else {
            return "0";
        }
    }

    public void pause() {
        if (chronometerStarted) {
            if (pauseCounter == 0) {
                pauseStart = LocalTime.now();
                pauseCounter = 1;
            }
            else {
                pauseEnd = LocalTime.now();
                pause = pause.plus(Duration.between(pauseStart, pauseEnd));
                if (pauseStart.isAfter(intermediateTime)) {
                    pausesBetweenIntermediates = pausesBetweenIntermediates.plus(Duration.between(pauseStart, pauseEnd));
                }
                pauseCounter = 0;
            }
        }
    }

    public String stop() {
        if (chronometerStarted) {
            stopTime = LocalTime.now();
            if (pauseCounter == 1) {
                pause = pause.plus(Duration.between(pauseStart, stopTime));
            }
            Duration dur = Duration.between(startTime, stopTime).minus(pause);
            chronometerStarted = false;
            return formatTime(dur.getSeconds());
        }
        else {
            return "0";
        }
    }

    private String formatTime(long seconds) {
        long absSeconds = Math.abs(seconds);
        String intermTime = String.format("%d:%02d:%02d", absSeconds / 3600, (absSeconds % 3600) / 60, absSeconds % 60);
        return intermTime;
    }
    
	public void chronometerWork() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			int button = sc.nextInt();

			switch (button) {
			case 1:
				this.start();
			case 2:
				this.pause();
			case 3:
				System.out.println(this.getIntermediate());
			case 4:
				System.out.println(this.stop());
			}
		}
	}
}
