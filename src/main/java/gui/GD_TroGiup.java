package gui;

import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import javax.swing.border.EtchedBorder;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class GD_TroGiup extends JPanel {

	private static final long serialVersionUID = 1L;

	public GD_TroGiup() {
		setBackground(new Color(246, 245, 255));
		setLayout(null);
		setSize(1140, 865);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1140, 60);
		panel.setBackground(new Color(187, 231, 252));
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRỢ GIÚP");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 28));
		lblNewLabel.setBounds(0, 0, 1140, 60);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		panel.add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.window);
		panel_1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
				"Các phím tắt", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		panel_1.setBounds(10, 70, 1120, 240);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblThngK_1 = new JLabel("+ Nếu ô tìm kiếm sẽ thực hiện tìm");
		lblThngK_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblThngK_1.setBounds(772, 155, 280, 30);
		panel_1.add(lblThngK_1);
		
		JLabel lblF_3_1 = new JLabel("DEL:");
		lblF_3_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_3_1.setBounds(645, 35, 45, 30);
		panel_1.add(lblF_3_1);
		
		JLabel lblXaDLiu = new JLabel("Xóa dữ liệu đã chọn");
		lblXaDLiu.setFont(new Font("Arial", Font.BOLD, 16));
		lblXaDLiu.setBounds(772, 35, 160, 30);
		panel_1.add(lblXaDLiu);
		
		JLabel lblF_4_1 = new JLabel("ESC + CTRL:");
		lblF_4_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_4_1.setBounds(645, 75, 100, 30);
		panel_1.add(lblF_4_1);
		
		JLabel lblThotChngTrnh = new JLabel("Thoát chương trình");
		lblThotChngTrnh.setFont(new Font("Arial", Font.BOLD, 16));
		lblThotChngTrnh.setBounds(772, 75, 150, 30);
		panel_1.add(lblThotChngTrnh);
		
		JLabel lblF_5_1 = new JLabel("CTRL + O:");
		lblF_5_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_5_1.setBounds(645, 115, 100, 30);
		panel_1.add(lblF_5_1);
		
		JLabel lblngXutTi = new JLabel("Đăng xuất tài khoản");
		lblngXutTi.setFont(new Font("Arial", Font.BOLD, 16));
		lblngXutTi.setBounds(772, 115, 160, 30);
		panel_1.add(lblngXutTi);
		
		JLabel lblF_2_2_1 = new JLabel("ENTER:");
		lblF_2_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_2_2_1.setBounds(645, 155, 71, 30);
		panel_1.add(lblF_2_2_1);
		
		JLabel lblTrGip_1 = new JLabel("+ Nếu ô nhập sẽ kết thúc nhập dữ liệu");
		lblTrGip_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblTrGip_1.setBounds(772, 195, 309, 30);
		panel_1.add(lblTrGip_1);
		
		JLabel f1 = new JLabel("F1:");
		f1.setFont(new Font("Arial", Font.BOLD, 16));
		f1.setBounds(50, 35, 45, 30);
		panel_1.add(f1);
		
		JLabel lblTrangCh = new JLabel("Trang chủ");
		lblTrangCh.setFont(new Font("Arial", Font.BOLD, 16));
		lblTrangCh.setBounds(91, 35, 100, 30);
		panel_1.add(lblTrangCh);
		
		JLabel f2 = new JLabel("F2:");
		f2.setFont(new Font("Arial", Font.BOLD, 16));
		f2.setBounds(50, 75, 45, 30);
		panel_1.add(f2);
		
		JLabel lblBnSnPhm = new JLabel("Bán sản phẩm");
		lblBnSnPhm.setFont(new Font("Arial", Font.BOLD, 16));
		lblBnSnPhm.setBounds(91, 75, 120, 30);
		panel_1.add(lblBnSnPhm);
		
		JLabel lblF = new JLabel("F3:");
		lblF.setFont(new Font("Arial", Font.BOLD, 16));
		lblF.setBounds(50, 115, 45, 30);
		panel_1.add(lblF);
		
		JLabel lblTrSnPhm = new JLabel("Trả sản phẩm");
		lblTrSnPhm.setFont(new Font("Arial", Font.BOLD, 16));
		lblTrSnPhm.setBounds(91, 115, 120, 30);
		panel_1.add(lblTrSnPhm);
		
		JLabel lblF_2 = new JLabel("F4:");
		lblF_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_2.setBounds(50, 155, 45, 30);
		panel_1.add(lblF_2);
		
		JLabel lblKhuynMi = new JLabel("Khuyến mãi");
		lblKhuynMi.setFont(new Font("Arial", Font.BOLD, 16));
		lblKhuynMi.setBounds(91, 155, 120, 30);
		panel_1.add(lblKhuynMi);
		
		JLabel lblF_2_1 = new JLabel("F5:");
		lblF_2_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_2_1.setBounds(50, 195, 45, 30);
		panel_1.add(lblF_2_1);
		
		JLabel lblQunLNhn = new JLabel("Quản lý nhân viên");
		lblQunLNhn.setFont(new Font("Arial", Font.BOLD, 16));
		lblQunLNhn.setBounds(91, 195, 150, 30);
		panel_1.add(lblQunLNhn);
		
		JLabel lblF_3 = new JLabel("F6:");
		lblF_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_3.setBounds(320, 35, 45, 30);
		panel_1.add(lblF_3);
		
		JLabel lblQunLKhch = new JLabel("Quản lý khách hàng");
		lblQunLKhch.setFont(new Font("Arial", Font.BOLD, 16));
		lblQunLKhch.setBounds(364, 35, 160, 30);
		panel_1.add(lblQunLKhch);
		
		JLabel lblF_4 = new JLabel("F7:");
		lblF_4.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_4.setBounds(320, 75, 45, 30);
		panel_1.add(lblF_4);
		
		JLabel lblQunLSn = new JLabel("Quản lý sản phẩm");
		lblQunLSn.setFont(new Font("Arial", Font.BOLD, 16));
		lblQunLSn.setBounds(364, 75, 150, 30);
		panel_1.add(lblQunLSn);
		
		JLabel lblF_5 = new JLabel("F8:");
		lblF_5.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_5.setBounds(320, 115, 45, 30);
		panel_1.add(lblF_5);
		
		JLabel lblQunLHa = new JLabel("Quản lý hóa đơn");
		lblQunLHa.setFont(new Font("Arial", Font.BOLD, 16));
		lblQunLHa.setBounds(364, 115, 150, 30);
		panel_1.add(lblQunLHa);
		
		JLabel lblF_2_2 = new JLabel("F9:");
		lblF_2_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_2_2.setBounds(320, 155, 45, 30);
		panel_1.add(lblF_2_2);
		
		JLabel lblThngK = new JLabel("Thống kê");
		lblThngK.setFont(new Font("Arial", Font.BOLD, 16));
		lblThngK.setBounds(364, 155, 120, 30);
		panel_1.add(lblThngK);
		
		JLabel lblF_2_1_1 = new JLabel("F10:");
		lblF_2_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_2_1_1.setBounds(320, 195, 45, 30);
		panel_1.add(lblF_2_1_1);
		
		JLabel lblTrGip = new JLabel("Trợ giúp");
		lblTrGip.setFont(new Font("Arial", Font.BOLD, 16));
		lblTrGip.setBounds(364, 195, 150, 30);
		panel_1.add(lblTrGip);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2),
						"Thông tin liên hệ", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		panel_1_1.setBackground(SystemColor.window);
		panel_1_1.setBounds(673, 650, 457, 185);
		add(panel_1_1);
		
		JLabel lblTrGip_1_1 = new JLabel("+ Nếu ô nhập sẽ kết thúc nhập dữ liệu");
		lblTrGip_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblTrGip_1_1.setBounds(772, 195, 309, 30);
		panel_1_1.add(lblTrGip_1_1);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Arial", Font.BOLD, 16));
		lblEmail.setBounds(32, 35, 62, 30);
		panel_1_1.add(lblEmail);
		
		JLabel lblSinThoi = new JLabel("Số điện thoại:");
		lblSinThoi.setFont(new Font("Arial", Font.BOLD, 16));
		lblSinThoi.setBounds(32, 85, 120, 30);
		panel_1_1.add(lblSinThoi);
		
		JLabel lblEmail_1_1_1 = new JLabel("Các trang mạng xã hội:");
		lblEmail_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblEmail_1_1_1.setBounds(32, 134, 200, 30);
		panel_1_1.add(lblEmail_1_1_1);
		
		JLabel lblNguyenhunganhgmailcom = new JLabel("nguyenhunganh123456@gmail.com");
		lblNguyenhunganhgmailcom.setFont(new Font("Arial", Font.BOLD, 16));
		lblNguyenhunganhgmailcom.setBounds(104, 35, 369, 30);
		panel_1_1.add(lblNguyenhunganhgmailcom);
		
		JLabel lblNguyenhunganhgmailcom_1 = new JLabel("0341234567");
		lblNguyenhunganhgmailcom_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblNguyenhunganhgmailcom_1.setBounds(162, 85, 369, 30);
		panel_1_1.add(lblNguyenhunganhgmailcom_1);
		
		JPanel panel_1_1_1 = new JPanel();
		panel_1_1_1.setLayout(null);
		panel_1_1_1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2), "Sơ đồ màn hình", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		panel_1_1_1.setBackground(SystemColor.window);
		panel_1_1_1.setBounds(10, 320, 653, 515);
		add(panel_1_1_1);
		
		JLabel soDoManHinh = new JLabel("");
		soDoManHinh.setIcon(new ImageIcon("C:\\Users\\Thong\\Downloads\\Picture1.png"));
		soDoManHinh.setBounds(10, 22, 633, 483);
		panel_1_1_1.add(soDoManHinh);
		
		JPanel thongTinTuKhoa = new JPanel();
		thongTinTuKhoa.setLayout(null);
		thongTinTuKhoa.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY, 2), "Các từ khóa", TitledBorder.LEFT, TitledBorder.CENTER, new Font("Arial", Font.BOLD, 20), Color.DARK_GRAY));
		thongTinTuKhoa.setBackground(SystemColor.window);
		thongTinTuKhoa.setBounds(673, 320, 457, 320);
		add(thongTinTuKhoa);
		
		JLabel lblSnPhm = new JLabel("Sản phẩm");
		lblSnPhm.setFont(new Font("Arial", Font.BOLD, 16));
		lblSnPhm.setBounds(87, 38, 160, 30);
		thongTinTuKhoa.add(lblSnPhm);
		
		JLabel lblF_3_2 = new JLabel("SP:");
		lblF_3_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_3_2.setBounds(32, 38, 45, 30);
		thongTinTuKhoa.add(lblF_3_2);
		
		JLabel lblHan = new JLabel("Hóa đơn");
		lblHan.setFont(new Font("Arial", Font.BOLD, 16));
		lblHan.setBounds(87, 78, 150, 30);
		thongTinTuKhoa.add(lblHan);
		
		JLabel lblF_4_2 = new JLabel("HD:");
		lblF_4_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_4_2.setBounds(32, 78, 45, 30);
		thongTinTuKhoa.add(lblF_4_2);
		
		JLabel lblF_5_2 = new JLabel("NV:");
		lblF_5_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_5_2.setBounds(32, 118, 45, 30);
		thongTinTuKhoa.add(lblF_5_2);
		
		JLabel lblNhnVin = new JLabel("Nhân viên");
		lblNhnVin.setFont(new Font("Arial", Font.BOLD, 16));
		lblNhnVin.setBounds(87, 118, 150, 30);
		thongTinTuKhoa.add(lblNhnVin);
		
		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setFont(new Font("Arial", Font.BOLD, 16));
		lblKhchHng.setBounds(87, 158, 120, 30);
		thongTinTuKhoa.add(lblKhchHng);
		
		JLabel lblF_2_2_2 = new JLabel("KH:");
		lblF_2_2_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_2_2_2.setBounds(32, 158, 45, 30);
		thongTinTuKhoa.add(lblF_2_2_2);
		
		JLabel lblF_2_1_1_1 = new JLabel("SX:");
		lblF_2_1_1_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_2_1_1_1.setBounds(32, 198, 45, 30);
		thongTinTuKhoa.add(lblF_2_1_1_1);
		
		JLabel lblSnXut = new JLabel("Sản xuất");
		lblSnXut.setFont(new Font("Arial", Font.BOLD, 16));
		lblSnXut.setBounds(87, 198, 150, 30);
		thongTinTuKhoa.add(lblSnXut);
		
		JLabel lblF_3_3 = new JLabel("HH:");
		lblF_3_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_3_3.setBounds(32, 238, 45, 30);
		thongTinTuKhoa.add(lblF_3_3);
		
		JLabel lblHtHn = new JLabel("Hết hạn");
		lblHtHn.setFont(new Font("Arial", Font.BOLD, 16));
		lblHtHn.setBounds(86, 238, 139, 30);
		thongTinTuKhoa.add(lblHtHn);
		
		JLabel lblF_4_3 = new JLabel("DV:");
		lblF_4_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_4_3.setBounds(32, 278, 45, 30);
		thongTinTuKhoa.add(lblF_4_3);
		
		JLabel lblnV = new JLabel("Đơn vị");
		lblnV.setFont(new Font("Arial", Font.BOLD, 16));
		lblnV.setBounds(86, 278, 139, 30);
		thongTinTuKhoa.add(lblnV);
		
		JLabel lblF_5_3 = new JLabel("SL:");
		lblF_5_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_5_3.setBounds(257, 38, 45, 30);
		thongTinTuKhoa.add(lblF_5_3);
		
		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Arial", Font.BOLD, 16));
		lblSLng.setBounds(311, 38, 139, 30);
		thongTinTuKhoa.add(lblSLng);
		
		JLabel lblF_2_2_3 = new JLabel("DG:");
		lblF_2_2_3.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_2_2_3.setBounds(257, 78, 45, 30);
		thongTinTuKhoa.add(lblF_2_2_3);
		
		JLabel lblnGi = new JLabel("Đơn giá");
		lblnGi.setFont(new Font("Arial", Font.BOLD, 16));
		lblnGi.setBounds(311, 78, 120, 30);
		thongTinTuKhoa.add(lblnGi);
		
		JLabel lblF_2_1_1_2 = new JLabel("SDT:");
		lblF_2_1_1_2.setFont(new Font("Arial", Font.BOLD, 16));
		lblF_2_1_1_2.setBounds(257, 118, 45, 30);
		thongTinTuKhoa.add(lblF_2_1_1_2);
		
		JLabel lblSinThoi_1 = new JLabel("Số điện thoại");
		lblSinThoi_1.setFont(new Font("Arial", Font.BOLD, 16));
		lblSinThoi_1.setBounds(311, 118, 139, 30);
		thongTinTuKhoa.add(lblSinThoi_1);
	}
}
