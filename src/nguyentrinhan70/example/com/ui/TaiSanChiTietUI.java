package nguyentrinhan70.example.com.ui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TaiSanChiTietUI extends JDialog {
	JTextField txtMa, txtTen, txtNgayNhap, txtSoNamKhauHao, txtGiaTri;
	JButton btnLuu;
	
	Connection conn = TaiSanUI.conn;
	Statement statement = TaiSanUI.statement;
	public static  int ketqua = -1;
	public TaiSanChiTietUI(String title){
		this.setTitle(title);
		addControls();
		addEvents();
	}

	private void addEvents() {
	 btnLuu.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			xuLyLuu();
			
		}
	});
		
	}

	protected void xuLyLuu() {
		try{
			String sql = "insert into taisan values('"+txtMa.getText()+"',"
					+ "'"+txtTen.getText()+"', '"+txtNgayNhap.getText()+"',"
							+ "'"+txtSoNamKhauHao.getText()+"','"+txtGiaTri.getText()+"')";
			statement = conn.createStatement();
			int x = statement.executeUpdate(sql);
			ketqua = x; 
			dispose();//ẩn màn hình
			
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
	}

	private void addControls() {
		// TODO Auto-generated method stub
		Container con = getContentPane();
		con.setLayout(new BoxLayout(con,BoxLayout.Y_AXIS));
		JPanel pnMa = new JPanel();
		pnMa.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblMa = new JLabel("Mã tài sản:");
		txtMa = new JTextField(20);
		pnMa.add(lblMa);
		pnMa.add(txtMa);
		con.add(pnMa);
		
		JPanel pnTen = new JPanel();
		pnTen.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblTen = new JLabel("Tên tài sản:");
		txtTen = new JTextField(20);
		pnTen.add(lblTen);
		pnTen.add(txtTen);
		con.add(pnTen);
		
		JPanel pnNgayNhap = new JPanel();
		pnNgayNhap.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblNgayNhap = new JLabel("Ngày Nhập:");
		txtNgayNhap = new JTextField(20);
		pnNgayNhap.add(lblNgayNhap);
		pnNgayNhap.add(txtNgayNhap);
		con.add(pnNgayNhap);
		
		JPanel pnKhauHao = new JPanel();
		pnKhauHao.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblKhauHao = new JLabel("số năm khấu hao:");
		txtSoNamKhauHao = new JTextField(20);
		pnKhauHao.add(lblKhauHao);
		pnKhauHao.add(txtSoNamKhauHao);
		con.add(pnKhauHao);
		
		JPanel pnGiaTri = new JPanel();
		pnGiaTri.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel lblGiaTri = new JLabel("Giá trị:");
		txtGiaTri = new JTextField(20);
		pnGiaTri.add(lblGiaTri);
		pnGiaTri.add(txtGiaTri);
		con.add(pnGiaTri);
		
		lblMa.setPreferredSize(lblKhauHao.getPreferredSize());
		lblTen.setPreferredSize(lblKhauHao.getPreferredSize());
		lblNgayNhap.setPreferredSize(lblKhauHao.getPreferredSize());
		lblGiaTri.setPreferredSize(lblKhauHao.getPreferredSize());
		
		JPanel pnButton = new JPanel();
		pnButton.setLayout(new FlowLayout(FlowLayout.LEFT));
		btnLuu = new JButton("Lưu");
		pnButton.add(btnLuu);
		con.add(pnButton);
		
		
	}
	public void showWindow(){
		this.setSize(500,300);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setModal(true);
		this.setVisible(true);
	}

}
	