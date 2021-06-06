package registrations.service;

import registrations.dao.RegistrationDao;
import registrations.service.Service;
import registrations.vo.Subject;

public class Service {
	private static Service service = new Service();
	private Service() {}
	private RegistrationDao dao = RegistrationDao.getInstance();
	public static Service getInstance()
	{
		return service;
	}
	public boolean Slogin(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.Slogin(id,pwd);
	}
	public boolean Plogin(String id, String pwd) {
		// TODO Auto-generated method stub
		return dao.Plogin(id,pwd);
	}
	public void enrollSubject(Subject subject) {
		// TODO Auto-generated method stub
		dao.enrollSubject(subject);
	}
}
