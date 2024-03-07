package Clock;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class Clock_n extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text;
	private Main main;
	private JLabel la1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clock_n frame = new Clock_n();
					// frame.startClock(10, 10, 10);

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Clock_n() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton bt = new JButton("Open");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				main = new Main();
				main.setVisible(true);

				String tex = text.getText();
				String[] a = tex.split(":");
				int number1 = Integer.parseInt(a[0]);
				int number2 = Integer.parseInt(a[1]);
				int number3 = Integer.parseInt(a[2]);

				Clock_n frame = new Clock_n();
				frame.startClock(number1, number2, number3);
				frame.setVisible(true);

			}
		});
		bt.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bt.setBounds(284, 157, 113, 51);
		contentPane.add(bt);
		getContentPane().add(bt);

		text = new JTextField();
		text.setBounds(34, 157, 240, 49);
		contentPane.add(text);
		text.setColumns(10);

		la1 = new JLabel();
		la1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		la1.setHorizontalAlignment(SwingConstants.CENTER);
		la1.setBounds(10, 10, 416, 118);
		contentPane.add(la1);
	}

	public void startClock(int hour, int minute, int second) {
		try {
			Calendar calendar = Calendar.getInstance();
			calendar.set(Calendar.HOUR_OF_DAY, hour);
			calendar.set(Calendar.MINUTE, minute);
			calendar.set(Calendar.SECOND, second);

			SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
			Timer timer = new Timer(1000, new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					calendar.add(Calendar.SECOND, 1);
					String currentTime = dateFormat.format(calendar.getTime());
					la1.setText(currentTime);
				}
			});
			timer.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}