package start;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import page.tests.DashboardPageTest;
import page.tests.LogInTest;
import page.tests.RegistrationTest;

public class GUImain extends JFrame {
	private JTextField txtLoginTest;
	private JTextField txtRegistrationTest;
	private JTextField txtNewPostTest;
	private JTextField txtDeleteLast;
	private JTextField txtEditLastPost;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUImain frame = new GUImain();
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
	public GUImain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 300);
		getContentPane().setLayout(null);

		txtLoginTest = new JTextField();
		txtLoginTest.setHorizontalAlignment(SwingConstants.CENTER);
		txtLoginTest.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtLoginTest.setText("LOGIN TEST");
		txtLoginTest.setBounds(40, 147, 139, 26);
		getContentPane().add(txtLoginTest);
		txtLoginTest.setColumns(10);

		txtRegistrationTest = new JTextField();
		txtRegistrationTest.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtRegistrationTest.setHorizontalAlignment(SwingConstants.CENTER);
		txtRegistrationTest.setText("REGISTRATION TEST");
		txtRegistrationTest.setColumns(10);
		txtRegistrationTest.setBounds(202, 147, 139, 26);
		getContentPane().add(txtRegistrationTest);

		txtNewPostTest = new JTextField();
		txtNewPostTest.setHorizontalAlignment(SwingConstants.CENTER);
		txtNewPostTest.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtNewPostTest.setText("MAKE NEW POST TEST");
		txtNewPostTest.setColumns(10);
		txtNewPostTest.setBounds(367, 147, 139, 26);
		getContentPane().add(txtNewPostTest);

		txtDeleteLast = new JTextField();
		txtDeleteLast.setHorizontalAlignment(SwingConstants.CENTER);
		txtDeleteLast.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtDeleteLast.setText("DELETE 2 LAST POSTS TEST");
		txtDeleteLast.setColumns(10);
		txtDeleteLast.setBounds(530, 147, 163, 26);
		getContentPane().add(txtDeleteLast);

		txtEditLastPost = new JTextField();
		txtEditLastPost.setHorizontalAlignment(SwingConstants.CENTER);
		txtEditLastPost.setFont(new Font("Tahoma", Font.BOLD, 10));
		txtEditLastPost.setText("EDIT LAST POST TEST");
		txtEditLastPost.setColumns(10);
		txtEditLastPost.setBounds(714, 147, 139, 26);
		getContentPane().add(txtEditLastPost);

		JButton btnNewButton = new JButton("MANUAL");
		btnNewButton.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					LogInTest.logInGUI();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnNewButton.setBounds(40, 172, 139, 23);
		getContentPane().add(btnNewButton);

		JButton btnAutomatic = new JButton("AUTOMATIC");
		btnAutomatic.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnAutomatic.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAutomatic.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				LogInTest.logInExcelAll();
			}
		});
		btnAutomatic.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnAutomatic.setBounds(40, 194, 139, 23);
		getContentPane().add(btnAutomatic);

		JButton btnManual = new JButton("MANUAL");
		btnManual.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnManual.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnManual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					RegistrationTest.registrationGUI();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnManual.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnManual.setBounds(202, 172, 139, 23);
		getContentPane().add(btnManual);

		JButton btnAutomatic_1 = new JButton("AUTOMATIC");
		btnAutomatic_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnAutomatic_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAutomatic_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					RegistrationTest.registrationExcelAll();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAutomatic_1.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnAutomatic_1.setBounds(202, 194, 139, 23);
		getContentPane().add(btnAutomatic_1);

		JButton btnManual_1 = new JButton("MANUAL");
		btnManual_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnManual_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnManual_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DashboardPageTest.makeNewPostGUI();
					DashboardPageTest.makeNewPostGUI();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnManual_1.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnManual_1.setBounds(367, 172, 139, 23);
		getContentPane().add(btnManual_1);

		JButton btnAutomatic_2 = new JButton("AUTOMATIC");
		btnAutomatic_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnAutomatic_2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAutomatic_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DashboardPageTest.makeNewPostExcel();
					DashboardPageTest.makeNewPostExcel();
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnAutomatic_2.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnAutomatic_2.setBounds(367, 194, 139, 23);
		getContentPane().add(btnAutomatic_2);

		JButton btnStart = new JButton("AUTOMATIC");
		btnStart.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnStart.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					DashboardPageTest.deleteTwoLastPost();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnStart.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnStart.setBounds(530, 194, 163, 23);
		getContentPane().add(btnStart);

		JButton btnStart_1 = new JButton("AUTOMATIC");
		btnStart_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		btnStart_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnStart_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				try {
					DashboardPageTest.editLastPostExcelGUI();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnStart_1.setFont(new Font("Dialog", Font.PLAIN, 10));
		btnStart_1.setBounds(714, 191, 139, 23);
		getContentPane().add(btnStart_1);

		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(367, 350, -250, -69);
		getContentPane().add(desktopPane);

		JLabel lblNewLabel = new JLabel("IZLET testing");
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBorder(new LineBorder(Color.DARK_GRAY, 1, true));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(143, 54, 578, 50);
		getContentPane().add(lblNewLabel);

		JButton button = new JButton("MANUAL");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				DashboardPageTest.editLastPostGUI();
			}
		});
		button.setFont(new Font("Dialog", Font.PLAIN, 10));
		button.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		button.setBounds(714, 172, 139, 23);
		getContentPane().add(button);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(529, 172, 164, 23);
		getContentPane().add(btnNewButton_1);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
