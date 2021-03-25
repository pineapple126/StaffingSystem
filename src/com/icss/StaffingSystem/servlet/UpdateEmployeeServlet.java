package com.icss.StaffingSystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.StaffingSystem.service.EmployeeService;

/**
 * Servlet implementation class UpdateEmployeeServlet
 */
public class UpdateEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * ����ʵ���޸�ָ��Ա����Ϣ�� Servlet
     * @author pineapple126
     */
    public UpdateEmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			// 1.��������
			//���յõ�Ҫ�޸ĵ�Ա�����
			String id = request.getParameter("id");
			//���յõ��޸ĵ�Ա��������
			String name = request.getParameter("name");
			//���յõ��޸ĵ�Ա�������֤����
			String cardid = request.getParameter("cardId");
			//���յõ��޸ĵ�Ա�����Ա�
			String sex = request.getParameter("sex");
			//���յõ��޸ĵ�Ա����������ְλ���
			String jobid = request.getParameter("job_id");
			//���յõ��޸ĵ�Ա����ѧ��
			String education = request.getParameter("education");
			//���յõ��޸ĵ�Ա��������
			String email = request.getParameter("email");
			//���յõ��޸ĵ�Ա�����ֻ�����
			String phone = request.getParameter("phone");
			//���յõ��޸ĵ�Ա���ĵ绰����
			String tel = request.getParameter("tel");
			//���յõ��޸ĵ�Ա����������ò
			String party = request.getParameter("party");
			//���յõ��޸ĵ�Ա����qq����
			String qqnum = request.getParameter("qqNum");
			//���յõ��޸ĵ�Ա������ϵ��ַ
			String address = request.getParameter("address");
			//���յõ��޸ĵ�Ա�����ʱ�
			String postcode = request.getParameter("postCode");
			//���յõ��޸ĵ�Ա���ĳ�������
			String birthday = request.getParameter("birthday");
			//���յõ��޸ĵ�Ա��������
			String race = request.getParameter("race");
			//���յõ��޸ĵ�Ա������ѧרҵ
			String speciality = request.getParameter("speciality");
			//���յõ��޸ĵ�Ա���İ���
			String hobby = request.getParameter("hobby");
			//���յõ��޸ĵ�Ա���ı�ע
			String remark = request.getParameter("remark");
			//���յõ��޸ĵ�Ա�����������ű��
			String depid = request.getParameter("dept_id");
			//���յõ��޸ĵ�Ա��������н�ʷ�Χ���
			String levelid = request.getParameter("levelid");
			//���յõ��޸ĵ�Ա����н��
			String salary = request.getParameter("salary");
				
			// 2.��������
			EmployeeService employeeService = new EmployeeService();
			employeeService.updateEmployee(Integer.parseInt(id), name, cardid, sex, Integer.parseInt(jobid), education, email, phone, tel, party, qqnum, address, postcode, birthday, race, speciality, hobby, remark, Integer.parseInt(depid), Integer.parseInt(levelid), Double.parseDouble(salary));
			
			// 3.�����ת
			
			request.getRequestDispatcher("/employee/EmployeeListServlet").forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
