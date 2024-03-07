package Clock;

import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Clock extends JPanel {
	private static JLabel timeLabel;
	private static JLabel timeLabel2;

	public Clock() {
		setBounds(0, 0, 200, 100);
		setLayout(new FlowLayout());
		timeLabel = new JLabel();
		add(timeLabel);

		setBounds(0, 0, 200, 100);
		setLayout(new FlowLayout());
		timeLabel2 = new JLabel();
		add(timeLabel2);
	}

	public void Start() {
		new Thread(() -> {
			while (true) {
				updateTime();
			}
		}).start();
	}

	private static void updateTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		timeLabel.setText(dateFormat.format(new Date()));

	}
}