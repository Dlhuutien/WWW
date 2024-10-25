package fit.iuh.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import fit.iuh.dao.NhanVienDAO;
import fit.iuh.daoImpl.NhanVienDAOImpl;
import fit.iuh.models.NhanVien;
import fit.iuh.models.PhongBan;
import fit.iuh.utils.EntityManagerFactoryUtil;

/**
 * Servlet implementation class ThemNhanVienServlet
 */
@WebServlet(urlPatterns = "/nhanVienForm")
public class ThemNhanVienServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private EntityManagerFactoryUtil entityManagerFactoryUtil;
	private NhanVienDAO nhanVienDAO;
       
    /** 
     * @see HttpServlet#HttpServlet()
     */
    public ThemNhanVienServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	// TODO Auto-generated method stub
    	super.init();
    	entityManagerFactoryUtil = new EntityManagerFactoryUtil();
    	nhanVienDAO = new NhanVienDAOImpl(this.entityManagerFactoryUtil.getEnManager());
    }
    @Override
    public void destroy() {
    	// TODO Auto-generated method stub
    	entityManagerFactoryUtil.close();
    	super.destroy();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("views/ThemNhanVien.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		themNhanVien(request, response);
	}
	public void themNhanVien(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tenNV = request.getParameter("tenNV");
		String diaChi = request.getParameter("diaChi");
		String email = request.getParameter("email");
		String dienThoai = request.getParameter("dienThoai");
		String maPB = request.getParameter("maPhongBan");
		PhongBan pb = new PhongBan(Integer.parseInt(maPB));
		
		NhanVien nv = new NhanVien();
		nv.setTenNV(tenNV);
		nv.setDiaChi(diaChi);
		nv.setEmail(email);
		nv.setDienThoai(dienThoai);
		nv.setPhongBan(pb);
		
		nhanVienDAO.addNhanVien(nv);
		response.sendRedirect(request.getContextPath() + "/list");
	}

}
