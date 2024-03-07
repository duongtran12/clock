package Clock;

import java.awt.EventQueue;
import java.lang.String;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField text;
	private JPanel newClock;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
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
	public Main() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 416, 124);
		contentPane.add(panel);
		panel.setLayout(null);
		Clock clock = new Clock();
		clock.setBounds(0, 0, 416, 124);
		panel.add(clock);

		JButton bt = new JButton("Open");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

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

		JLabel la1 = new JLabel("");
		la1.setBounds(137, 132, 45, 13);
		contentPane.add(la1);
		clock.Start();
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
					newClock.setToolTipText(currentTime);
				}
			});
			timer.start();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}